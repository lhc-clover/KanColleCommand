package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class BattleResult extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_ship_id":[1511,1509,1507,1520,1516,1516],"api_win_rank":"A","api_get_exp":80,"api_mvp":2,"api_member_lv":15,"api_member_exp":11266,"api_get_base_exp":300,"api_get_ship_exp":[-1,450,600,300,300,300,300],"api_get_exp_lvup":[[7875,9100],[7863,9100],[9260,10500],[6562,6600,7800],[16094,17100],[8312,9100]],"api_dests":5,"api_destsf":0,"api_quest_name":"沖ノ島海域","api_quest_level":6,"api_enemy_info":{"api_level":"","api_rank":"","api_deck_name":"敵水上打撃艦隊"},"api_first_clear":0,"api_mapcell_incentive":0,"api_get_flag":[0,1,0],"api_get_ship":{"api_ship_id":12,"api_ship_type":"駆逐艦","api_ship_name":"磯波","api_ship_getmes":"あ、あの\u2026磯波と申します。<br>よろしくお願いいたします。"},"api_get_eventflag":0,"api_get_exmap_rate":0,"api_get_exmap_useitem_id":0,"api_escape_flag":0,"api_escape":null}
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
         * api_ship_id : [1511,1509,1507,1520,1516,1516]
         * api_win_rank : A
         * api_get_exp : 80
         * api_mvp : 2
         * api_member_lv : 15
         * api_member_exp : 11266
         * api_get_base_exp : 300
         * api_get_ship_exp : [-1,450,600,300,300,300,300]
         * api_get_exp_lvup : [[7875,9100],[7863,9100],[9260,10500],[6562,6600,7800],[16094,17100],[8312,9100]]
         * api_dests : 5
         * api_destsf : 0
         * api_quest_name : 沖ノ島海域
         * api_quest_level : 6
         * api_enemy_info : {"api_level":"","api_rank":"","api_deck_name":"敵水上打撃艦隊"}
         * api_first_clear : 0
         * api_mapcell_incentive : 0
         * api_get_flag : [0,1,0]
         * api_get_ship : {"api_ship_id":12,"api_ship_type":"駆逐艦","api_ship_name":"磯波","api_ship_getmes":"あ、あの\u2026磯波と申します。<br>よろしくお願いいたします。"}
         * api_get_eventflag : 0
         * api_get_exmap_rate : 0
         * api_get_exmap_useitem_id : 0
         * api_escape_flag : 0
         * api_escape : null
         */

        private String api_win_rank;
        private int api_get_exp;
        private int api_mvp;
        private int api_member_lv;
        private int api_member_exp;
        private int api_get_base_exp;
        private int api_dests;
        private int api_destsf;
        private String api_quest_name;
        private int api_quest_level;
        private ApiEnemyInfoBean api_enemy_info;
        private int api_first_clear;
        private int api_mapcell_incentive;
        private ApiGetShipBean api_get_ship;
        private int api_get_eventflag;
        private int api_get_exmap_rate;
        private int api_get_exmap_useitem_id;
        private int api_escape_flag;
        private Object api_escape;
        private List<Integer> api_ship_id;
        private List<Integer> api_get_ship_exp;
        private List<List<Integer>> api_get_exp_lvup;
        private List<Integer> api_get_flag;

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

        public int getApi_mvp() {
            return api_mvp;
        }

        public void setApi_mvp(int api_mvp) {
            this.api_mvp = api_mvp;
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

        public int getApi_dests() {
            return api_dests;
        }

        public void setApi_dests(int api_dests) {
            this.api_dests = api_dests;
        }

        public int getApi_destsf() {
            return api_destsf;
        }

        public void setApi_destsf(int api_destsf) {
            this.api_destsf = api_destsf;
        }

        public String getApi_quest_name() {
            return api_quest_name;
        }

        public void setApi_quest_name(String api_quest_name) {
            this.api_quest_name = api_quest_name;
        }

        public int getApi_quest_level() {
            return api_quest_level;
        }

        public void setApi_quest_level(int api_quest_level) {
            this.api_quest_level = api_quest_level;
        }

        public ApiEnemyInfoBean getApi_enemy_info() {
            return api_enemy_info;
        }

        public void setApi_enemy_info(ApiEnemyInfoBean api_enemy_info) {
            this.api_enemy_info = api_enemy_info;
        }

        public int getApi_first_clear() {
            return api_first_clear;
        }

        public void setApi_first_clear(int api_first_clear) {
            this.api_first_clear = api_first_clear;
        }

        public int getApi_mapcell_incentive() {
            return api_mapcell_incentive;
        }

        public void setApi_mapcell_incentive(int api_mapcell_incentive) {
            this.api_mapcell_incentive = api_mapcell_incentive;
        }

        public ApiGetShipBean getApi_get_ship() {
            return api_get_ship;
        }

        public void setApi_get_ship(ApiGetShipBean api_get_ship) {
            this.api_get_ship = api_get_ship;
        }

        public int getApi_get_eventflag() {
            return api_get_eventflag;
        }

        public void setApi_get_eventflag(int api_get_eventflag) {
            this.api_get_eventflag = api_get_eventflag;
        }

        public int getApi_get_exmap_rate() {
            return api_get_exmap_rate;
        }

        public void setApi_get_exmap_rate(int api_get_exmap_rate) {
            this.api_get_exmap_rate = api_get_exmap_rate;
        }

        public int getApi_get_exmap_useitem_id() {
            return api_get_exmap_useitem_id;
        }

        public void setApi_get_exmap_useitem_id(int api_get_exmap_useitem_id) {
            this.api_get_exmap_useitem_id = api_get_exmap_useitem_id;
        }

        public int getApi_escape_flag() {
            return api_escape_flag;
        }

        public void setApi_escape_flag(int api_escape_flag) {
            this.api_escape_flag = api_escape_flag;
        }

        public Object getApi_escape() {
            return api_escape;
        }

        public void setApi_escape(Object api_escape) {
            this.api_escape = api_escape;
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

        public List<Integer> getApi_get_flag() {
            return api_get_flag;
        }

        public void setApi_get_flag(List<Integer> api_get_flag) {
            this.api_get_flag = api_get_flag;
        }

        public static class ApiEnemyInfoBean {
            /**
             * api_level :
             * api_rank :
             * api_deck_name : 敵水上打撃艦隊
             */

            private String api_level;
            private String api_rank;
            private String api_deck_name;

            public String getApi_level() {
                return api_level;
            }

            public void setApi_level(String api_level) {
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

        public static class ApiGetShipBean {
            /**
             * api_ship_id : 12
             * api_ship_type : 駆逐艦
             * api_ship_name : 磯波
             * api_ship_getmes : あ、あの…磯波と申します。<br>よろしくお願いいたします。
             */

            private int api_ship_id;
            private String api_ship_type;
            private String api_ship_name;
            private String api_ship_getmes;

            public int getApi_ship_id() {
                return api_ship_id;
            }

            public void setApi_ship_id(int api_ship_id) {
                this.api_ship_id = api_ship_id;
            }

            public String getApi_ship_type() {
                return api_ship_type;
            }

            public void setApi_ship_type(String api_ship_type) {
                this.api_ship_type = api_ship_type;
            }

            public String getApi_ship_name() {
                return api_ship_name;
            }

            public void setApi_ship_name(String api_ship_name) {
                this.api_ship_name = api_ship_name;
            }

            public String getApi_ship_getmes() {
                return api_ship_getmes;
            }

            public void setApi_ship_getmes(String api_ship_getmes) {
                this.api_ship_getmes = api_ship_getmes;
            }
        }
    }
}
