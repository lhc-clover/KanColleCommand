package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class Kdock extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : [{"api_id":1,"api_state":2,"api_created_ship_id":29,"api_complete_time":1511428266638,"api_complete_time_str":"2017-11-23 18:11:06","api_item1":30,"api_item2":30,"api_item3":30,"api_item4":30,"api_item5":1},{"api_id":2,"api_state":2,"api_created_ship_id":56,"api_complete_time":1511431221418,"api_complete_time_str":"2017-11-23 19:00:21","api_item1":30,"api_item2":30,"api_item3":30,"api_item4":30,"api_item5":1},{"api_id":3,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0},{"api_id":4,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0}]
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
         * api_id : 1
         * api_state : 2
         * api_created_ship_id : 29
         * api_complete_time : 1511428266638
         * api_complete_time_str : 2017-11-23 18:11:06
         * api_item1 : 30
         * api_item2 : 30
         * api_item3 : 30
         * api_item4 : 30
         * api_item5 : 1
         */

        private int api_id;
        private int api_state;
        private int api_created_ship_id;
        private long api_complete_time;
        private String api_complete_time_str;
        private int api_item1;
        private int api_item2;
        private int api_item3;
        private int api_item4;
        private int api_item5;

        public int getApi_id() {
            return api_id;
        }

        public void setApi_id(int api_id) {
            this.api_id = api_id;
        }

        public int getApi_state() {
            return api_state;
        }

        public void setApi_state(int api_state) {
            this.api_state = api_state;
        }

        public int getApi_created_ship_id() {
            return api_created_ship_id;
        }

        public void setApi_created_ship_id(int api_created_ship_id) {
            this.api_created_ship_id = api_created_ship_id;
        }

        public long getApi_complete_time() {
            return api_complete_time;
        }

        public void setApi_complete_time(long api_complete_time) {
            this.api_complete_time = api_complete_time;
        }

        public String getApi_complete_time_str() {
            return api_complete_time_str;
        }

        public void setApi_complete_time_str(String api_complete_time_str) {
            this.api_complete_time_str = api_complete_time_str;
        }

        public int getApi_item1() {
            return api_item1;
        }

        public void setApi_item1(int api_item1) {
            this.api_item1 = api_item1;
        }

        public int getApi_item2() {
            return api_item2;
        }

        public void setApi_item2(int api_item2) {
            this.api_item2 = api_item2;
        }

        public int getApi_item3() {
            return api_item3;
        }

        public void setApi_item3(int api_item3) {
            this.api_item3 = api_item3;
        }

        public int getApi_item4() {
            return api_item4;
        }

        public void setApi_item4(int api_item4) {
            this.api_item4 = api_item4;
        }

        public int getApi_item5() {
            return api_item5;
        }

        public void setApi_item5(int api_item5) {
            this.api_item5 = api_item5;
        }
    }
}
