package cn.cctech.kccommand.events;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.Map;

import cn.cctech.kccommand.utils.ApiParser;

public abstract class Event implements Serializable {

    private String requestBody;

    public void dispatch() {
        EventBus.getDefault().post(this);
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Map<String, String> getParamMap() {
        return ApiParser.INSTANCE.convertFormToMap(requestBody);
    }

}
