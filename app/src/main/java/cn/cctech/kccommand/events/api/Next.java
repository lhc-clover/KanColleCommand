package cn.cctech.kccommand.events.api;

import cn.cctech.kccommand.events.JsonEvent;

public class Next extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_rashin_flg":1,"api_rashin_id":4,"api_maparea_id":1,"api_mapinfo_no":3,"api_no":5,"api_color_no":4,"api_event_id":4,"api_event_kind":1,"api_next":1,"api_bosscell_no":7,"api_bosscomp":0,"api_comment_kind":0,"api_production_kind":0,"api_airsearch":{"api_plane_type":0,"api_result":0}}
     */

    private int api_result;
    private String api_result_msg;
    private ApiDataBean api_data;

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

    public ApiDataBean getApi_data() {
        return api_data;
    }

    public void setApi_data(ApiDataBean api_data) {
        this.api_data = api_data;
    }

    public static class ApiDataBean {
        /**
         * api_rashin_flg : 1
         * api_rashin_id : 4
         * api_maparea_id : 1
         * api_mapinfo_no : 3
         * api_no : 5
         * api_color_no : 4
         * api_event_id : 4
         * api_event_kind : 1
         * api_next : 1
         * api_bosscell_no : 7
         * api_bosscomp : 0
         * api_comment_kind : 0
         * api_production_kind : 0
         * api_airsearch : {"api_plane_type":0,"api_result":0}
         */

        private int api_rashin_flg;
        private int api_rashin_id;
        private int api_maparea_id;
        private int api_mapinfo_no;
        private int api_no;
        private int api_color_no;
        private int api_event_id;
        private int api_event_kind;
        private int api_next;
        private int api_bosscell_no;
        private int api_bosscomp;
        private int api_comment_kind;
        private int api_production_kind;
        private ApiAirsearchBean api_airsearch;

        public int getApi_rashin_flg() {
            return api_rashin_flg;
        }

        public void setApi_rashin_flg(int api_rashin_flg) {
            this.api_rashin_flg = api_rashin_flg;
        }

        public int getApi_rashin_id() {
            return api_rashin_id;
        }

        public void setApi_rashin_id(int api_rashin_id) {
            this.api_rashin_id = api_rashin_id;
        }

        public int getApi_maparea_id() {
            return api_maparea_id;
        }

        public void setApi_maparea_id(int api_maparea_id) {
            this.api_maparea_id = api_maparea_id;
        }

        public int getApi_mapinfo_no() {
            return api_mapinfo_no;
        }

        public void setApi_mapinfo_no(int api_mapinfo_no) {
            this.api_mapinfo_no = api_mapinfo_no;
        }

        public int getApi_no() {
            return api_no;
        }

        public void setApi_no(int api_no) {
            this.api_no = api_no;
        }

        public int getApi_color_no() {
            return api_color_no;
        }

        public void setApi_color_no(int api_color_no) {
            this.api_color_no = api_color_no;
        }

        public int getApi_event_id() {
            return api_event_id;
        }

        public void setApi_event_id(int api_event_id) {
            this.api_event_id = api_event_id;
        }

        public int getApi_event_kind() {
            return api_event_kind;
        }

        public void setApi_event_kind(int api_event_kind) {
            this.api_event_kind = api_event_kind;
        }

        public int getApi_next() {
            return api_next;
        }

        public void setApi_next(int api_next) {
            this.api_next = api_next;
        }

        public int getApi_bosscell_no() {
            return api_bosscell_no;
        }

        public void setApi_bosscell_no(int api_bosscell_no) {
            this.api_bosscell_no = api_bosscell_no;
        }

        public int getApi_bosscomp() {
            return api_bosscomp;
        }

        public void setApi_bosscomp(int api_bosscomp) {
            this.api_bosscomp = api_bosscomp;
        }

        public int getApi_comment_kind() {
            return api_comment_kind;
        }

        public void setApi_comment_kind(int api_comment_kind) {
            this.api_comment_kind = api_comment_kind;
        }

        public int getApi_production_kind() {
            return api_production_kind;
        }

        public void setApi_production_kind(int api_production_kind) {
            this.api_production_kind = api_production_kind;
        }

        public ApiAirsearchBean getApi_airsearch() {
            return api_airsearch;
        }

        public void setApi_airsearch(ApiAirsearchBean api_airsearch) {
            this.api_airsearch = api_airsearch;
        }

        public static class ApiAirsearchBean {
            /**
             * api_plane_type : 0
             * api_result : 0
             */

            private int api_plane_type;
            private int api_result;

            public int getApi_plane_type() {
                return api_plane_type;
            }

            public void setApi_plane_type(int api_plane_type) {
                this.api_plane_type = api_plane_type;
            }

            public int getApi_result() {
                return api_result;
            }

            public void setApi_result(int api_result) {
                this.api_result = api_result;
            }
        }
    }
}
