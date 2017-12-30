package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class PracticeResult extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_ship_id":[94,174,175],"api_win_rank":"S","api_get_exp":160,"api_member_lv":17,"api_member_exp":14300,"api_get_base_exp":672,"api_mvp":2,"api_get_ship_exp":[-1,1008,1344,672,672,672,672],"api_get_exp_lvup":[[6310,6600,7800],[16131,17100,19000],[7345,7800,9100],[6388,6600,7800],[5812,6600],[7716,7800,9100]],"api_enemy_info":{"api_user_name":"","api_level":78,"api_rank":"少将","api_deck_name":"第2艦隊"}}
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
         * api_ship_id : [94,174,175]
         * api_win_rank : S
         * api_get_exp : 160
         * api_member_lv : 17
         * api_member_exp : 14300
         * api_get_base_exp : 672
         * api_mvp : 2
         * api_get_ship_exp : [-1,1008,1344,672,672,672,672]
         * api_get_exp_lvup : [[6310,6600,7800],[16131,17100,19000],[7345,7800,9100],[6388,6600,7800],[5812,6600],[7716,7800,9100]]
         * api_enemy_info : {"api_user_name":"","api_level":78,"api_rank":"少将","api_deck_name":"第2艦隊"}
         */

        private String api_win_rank;
        private int api_get_exp;
        private int api_member_lv;
        private int api_member_exp;
        private int api_get_base_exp;
        private int api_mvp;
        private ApiEnemyInfoBean api_enemy_info;
        private List<Integer> api_ship_id;
        private List<Integer> api_get_ship_exp;
        private List<List<Integer>> api_get_exp_lvup;

        public String getApi_win_rank() {
            return api_win_rank;
        }

        public void setApi_win_rank(String api_win_rank) {
            this.api_win_rank = api_win_rank;
        }

        public int getApi_get_exp() {
            return api_get_exp;
        }

        public void setApi_get_exp(int api_get_exp) {
            this.api_get_exp = api_get_exp;
        }

        public int getApi_member_lv() {
            return api_member_lv;
        }

        public void setApi_member_lv(int api_member_lv) {
            this.api_member_lv = api_member_lv;
        }

        public int getApi_member_exp() {
            return api_member_exp;
        }

        public void setApi_member_exp(int api_member_exp) {
            this.api_member_exp = api_member_exp;
        }

        public int getApi_get_base_exp() {
            return api_get_base_exp;
        }

        public void setApi_get_base_exp(int api_get_base_exp) {
            this.api_get_base_exp = api_get_base_exp;
        }

        public int getApi_mvp() {
            return api_mvp;
        }

        public void setApi_mvp(int api_mvp) {
            this.api_mvp = api_mvp;
        }

        public ApiEnemyInfoBean getApi_enemy_info() {
            return api_enemy_info;
        }

        public void setApi_enemy_info(ApiEnemyInfoBean api_enemy_info) {
            this.api_enemy_info = api_enemy_info;
        }

        public List<Integer> getApi_ship_id() {
            return api_ship_id;
        }

        public void setApi_ship_id(List<Integer> api_ship_id) {
            this.api_ship_id = api_ship_id;
        }

        public List<Integer> getApi_get_ship_exp() {
            return api_get_ship_exp;
        }

        public void setApi_get_ship_exp(List<Integer> api_get_ship_exp) {
            this.api_get_ship_exp = api_get_ship_exp;
        }

        public List<List<Integer>> getApi_get_exp_lvup() {
            return api_get_exp_lvup;
        }

        public void setApi_get_exp_lvup(List<List<Integer>> api_get_exp_lvup) {
            this.api_get_exp_lvup = api_get_exp_lvup;
        }

        public static class ApiEnemyInfoBean {
            /**
             * api_user_name :
             * api_level : 78
             * api_rank : 少将
             * api_deck_name : 第2艦隊
             */

            private String api_user_name;
            private int api_level;
            private String api_rank;
            private String api_deck_name;

            public String getApi_user_name() {
                return api_user_name;
            }

            public void setApi_user_name(String api_user_name) {
                this.api_user_name = api_user_name;
            }

            public int getApi_level() {
                return api_level;
            }

            public void setApi_level(int api_level) {
                this.api_level = api_level;
            }

            public String getApi_rank() {
                return api_rank;
            }

            public void setApi_rank(String api_rank) {
                this.api_rank = api_rank;
            }

            public String getApi_deck_name() {
                return api_deck_name;
            }

            public void setApi_deck_name(String api_deck_name) {
                this.api_deck_name = api_deck_name;
            }
        }
    }
}
