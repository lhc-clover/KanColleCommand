package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class SlotItem extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : [{"api_id":2,"api_slotitem_id":42,"api_locked":0,"api_level":0},{"api_id":270,"api_slotitem_id":41,"api_locked":0,"api_level":0},{"api_id":271,"api_slotitem_id":41,"api_locked":0,"api_level":0},{"api_id":274,"api_slotitem_id":15,"api_locked":0,"api_level":8},{"api_id":286,......"api_slotitem_id":4,"api_locked":0,"api_level":0},{"api_id":11165,"api_slotitem_id":25,"api_locked":0,"api_level":0}]
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
         * api_id : 2
         * api_slotitem_id : 42
         * api_locked : 0
         * api_level : 0
         * api_alv : 7
         */

        private int api_id;
        private int api_slotitem_id;
        private int api_locked;
        private int api_level;
        private int api_alv;

        public int getApi_id() {
            return api_id;
        }

        public void setApi_id(int api_id) {
            this.api_id = api_id;
        }

        public int getApi_slotitem_id() {
            return api_slotitem_id;
        }

        public void setApi_slotitem_id(int api_slotitem_id) {
            this.api_slotitem_id = api_slotitem_id;
        }

        public int getApi_locked() {
            return api_locked;
        }

        public void setApi_locked(int api_locked) {
            this.api_locked = api_locked;
        }

        public int getApi_level() {
            return api_level;
        }

        public void setApi_level(int api_level) {
            this.api_level = api_level;
        }

        public int getApi_alv() {
            return api_alv;
        }

        public void setApi_alv(int api_alv) {
            this.api_alv = api_alv;
        }
    }
}
