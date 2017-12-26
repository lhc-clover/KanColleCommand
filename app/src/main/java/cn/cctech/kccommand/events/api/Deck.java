package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class Deck extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : [{"api_member_id":11141519,"api_id":1,"api_name":"第1艦隊","api_name_id":"","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[21,28,4,1,5,2]},{"api_member_id":11141519,"api_id":2,"api_name":"第2艦隊","api_name_id":"","api_mission":[1,2,1508487331857,0],"api_flagship":"0","api_ship":[6,12,18,11,17,15]}]
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
         * api_name : 第1艦隊
         * api_name_id :
         * api_mission : [0,0,0,0]
         * api_flagship : 0
         * api_ship : [21,28,4,1,5,2]
         */

        private int api_member_id;
        private int api_id;
        private String api_name;
        private String api_name_id;
        private String api_flagship;
        private List<String> api_mission;
        private List<Integer> api_ship;

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

        public String getApi_name() {
            return api_name;
        }

        public void setApi_name(String api_name) {
            this.api_name = api_name;
        }

        public String getApi_name_id() {
            return api_name_id;
        }

        public void setApi_name_id(String api_name_id) {
            this.api_name_id = api_name_id;
        }

        public String getApi_flagship() {
            return api_flagship;
        }

        public void setApi_flagship(String api_flagship) {
            this.api_flagship = api_flagship;
        }

        public List<String> getApi_mission() {
            return api_mission;
        }

        public void setApi_mission(List<String> api_mission) {
            this.api_mission = api_mission;
        }

        public List<Integer> getApi_ship() {
            return api_ship;
        }

        public void setApi_ship(List<Integer> api_ship) {
            this.api_ship = api_ship;
        }
    }
}
