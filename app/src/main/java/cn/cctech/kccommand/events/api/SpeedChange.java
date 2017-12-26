package cn.cctech.kccommand.events.api;

import com.orhanobut.logger.Logger;

import java.util.Map;

import cn.cctech.kccommand.events.JsonEvent;
import cn.cctech.kccommand.utils.ApiParser;

public class SpeedChange extends JsonEvent {

    private int api_result;
    private int api_ndock_id;

    public int getApi_result() {
        return api_result;
    }

    public void setApi_result(int api_result) {
        this.api_result = api_result;
    }

    public int getApi_ndock_id() {
        return api_ndock_id;
    }

    public void setApi_ndock_id(int api_ndock_id) {
        this.api_ndock_id = api_ndock_id;
    }

    public boolean inflate() {
        try {
            Map<String, String> map = ApiParser.INSTANCE.convertFormToMap(getRequestBody());
            api_ndock_id = Integer.valueOf(map.get("api_ndock_id"));
        } catch (Exception e) {
            Logger.e(e, e.getMessage());
        }
        return api_ndock_id > Integer.MIN_VALUE;
    }
}
