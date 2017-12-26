package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class MapInfo extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : [{"api_id":11,"api_cleared":0,"api_exboss_flag":0}]
     */

    private int api_result;
    private String api_result_msg;
    /**
     * api_id : 11
     * api_cleared : 0
     * api_exboss_flag : 0
     */

    private List<ApiDataEntity> api_data;

    public int getApi_result() {
        return api_result;
    }

    public void setApi_result(int api_result) {
        this.api_result = api_result;
    }

    public String getApi_result_msg() {
        return api_result_msg;
    }

    public void setApi_result_msg(String api_result_msg) {
        this.api_result_msg = api_result_msg;
    }

    public List<ApiDataEntity> getApi_data() {
        return api_data;
    }

    public void setApi_data(List<ApiDataEntity> api_data) {
        this.api_data = api_data;
    }

    public static class ApiDataEntity {
        private int api_id;
        private int api_cleared;
        private int api_exboss_flag;

        public int getApi_id() {
            return api_id;
        }

        public void setApi_id(int api_id) {
            this.api_id = api_id;
        }

        public int getApi_cleared() {
            return api_cleared;
        }

        public void setApi_cleared(int api_cleared) {
            this.api_cleared = api_cleared;
        }

        public int getApi_exboss_flag() {
            return api_exboss_flag;
        }

        public void setApi_exboss_flag(int api_exboss_flag) {
            this.api_exboss_flag = api_exboss_flag;
        }
    }
}
