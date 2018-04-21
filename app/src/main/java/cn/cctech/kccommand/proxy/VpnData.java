package cn.cctech.kccommand.proxy;


import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import com.google.common.collect.EvictingQueue;
import com.google.common.primitives.Bytes;
import com.google.gson.JsonObject;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VpnData {

    private static final String TAG = "VpnData";

    public static Handler handler;

    private static final int NONE = 0;
    private static final int REQUEST = 1;
    private static final int RESPONSE = 2;
    private static final String KCA_API_VPN_DATA_ERROR = "/kca_api/vpn_data_error";
    // Full Server List: http://kancolle.wikia.com/wiki/Servers
    // 2017.10.18: Truk and Ringga Server was moved.
    private static String[] kcaServerPrefixList = {
            "203.104.209", // Yokosuka, Kure, Truk, Ringga, Kanoya, Iwagawa, Saikiman, Hashirajima, Android Server
            "125.6.189", // Shortland, Buin, Tawi-Tawi, Palau, Brunel, Hittokappuman, Paramushir, Sukumoman
            "125.6.187", // Maizuru, Ominato
            "125.6.184", // Sasebo
            "203.104.248"  // Rabaul
    };
    public static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static int state = NONE;
    public static byte[] requestData = {};
    public static byte[] responseData = {};

    static boolean isRequestUriReady = false;
    static String requestUri = "";
    static boolean gzipflag = false;
    static boolean chunkflag = false;
    static boolean isreadyflag = false;

    static int responseBodyLength = -1;

    private static SparseArray<String> portToUri = new SparseArray<>();
    private static SparseArray<StringBuilder> portToRequestData = new SparseArray<>();
    private static SparseArray<Byte[]> portToResponseData = new SparseArray<>();
    private static SparseIntArray portToResponseHeaderLength = new SparseIntArray();
    private static SparseIntArray portToLength = new SparseIntArray();
    private static SparseBooleanArray portToGzipped = new SparseBooleanArray();
    private static SparseArray<String> portToResponseHeaderPart = new SparseArray<>();

    private static Queue<Integer> ignoreResponseList = EvictingQueue.create(32);

    public static void setHandler(Handler h) {
        handler = h;
    }

    // Called from native code
    private static int containsKcaServer(int type, byte[] source, byte[] target) {
        String saddrstr = new String(source);
        String taddrstr = new String(target);
        if (type == REQUEST) {
            for (String prefix : kcaServerPrefixList) {
                if (taddrstr.startsWith(prefix)) return 1;
            }
        } else if (type == RESPONSE) {
            for (String prefix : kcaServerPrefixList) {
                if (saddrstr.startsWith(prefix)) return 1;
            }
        }
        //Log.e(TAG, String.format("containsKcaServer[%d] %s => %s", type, saddrstr, taddrstr));
        return 0;
    }

    // Called from native code
    private static void getDataFromNative(byte[] data, int size, int type, byte[] source, byte[] target, int sport, int tport) {
        try {
            String s = new String(data);
            String saddrstr = new String(source);
            String taddrstr = new String(target);
            //Log.e(TAG, String.format("getDataFromNative[%d] %s:%d => %s:%d", type, saddrstr, sport, taddrstr, tport));

            if (type == REQUEST) {
                if (s.startsWith("GET") || s.startsWith("POST")) {
                    isRequestUriReady = false;
                    state = REQUEST;
                    portToRequestData.put(sport, new StringBuilder());
                }
                if (portToRequestData.get(sport) == null) return;
                else portToRequestData.get(sport).append(s);

                if (!isRequestUriReady && portToRequestData.get(sport).toString().contains("HTTP/1.1")) {
                    isRequestUriReady = true;
                    String[] head_line = portToRequestData.get(sport).toString().split("\r\n");
                    requestUri = head_line[0].split(" ")[1];
                    portToUri.put(sport, requestUri);
                    Log.e(TAG, requestUri);
                    if (!checkKcRes(requestUri)) {
                        portToResponseData.put(sport, new Byte[]{});
                        portToResponseHeaderPart.put(sport, "");
                        portToGzipped.put(sport, false);
                        portToLength.put(sport, 0);
                        if (ignoreResponseList.contains(sport)) {
                            ignoreResponseList.remove(sport);
                        }
                    } else {
                        if (!ignoreResponseList.contains(sport)) {
                            ignoreResponseList.add(sport);
                        }
                        Log.e(TAG, ignoreResponseList.toString());
                    }
                }
            } else if (type == RESPONSE) {
                state = RESPONSE;
                if (ignoreResponseList.contains(tport)) {
                    Log.e(TAG, portToUri.get(tport) + " ignored");
                    return;
                }
                if (portToResponseHeaderPart.indexOfKey(tport) >= 0 && portToResponseHeaderPart.get(tport).length() == 0) {
                    portToResponseData.put(tport, new Byte[]{});
                    String prevResponseHeaderPart = portToResponseHeaderPart.get(tport);
                    String responseDataStr = new String(data);
                    if (!responseDataStr.contains("\r\n\r\n")) {
                        portToResponseHeaderPart.put(tport, prevResponseHeaderPart.concat(responseDataStr));
                    } else {
                        portToResponseHeaderPart.put(tport, prevResponseHeaderPart.concat(responseDataStr.split("\r\n\r\n", 2)[0]));
                        portToResponseHeaderLength.put(tport, portToResponseHeaderPart.get(tport).length());
                        String[] headers = portToResponseHeaderPart.get(tport).split("\r\n");
                        for (String line : headers) {
                            if (line.startsWith("Content-Encoding: ")) {
                                portToGzipped.put(tport, line.contains("gzip"));
                                Log.e(TAG, String.valueOf(tport) + " gzip " + portToGzipped.get(tport));
                            } else if (line.startsWith("Transfer-Encoding")) {
                                if (line.contains("chunked")) {
                                    portToLength.put(tport, -1);
                                    responseBodyLength = -1;
                                }
                            } else if (line.startsWith("Content-Length")) {
                                portToLength.put(tport, Integer.parseInt(line.replaceAll("Content-Length: ", "").trim()));
                                responseBodyLength = Integer.parseInt(line.replaceAll("Content-Length: ", "").trim());
                            }
                        }
                    }
                }

                boolean chunkflag = (portToLength.get(tport) == -1);
                boolean gzipflag = portToGzipped.get(tport);
                Byte[] responsePrevData = portToResponseData.get(tport);
                portToResponseData.put(tport, ArrayUtils.toObject(Bytes.concat(ArrayUtils.toPrimitive(responsePrevData), data)));
                if (portToLength.get(tport) == -1 && isChunkEnd(ArrayUtils.toPrimitive(portToResponseData.get(tport)))) {
                    isreadyflag = true;
                } else if (portToResponseData.get(tport).length == portToResponseHeaderLength.get(tport) + 4 + portToLength.get(tport)) {
                    isreadyflag = true;
                }

                if (isreadyflag) {
                    String requestStr = portToRequestData.get(tport).toString();
                    String[] requestHeadBody = requestStr.split("\r\n\r\n", 2);
                    if (requestHeadBody.length > 1) {
                        byte[] requestBody = new byte[]{};
                        if (requestHeadBody[1].length() > 0) {
                            requestBody = requestHeadBody[1].getBytes();
                        }
                        byte[] responseData = ArrayUtils.toPrimitive(portToResponseData.get(tport));
                        byte[] responseBody = Arrays.copyOfRange(responseData, portToResponseHeaderLength.get(tport) + 4, responseData.length);
                    Log.e(TAG, String.valueOf(responseData.length));
                    Log.e(TAG, String.valueOf(portToResponseHeaderPart.get(tport).length()));
                    Log.e(TAG, "====================================");
                    if (chunkflag) {
                        Log.e(TAG, Utils.byteArrayToHex(Arrays.copyOfRange(responseBody, 0, 15)));
                        Log.e(TAG, Utils.byteArrayToHex(Arrays.copyOfRange(responseBody, responseBody.length - 15, responseBody.length)));
                        responseBody = unchunkAllData(responseBody, gzipflag);
                    } else if (gzipflag) {
                        Log.e(TAG, "Ungzip " + String.valueOf(tport));
                        responseBody = Utils.gzipdecompress(responseBody);
                    }

                    //Log.e(TAG, String.valueOf(responseData.length));
                    String requestUri = portToUri.get(tport);
                    if (checkKcApi(requestUri)) {
                        DataJob job = new DataJob(requestUri, requestBody, responseBody);
                        executorService.execute(job);
                    }
                    portToUri.delete(tport);
                    portToRequestData.delete(tport);
                    portToResponseData.delete(tport);
                    portToResponseHeaderLength.delete(tport);
                    portToLength.delete(tport);
                    portToGzipped.delete(tport);
                    isreadyflag = false;
                }
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
            String empty_request = "";
            JsonObject error_data = new JsonObject();
            error_data.addProperty("error", Utils.getStringFromException(e));
            error_data.addProperty("uri", requestUri);
            error_data.addProperty("request", requestData.toString());
            String responseDataStr = Utils.byteArrayToHex(responseData);
            if (responseDataStr.length() > 240) {
                error_data.addProperty("response", responseDataStr.substring(0, 240));
            } else {
                error_data.addProperty("response", responseDataStr);
            }
            DataJob job = new DataJob(KCA_API_VPN_DATA_ERROR, empty_request.getBytes(), error_data.toString().getBytes());
            executorService.execute(job);
            Log.e(TAG, Utils.getStringFromException(e));
        }
    }

    private static boolean checkKcApi(String uri) {
        boolean isKcaVer = uri.contains("/kca/version");
        boolean isKcsApi = uri.contains("/kcsapi/api_");
        //Log.e(TAG, uri + " " + String.valueOf(isKcaVer || isKcsApi));
        return (isKcaVer || isKcsApi);
    }

    private static boolean checkKcRes(String uri) {
        boolean isKcsSwf = uri.contains("/kc") && uri.contains(".swf");
        boolean isKcaRes = uri.contains("/kc") && uri.contains("/resources");
        boolean isKcsSound = uri.contains("/kcs/sound");
        boolean isKcsWorld = uri.contains("/api_world/get_id/");
        //Log.e(TAG, uri + " " + String.valueOf(isKcaVer || isKcsApi));
        return (isKcsSwf || isKcaRes || isKcsSound || isKcsWorld);
    }

    private static byte[] unchunkAllData(byte[] data, boolean gzipped) throws IOException {
        byte[] rawdata = Utils.unchunkdata(data);
        if (gzipped) rawdata = Utils.gzipdecompress(rawdata);
        //Log.e(TAG, new String(rawdata));
        return rawdata;
    }

    private static boolean isChunkEnd(byte[] data) {
        int dataLength = data.length;
        if (dataLength < 5) return false;
        byte[] chunkEndSignal = {48, 13, 10, 13, 10};
        byte[] endChunk = Arrays.copyOfRange(data, dataLength - 5, dataLength);
        return Arrays.equals(endChunk, chunkEndSignal);
    }
}
