package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.entities.ApiShipData;
import cn.cctech.kccommand.events.JsonEvent;

public class Port extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_material":[{"api_member_id":11141519,"api_id":1,"api_value":1020},{"api_member_id":11141519,"api_id":2,"api_value":1020},{"api_member_id":11141519,"api_id":3,"api_value":1000},{"api_member_id":11141519,"api_id":4,"api_value":1000},{"api_member_id":11141519,"api_id":5,"api_value":2},{"api_member_id":11141519,"api_id":6,"api_value":4},{"api_member_id":11141519,"api_id":7,"api_value":4},{"api_member_id":11141519,"api_id":8,"api_value":0}],"api_deck_port":[{"api_member_id":11141519,"api_id":1,"api_name":"第1艦隊","api_name_id":"","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[1,2,3,4,-1,-1]}],"api_ndock":[{"api_member_id":11141519,"api_id":1,"api_state":0,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":2,"api_state":0,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":3,"api_state":-1,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":4,"api_state":-1,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0}],"api_ship":[{"api_id":1,"api_sortno":74,"api_ship_id":37,"api_lv":2,"api_exp":[216,84,57],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[3,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,2,1,0,0],"api_backs":1,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":56,"api_karyoku":[12,29],"api_raisou":[29,69],"api_taiku":[15,39],"api_soukou":[6,19],"api_kaihi":[42,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":2,"api_sortno":15,"api_ship_id":33,"api_lv":1,"api_exp":[72,28,72],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[4,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":3,"api_sortno":12,"api_ship_id":10,"api_lv":1,"api_exp":[72,28,72],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[5,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":4,"api_sortno":32,"api_ship_id":2,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":13,"api_maxhp":13,"api_leng":1,"api_slot":[6,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":15,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[7,29],"api_raisou":[18,49],"api_taiku":[8,29],"api_soukou":[5,18],"api_kaihi":[37,69],"api_taisen":[16,39],"api_sakuteki":[4,17],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":5,"api_sortno":12,"api_ship_id":10,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[7,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0}],"api_basic":{"api_member_id":"11141519","api_nickname":"CC","api_nickname_id":"153232567","api_active_flag":1,"api_starttime":1473318252446,"api_level":1,"api_rank":10,"api_experience":20,"api_fleetname":null,"api_comment":"","api_comment_id":"","api_max_chara":100,"api_max_slotitem":497,"api_max_kagu":0,"api_playtime":0,"api_tutorial":0,"api_furniture":[1,38,72,102,133,164],"api_count_deck":1,"api_count_kdock":2,"api_count_ndock":2,"api_fcoin":0,"api_st_win":2,"api_st_lose":0,"api_ms_count":0,"api_ms_success":0,"api_pt_win":0,"api_pt_lose":0,"api_pt_challenged":0,"api_pt_challenged_win":0,"api_firstflag":1,"api_tutorial_progress":100,"api_pvp":[0,0],"api_medals":0,"api_large_dock":0},"api_log":[{"api_no":0,"api_type":"1","api_state":"0","api_message":"「入渠」していた艦の修理が、完了しました。"},{"api_no":1,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":2,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":3,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":4,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":5,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"}],"api_p_bgm_id":101,"api_parallel_quest_count":5}
     */

    private int api_result;
    private String api_result_msg;
    /**
     * api_material : [{"api_member_id":11141519,"api_id":1,"api_value":1020},{"api_member_id":11141519,"api_id":2,"api_value":1020},{"api_member_id":11141519,"api_id":3,"api_value":1000},{"api_member_id":11141519,"api_id":4,"api_value":1000},{"api_member_id":11141519,"api_id":5,"api_value":2},{"api_member_id":11141519,"api_id":6,"api_value":4},{"api_member_id":11141519,"api_id":7,"api_value":4},{"api_member_id":11141519,"api_id":8,"api_value":0}]
     * api_deck_port : [{"api_member_id":11141519,"api_id":1,"api_name":"第1艦隊","api_name_id":"","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[1,2,3,4,-1,-1]}]
     * api_ndock : [{"api_member_id":11141519,"api_id":1,"api_state":0,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":2,"api_state":0,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":3,"api_state":-1,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0},{"api_member_id":11141519,"api_id":4,"api_state":-1,"api_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0}]
     * api_ship : [{"api_id":1,"api_sortno":74,"api_ship_id":37,"api_lv":2,"api_exp":[216,84,57],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[3,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,2,1,0,0],"api_backs":1,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":56,"api_karyoku":[12,29],"api_raisou":[29,69],"api_taiku":[15,39],"api_soukou":[6,19],"api_kaihi":[42,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":2,"api_sortno":15,"api_ship_id":33,"api_lv":1,"api_exp":[72,28,72],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[4,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":3,"api_sortno":12,"api_ship_id":10,"api_lv":1,"api_exp":[72,28,72],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[5,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":4,"api_sortno":32,"api_ship_id":2,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":13,"api_maxhp":13,"api_leng":1,"api_slot":[6,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":15,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[7,29],"api_raisou":[18,49],"api_taiku":[8,29],"api_soukou":[5,18],"api_kaihi":[37,69],"api_taisen":[16,39],"api_sakuteki":[4,17],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0},{"api_id":5,"api_sortno":12,"api_ship_id":10,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":15,"api_maxhp":15,"api_leng":1,"api_slot":[7,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0],"api_backs":2,"api_fuel":15,"api_bull":20,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[12,29],"api_raisou":[27,69],"api_taiku":[12,39],"api_soukou":[5,19],"api_kaihi":[40,79],"api_taisen":[20,49],"api_sakuteki":[5,19],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0}]
     * api_basic : {"api_member_id":"11141519","api_nickname":"CC","api_nickname_id":"153232567","api_active_flag":1,"api_starttime":1473318252446,"api_level":1,"api_rank":10,"api_experience":20,"api_fleetname":null,"api_comment":"","api_comment_id":"","api_max_chara":100,"api_max_slotitem":497,"api_max_kagu":0,"api_playtime":0,"api_tutorial":0,"api_furniture":[1,38,72,102,133,164],"api_count_deck":1,"api_count_kdock":2,"api_count_ndock":2,"api_fcoin":0,"api_st_win":2,"api_st_lose":0,"api_ms_count":0,"api_ms_success":0,"api_pt_win":0,"api_pt_lose":0,"api_pt_challenged":0,"api_pt_challenged_win":0,"api_firstflag":1,"api_tutorial_progress":100,"api_pvp":[0,0],"api_medals":0,"api_large_dock":0}
     * api_log : [{"api_no":0,"api_type":"1","api_state":"0","api_message":"「入渠」していた艦の修理が、完了しました。"},{"api_no":1,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":2,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":3,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":4,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"},{"api_no":5,"api_type":"11","api_state":"0","api_message":"図鑑の内容が更新されました！"}]
     * api_p_bgm_id : 101
     * api_parallel_quest_count : 5
     */

    private ApiDataEntity api_data;

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

    public ApiDataEntity getApi_data() {
        return api_data;
    }

    public void setApi_data(ApiDataEntity api_data) {
        this.api_data = api_data;
    }

    public static class ApiDataEntity {
        /**
         * api_member_id : 11141519
         * api_nickname : CC
         * api_nickname_id : 153232567
         * api_active_flag : 1
         * api_starttime : 1473318252446
         * api_level : 1
         * api_rank : 10
         * api_experience : 20
         * api_fleetname : null
         * api_comment :
         * api_comment_id :
         * api_max_chara : 100
         * api_max_slotitem : 497
         * api_max_kagu : 0
         * api_playtime : 0
         * api_tutorial : 0
         * api_furniture : [1,38,72,102,133,164]
         * api_count_deck : 1
         * api_count_kdock : 2
         * api_count_ndock : 2
         * api_fcoin : 0
         * api_st_win : 2
         * api_st_lose : 0
         * api_ms_count : 0
         * api_ms_success : 0
         * api_pt_win : 0
         * api_pt_lose : 0
         * api_pt_challenged : 0
         * api_pt_challenged_win : 0
         * api_firstflag : 1
         * api_tutorial_progress : 100
         * api_pvp : [0,0]
         * api_medals : 0
         * api_large_dock : 0
         */

        private ApiBasicEntity api_basic;
        private int api_p_bgm_id;
        private int api_parallel_quest_count;
        /**
         * api_member_id : 11141519
         * api_id : 1
         * api_value : 1020
         */

        private List<ApiMaterialEntity> api_material;
        /**
         * api_member_id : 11141519
         * api_id : 1
         * api_name : 第1艦隊
         * api_name_id :
         * api_mission : [0,0,0,0]
         * api_flagship : 0
         * api_ship : [1,2,3,4,-1,-1]
         */

        private List<ApiDeckPortEntity> api_deck_port;
        /**
         * api_member_id : 11141519
         * api_id : 1
         * api_state : 0
         * api_ship_id : 0
         * api_complete_time : 0
         * api_complete_time_str : 0
         * api_item1 : 0
         * api_item2 : 0
         * api_item3 : 0
         * api_item4 : 0
         */

        private List<ApiNdockEntity> api_ndock;
        /**
         * api_id : 1
         * api_sortno : 74
         * api_ship_id : 37
         * api_lv : 2
         * api_exp : [216,84,57]
         * api_nowhp : 15
         * api_maxhp : 15
         * api_leng : 1
         * api_slot : [3,-1,-1,-1,-1]
         * api_onslot : [0,0,0,0,0]
         * api_slot_ex : 0
         * api_kyouka : [0,2,1,0,0]
         * api_backs : 1
         * api_fuel : 15
         * api_bull : 20
         * api_slotnum : 2
         * api_ndock_time : 0
         * api_ndock_item : [0,0]
         * api_srate : 0
         * api_cond : 56
         * api_karyoku : [12,29]
         * api_raisou : [29,69]
         * api_taiku : [15,39]
         * api_soukou : [6,19]
         * api_kaihi : [42,79]
         * api_taisen : [20,49]
         * api_sakuteki : [5,19]
         * api_lucky : [10,49]
         * api_locked : 0
         * api_locked_equip : 0
         */

        private List<ApiShipData> api_ship;
        /**
         * api_no : 0
         * api_type : 1
         * api_state : 0
         * api_message : 「入渠」していた艦の修理が、完了しました。
         */

        private List<ApiLogEntity> api_log;

        public ApiBasicEntity getApi_basic() {
            return api_basic;
        }

        public void setApi_basic(ApiBasicEntity api_basic) {
            this.api_basic = api_basic;
        }

        public int getApi_p_bgm_id() {
            return api_p_bgm_id;
        }

        public void setApi_p_bgm_id(int api_p_bgm_id) {
            this.api_p_bgm_id = api_p_bgm_id;
        }

        public int getApi_parallel_quest_count() {
            return api_parallel_quest_count;
        }

        public void setApi_parallel_quest_count(int api_parallel_quest_count) {
            this.api_parallel_quest_count = api_parallel_quest_count;
        }

        public List<ApiMaterialEntity> getApi_material() {
            return api_material;
        }

        public void setApi_material(List<ApiMaterialEntity> api_material) {
            this.api_material = api_material;
        }

        public List<ApiDeckPortEntity> getApi_deck_port() {
            return api_deck_port;
        }

        public void setApi_deck_port(List<ApiDeckPortEntity> api_deck_port) {
            this.api_deck_port = api_deck_port;
        }

        public List<ApiNdockEntity> getApi_ndock() {
            return api_ndock;
        }

        public void setApi_ndock(List<ApiNdockEntity> api_ndock) {
            this.api_ndock = api_ndock;
        }

        public List<ApiShipData> getApi_ship() {
            return api_ship;
        }

        public void setApi_ship(List<ApiShipData> api_ship) {
            this.api_ship = api_ship;
        }

        public List<ApiLogEntity> getApi_log() {
            return api_log;
        }

        public void setApi_log(List<ApiLogEntity> api_log) {
            this.api_log = api_log;
        }

        public static class ApiBasicEntity {
            private String api_member_id;
            private String api_nickname;
            private String api_nickname_id;
            private int api_active_flag;
            private long api_starttime;
            private int api_level;
            private int api_rank;
            private int api_experience;
            private Object api_fleetname;
            private String api_comment;
            private String api_comment_id;
            private int api_max_chara;
            private int api_max_slotitem;
            private int api_max_kagu;
            private long api_playtime;
            private int api_tutorial;
            private int api_count_deck;
            private int api_count_kdock;
            private int api_count_ndock;
            private int api_fcoin;
            private int api_st_win;
            private int api_st_lose;
            private int api_ms_count;
            private int api_ms_success;
            private int api_pt_win;
            private int api_pt_lose;
            private int api_pt_challenged;
            private int api_pt_challenged_win;
            private int api_firstflag;
            private int api_tutorial_progress;
            private int api_medals;
            private int api_large_dock;
            private List<Integer> api_furniture;
            private List<Integer> api_pvp;

            public String getApi_member_id() {
                return api_member_id;
            }

            public void setApi_member_id(String api_member_id) {
                this.api_member_id = api_member_id;
            }

            public String getApi_nickname() {
                return api_nickname;
            }

            public void setApi_nickname(String api_nickname) {
                this.api_nickname = api_nickname;
            }

            public String getApi_nickname_id() {
                return api_nickname_id;
            }

            public void setApi_nickname_id(String api_nickname_id) {
                this.api_nickname_id = api_nickname_id;
            }

            public int getApi_active_flag() {
                return api_active_flag;
            }

            public void setApi_active_flag(int api_active_flag) {
                this.api_active_flag = api_active_flag;
            }

            public long getApi_starttime() {
                return api_starttime;
            }

            public void setApi_starttime(long api_starttime) {
                this.api_starttime = api_starttime;
            }

            public int getApi_level() {
                return api_level;
            }

            public void setApi_level(int api_level) {
                this.api_level = api_level;
            }

            public int getApi_rank() {
                return api_rank;
            }

            public void setApi_rank(int api_rank) {
                this.api_rank = api_rank;
            }

            public int getApi_experience() {
                return api_experience;
            }

            public void setApi_experience(int api_experience) {
                this.api_experience = api_experience;
            }

            public Object getApi_fleetname() {
                return api_fleetname;
            }

            public void setApi_fleetname(Object api_fleetname) {
                this.api_fleetname = api_fleetname;
            }

            public String getApi_comment() {
                return api_comment;
            }

            public void setApi_comment(String api_comment) {
                this.api_comment = api_comment;
            }

            public String getApi_comment_id() {
                return api_comment_id;
            }

            public void setApi_comment_id(String api_comment_id) {
                this.api_comment_id = api_comment_id;
            }

            public int getApi_max_chara() {
                return api_max_chara;
            }

            public void setApi_max_chara(int api_max_chara) {
                this.api_max_chara = api_max_chara;
            }

            public int getApi_max_slotitem() {
                return api_max_slotitem;
            }

            public void setApi_max_slotitem(int api_max_slotitem) {
                this.api_max_slotitem = api_max_slotitem;
            }

            public int getApi_max_kagu() {
                return api_max_kagu;
            }

            public void setApi_max_kagu(int api_max_kagu) {
                this.api_max_kagu = api_max_kagu;
            }

            public long getApi_playtime() {
                return api_playtime;
            }

            public void setApi_playtime(long api_playtime) {
                this.api_playtime = api_playtime;
            }

            public int getApi_tutorial() {
                return api_tutorial;
            }

            public void setApi_tutorial(int api_tutorial) {
                this.api_tutorial = api_tutorial;
            }

            public int getApi_count_deck() {
                return api_count_deck;
            }

            public void setApi_count_deck(int api_count_deck) {
                this.api_count_deck = api_count_deck;
            }

            public int getApi_count_kdock() {
                return api_count_kdock;
            }

            public void setApi_count_kdock(int api_count_kdock) {
                this.api_count_kdock = api_count_kdock;
            }

            public int getApi_count_ndock() {
                return api_count_ndock;
            }

            public void setApi_count_ndock(int api_count_ndock) {
                this.api_count_ndock = api_count_ndock;
            }

            public int getApi_fcoin() {
                return api_fcoin;
            }

            public void setApi_fcoin(int api_fcoin) {
                this.api_fcoin = api_fcoin;
            }

            public int getApi_st_win() {
                return api_st_win;
            }

            public void setApi_st_win(int api_st_win) {
                this.api_st_win = api_st_win;
            }

            public int getApi_st_lose() {
                return api_st_lose;
            }

            public void setApi_st_lose(int api_st_lose) {
                this.api_st_lose = api_st_lose;
            }

            public int getApi_ms_count() {
                return api_ms_count;
            }

            public void setApi_ms_count(int api_ms_count) {
                this.api_ms_count = api_ms_count;
            }

            public int getApi_ms_success() {
                return api_ms_success;
            }

            public void setApi_ms_success(int api_ms_success) {
                this.api_ms_success = api_ms_success;
            }

            public int getApi_pt_win() {
                return api_pt_win;
            }

            public void setApi_pt_win(int api_pt_win) {
                this.api_pt_win = api_pt_win;
            }

            public int getApi_pt_lose() {
                return api_pt_lose;
            }

            public void setApi_pt_lose(int api_pt_lose) {
                this.api_pt_lose = api_pt_lose;
            }

            public int getApi_pt_challenged() {
                return api_pt_challenged;
            }

            public void setApi_pt_challenged(int api_pt_challenged) {
                this.api_pt_challenged = api_pt_challenged;
            }

            public int getApi_pt_challenged_win() {
                return api_pt_challenged_win;
            }

            public void setApi_pt_challenged_win(int api_pt_challenged_win) {
                this.api_pt_challenged_win = api_pt_challenged_win;
            }

            public int getApi_firstflag() {
                return api_firstflag;
            }

            public void setApi_firstflag(int api_firstflag) {
                this.api_firstflag = api_firstflag;
            }

            public int getApi_tutorial_progress() {
                return api_tutorial_progress;
            }

            public void setApi_tutorial_progress(int api_tutorial_progress) {
                this.api_tutorial_progress = api_tutorial_progress;
            }

            public int getApi_medals() {
                return api_medals;
            }

            public void setApi_medals(int api_medals) {
                this.api_medals = api_medals;
            }

            public int getApi_large_dock() {
                return api_large_dock;
            }

            public void setApi_large_dock(int api_large_dock) {
                this.api_large_dock = api_large_dock;
            }

            public List<Integer> getApi_furniture() {
                return api_furniture;
            }

            public void setApi_furniture(List<Integer> api_furniture) {
                this.api_furniture = api_furniture;
            }

            public List<Integer> getApi_pvp() {
                return api_pvp;
            }

            public void setApi_pvp(List<Integer> api_pvp) {
                this.api_pvp = api_pvp;
            }
        }

        public static class ApiMaterialEntity {
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

        public static class ApiDeckPortEntity {
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

        public static class ApiNdockEntity {
            private int api_member_id;
            private int api_id;
            private int api_state;
            private int api_ship_id;
            private long api_complete_time;
            private String api_complete_time_str;
            private int api_item1;
            private int api_item2;
            private int api_item3;
            private int api_item4;

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

            public int getApi_state() {
                return api_state;
            }

            public void setApi_state(int api_state) {
                this.api_state = api_state;
            }

            public int getApi_ship_id() {
                return api_ship_id;
            }

            public void setApi_ship_id(int api_ship_id) {
                this.api_ship_id = api_ship_id;
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
        }

        public static class ApiLogEntity {
            private int api_no;
            private String api_type;
            private String api_state;
            private String api_message;

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public String getApi_type() {
                return api_type;
            }

            public void setApi_type(String api_type) {
                this.api_type = api_type;
            }

            public String getApi_state() {
                return api_state;
            }

            public void setApi_state(String api_state) {
                this.api_state = api_state;
            }

            public String getApi_message() {
                return api_message;
            }

            public void setApi_message(String api_message) {
                this.api_message = api_message;
            }
        }
    }
}
