package cn.cctech.kccommand.events.api;

import com.orhanobut.logger.Logger;

import cn.cctech.kccommand.events.QueryEvent;

public class SlotExchange extends QueryEvent {

    private int apiId = Integer.MIN_VALUE;
    private int apiSrcIdx = Integer.MIN_VALUE;
    private int apiDstIdx = Integer.MIN_VALUE;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getApiSrcIdx() {
        return apiSrcIdx;
    }

    public void setApiSrcIdx(int apiSrcIdx) {
        this.apiSrcIdx = apiSrcIdx;
    }

    public int getApiDstIdx() {
        return apiDstIdx;
    }

    public void setApiDstIdx(int apiDstIdx) {
        this.apiDstIdx = apiDstIdx;
    }

    @Override
    public boolean inflate(String content) {
        try {
            for (String query : content.split("&")) {
                String[] pairs = query.split("=");
                switch (pairs[0]) {
                    case "api_src_idx":
                        apiSrcIdx = Integer.valueOf(pairs[1]);
                        break;
                    case "api_dst_idx":
                        apiDstIdx = Integer.valueOf(pairs[1]);
                        break;
                    case "api_id":
                        apiId = Integer.valueOf(pairs[1]);
                        break;
                }
            }
        } catch (Exception e) {
            Logger.e(e, e.getMessage());
        }
        return apiId > Integer.MIN_VALUE && apiSrcIdx > Integer.MIN_VALUE && apiDstIdx > Integer.MIN_VALUE;
    }

}
