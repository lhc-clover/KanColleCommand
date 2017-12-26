package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class Material extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : [{"api_member_id":11141519,"api_id":1,"api_value":4569},{"api_member_id":11141519,"api_id":2,"api_value":4730},{"api_member_id":11141519,"api_id":3,"api_value":4217},{"api_member_id":11141519,"api_id":4,"api_value":4520},{"api_member_id":11141519,"api_id":5,"api_value":8},{"api_member_id":11141519,"api_id":6,"api_value":21},{"api_member_id":11141519,"api_id":7,"api_value":19},{"api_member_id":11141519,"api_id":8,"api_value":0}]
     */

    private int api_result;
    private String api_result_msg;
    private List<ApiDataBean> api_data;

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

    public List<ApiDataBean> getApi_data() {
        return api_data;
    }

    public void setApi_data(List<ApiDataBean> api_data) {
        this.api_data = api_data;
    }

    public static class ApiDataBean {
        /**
         * api_member_id : 11141519
         * api_id : 1
         * api_value : 4569
         */

        private int api_member_id;
        private int api_id;
        private int api_value;

        public int getApi_member_id() {
            return api_member_id;
        }

        public void setApi_member_id(int api_member_id) {
            this.api_member_id = api_member_id;
        }

        public int getApi_id() {
            return api_id;
        }

        public void setApi_id(int api_id) {
            this.api_id = api_id;
        }

        public int getApi_value() {
            return api_value;
        }

        public void setApi_value(int api_value) {
            this.api_value = api_value;
        }
    }
}
