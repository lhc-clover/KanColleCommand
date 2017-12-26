package cn.cctech.kccommand.events.api;

import com.orhanobut.logger.Logger;

import java.util.Map;

import cn.cctech.kccommand.events.JsonEvent;
import cn.cctech.kccommand.utils.ApiParser;

public class Change extends JsonEvent {

    private int api_result;
    private int apiShipId = Integer.MIN_VALUE;
    private int apiShipIdx = Integer.MIN_VALUE;
    private int apiId = Integer.MIN_VALUE;

    public int getApi_result() {
        return api_result;
    }

    public void setApi_result(int api_result) {
        this.api_result = api_result;
    }

    public int getApiShipId() {
        return apiShipId;
    }

    public void setApiShipId(int apiShipId) {
        this.apiShipId = apiShipId;
    }

    public int getApiShipIdx() {
        return apiShipIdx;
    }

    public void setApiShipIdx(int apiShipIdx) {
        this.apiShipIdx = apiShipIdx;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public boolean inflate() {
        try {
//            for (String query : getRequestBody().split("&")) {
//                String[] pairs = query.split("=");
//                switch (pairs[0]) {
//                    case "api_ship_id":
//                        apiShipId = Integer.valueOf(pairs[1]);
//                        break;
//                    case "api_ship_idx":
//                        apiShipIdx = Integer.valueOf(pairs[1]);
//                        break;
//                    case "api_id":
//                        apiId = Integer.valueOf(pairs[1]);
//                        break;
//                }
//            }
            Map<String, String> map = ApiParser.INSTANCE.convertFormToMap(getRequestBody());
            apiShipId = Integer.valueOf(map.get("api_ship_id"));
            apiShipIdx = Integer.valueOf(map.get("api_ship_idx"));
            apiId = Integer.valueOf(map.get("api_id"));
        } catch (Exception e) {
            Logger.e(e, e.getMessage());
        }
        return apiShipIdx > Integer.MIN_VALUE && apiId > Integer.MIN_VALUE && apiShipId > Integer.MIN_VALUE;
    }
}
