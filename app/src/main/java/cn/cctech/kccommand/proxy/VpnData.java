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
    
    private static final String TAG = "CC";
    
    public static Handler handler;

    private static final int NONE = 0;
    private static final int REQUEST = 1;
    private static final int RESPONSE = 2;
    private static final String KCA_API_VPN_DATA_ERROR = "/kca_api/vpn_data_error";

    private static String[] kcaServerList = {
            "203.104.209.71",   // Yokosuka
            "203.104.209.87",   // Kure
            "125.6.184.16",     // Sasebo
            "125.6.187.205",    // Maizuru
            "125.6.187.229",    // Ominato
            "203.104.209.134",  // Truk
            "203.104.209.167",  // Ringga
            "203.104.248.135",  // Rabaul
            "125.6.189.7",      // Shortland
            "125.6.189.39",     // Buin
            "125.6.189.71",     // Tawi-Tawi
            "125.6.189.103",    // Palau
            "125.6.189.135",    // Brunei
            "125.6.189.167",    // Hittokappuman
            "125.6.189.215",    // Paramushir
            "125.6.189.247",    // Sukumoman
            "203.104.209.23",   // Kanoya
            "203.104.209.39",   // Iwagawa
            "203.104.209.55",   // Saikiman
            "203.104.209.102",  // Hashirajima

            "203.104.209.7"     // Kancolle Android Server
    };
    private static List<String> kcaServers = new ArrayList<String>(Arrays.asList(kcaServerList));
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

    private static Queue<Integer> ignoreResponseList = EvictingQueue.create(8);

    public static void setHandler(Handler h) {
        handler = h;
    }

    // Called from native code
    private static int containsKcaServer(int type, byte[] source, byte[] target) {
        String saddrstr = new String(source);
        String taddrstr = new String(target);
        if (type == REQUEST && !kcaServers.contains(taddrstr)) {
            return 0;
        } else if (type == RESPONSE && !kcaServers.contains(saddrstr)) {
            return 0;
        }
        //Log.e(TAG, String.format("containsKcaServer[%d] %s:%d => %s:%d", type, saddrstr, sport, taddrstr, tport));
        return 1;
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
                portToRequestData.get(sport).append(s);
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
                if (portToResponseHeaderPart.get(tport).length() == 0) {
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
