package cn.cctech.kccommand.events.api;

import com.google.gson.JsonArray;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

// api_list有-1值造成类型不匹配，用JsonArray代替解析
public class QuestList extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_count":41,"api_completed_kind":1,"api_page_count":9,"api_disp_page":1,"api_list":[{"api_no":133,"api_category":1,"api_type":4,"api_state":1,"api_title":"「第三十駆逐隊(第一次)」を編成せよ！","api_detail":"「睦月」「如月」「弥生」「望月」4隻による第三十駆逐隊(第一次)を編成せよ！","api_voice_id":0,"api_get_material":[200,200,0,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":135,"api_category":1,"api_type":4,"api_state":1,"api_title":"新たなる旅立ち！","api_detail":"第一艦隊旗艦に強い絆を結んだLv.100以上の艦娘を配備した6隻の艦隊を編成せよ！","api_voice_id":0,"api_get_material":[200,200,200,200],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":143,"api_category":1,"api_type":4,"api_state":1,"api_title":"「新型正規空母」を配備せよ！","api_detail":"雲龍型航空母艦一番艦「雲龍」を第一艦隊機旗艦に配備せよ！","api_voice_id":0,"api_get_material":[100,100,100,300],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":149,"api_category":1,"api_type":4,"api_state":1,"api_title":"「第十一駆逐隊」を編成せよ！","api_detail":"特I型駆逐艦「吹雪」「白雪」「初雪」「叢雲」4隻による第十一駆逐隊を編成せよ！","api_voice_id":0,"api_get_material":[110,110,110,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":154,"api_category":1,"api_type":4,"api_state":1,"api_title":"海上突入部隊を編成せよ！","api_detail":"戦艦「比叡」「霧島」軽巡「長良」駆逐艦「暁」「雷」「電」による海上突入部隊を編成せよ！","api_voice_id":0,"api_get_material":[0,300,0,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0}],"api_exec_count":5,"api_exec_type":2361127}
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
         * api_count : 41
         * api_completed_kind : 1
         * api_page_count : 9
         * api_disp_page : 1
         * api_list : [{"api_no":133,"api_category":1,"api_type":4,"api_state":1,"api_title":"「第三十駆逐隊(第一次)」を編成せよ！","api_detail":"「睦月」「如月」「弥生」「望月」4隻による第三十駆逐隊(第一次)を編成せよ！","api_voice_id":0,"api_get_material":[200,200,0,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":135,"api_category":1,"api_type":4,"api_state":1,"api_title":"新たなる旅立ち！","api_detail":"第一艦隊旗艦に強い絆を結んだLv.100以上の艦娘を配備した6隻の艦隊を編成せよ！","api_voice_id":0,"api_get_material":[200,200,200,200],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":143,"api_category":1,"api_type":4,"api_state":1,"api_title":"「新型正規空母」を配備せよ！","api_detail":"雲龍型航空母艦一番艦「雲龍」を第一艦隊機旗艦に配備せよ！","api_voice_id":0,"api_get_material":[100,100,100,300],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":149,"api_category":1,"api_type":4,"api_state":1,"api_title":"「第十一駆逐隊」を編成せよ！","api_detail":"特I型駆逐艦「吹雪」「白雪」「初雪」「叢雲」4隻による第十一駆逐隊を編成せよ！","api_voice_id":0,"api_get_material":[110,110,110,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0},{"api_no":154,"api_category":1,"api_type":4,"api_state":1,"api_title":"海上突入部隊を編成せよ！","api_detail":"戦艦「比叡」「霧島」軽巡「長良」駆逐艦「暁」「雷」「電」による海上突入部隊を編成せよ！","api_voice_id":0,"api_get_material":[0,300,0,0],"api_bonus_flag":1,"api_progress_flag":0,"api_invalid_flag":0}]
         * api_exec_count : 5
         * api_exec_type : 2361127
         */

        private int api_count;
        private int api_completed_kind;
        private int api_page_count;
        private int api_disp_page;
        private int api_exec_count;
        private int api_exec_type;
        private JsonArray api_list;

        public int getApi_count() {
            return api_count;
        }

        public void setApi_count(int api_count) {
            this.api_count = api_count;
        }

        public int getApi_completed_kind() {
            return api_completed_kind;
        }

        public void setApi_completed_kind(int api_completed_kind) {
            this.api_completed_kind = api_completed_kind;
        }

        public int getApi_page_count() {
            return api_page_count;
        }

        public void setApi_page_count(int api_page_count) {
            this.api_page_count = api_page_count;
        }

        public int getApi_disp_page() {
            return api_disp_page;
        }

        public void setApi_disp_page(int api_disp_page) {
            this.api_disp_page = api_disp_page;
        }

        public int getApi_exec_count() {
            return api_exec_count;
        }

        public void setApi_exec_count(int api_exec_count) {
            this.api_exec_count = api_exec_count;
        }

        public int getApi_exec_type() {
            return api_exec_type;
        }

        public void setApi_exec_type(int api_exec_type) {
            this.api_exec_type = api_exec_type;
        }

        public JsonArray getApi_list() {
            return api_list;
        }

        public void setApi_list(JsonArray api_list) {
            this.api_list = api_list;
        }

        public static class ApiListBean {
            /**
             * api_no : 133
             * api_category : 1
             * api_type : 4
             * api_state : 1
             * api_title : 「第三十駆逐隊(第一次)」を編成せよ！
             * api_detail : 「睦月」「如月」「弥生」「望月」4隻による第三十駆逐隊(第一次)を編成せよ！
             * api_voice_id : 0
             * api_get_material : [200,200,0,0]
             * api_bonus_flag : 1
             * api_progress_flag : 0
             * api_invalid_flag : 0
             */

            private int api_no;
            private int api_category;
            private int api_type;
            private int api_state;
            private String api_title;
            private String api_detail;
            private int api_voice_id;
            private int api_bonus_flag;
            private int api_progress_flag;
            private int api_invalid_flag;
            private List<Integer> api_get_material;

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public int getApi_category() {
                return api_category;
            }

            public void setApi_category(int api_category) {
                this.api_category = api_category;
            }

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }

            public int getApi_state() {
                return api_state;
            }

            public void setApi_state(int api_state) {
                this.api_state = api_state;
            }

            public String getApi_title() {
                return api_title;
            }

            public void setApi_title(String api_title) {
                this.api_title = api_title;
            }

            public String getApi_detail() {
                return api_detail;
            }

            public void setApi_detail(String api_detail) {
                this.api_detail = api_detail;
            }

            public int getApi_voice_id() {
                return api_voice_id;
            }

            public void setApi_voice_id(int api_voice_id) {
                this.api_voice_id = api_voice_id;
            }

            public int getApi_bonus_flag() {
                return api_bonus_flag;
            }

            public void setApi_bonus_flag(int api_bonus_flag) {
                this.api_bonus_flag = api_bonus_flag;
            }

            public int getApi_progress_flag() {
                return api_progress_flag;
            }

            public void setApi_progress_flag(int api_progress_flag) {
                this.api_progress_flag = api_progress_flag;
            }

            public int getApi_invalid_flag() {
                return api_invalid_flag;
            }

            public void setApi_invalid_flag(int api_invalid_flag) {
                this.api_invalid_flag = api_invalid_flag;
            }

            public List<Integer> getApi_get_material() {
                return api_get_material;
            }

            public void setApi_get_material(List<Integer> api_get_material) {
                this.api_get_material = api_get_material;
            }
        }
    }
}
