package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class PowerUp extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_powerup_flag":1,"api_ship":{"api_id":6084,"api_sortno":1472,"api_ship_id":392,"api_lv":53,"api_exp":[140306,3394,39],"api_nowhp":89,"api_maxhp":89,"api_soku":10,"api_leng":3,"api_slot":[10993,10994,8752,10910,-1],"api_onslot":[3,3,3,3,0],"api_slot_ex":0,"api_kyouka":[20,0,34,18,0,0,0],"api_backs":8,"api_fuel":100,"api_bull":130,"api_slotnum":4,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":3,"api_cond":49,"api_karyoku":[138,96],"api_raisou":[0,0],"api_taiku":[67,78],"api_soukou":[97,96],"api_kaihi":[57,73],"api_taisen":[2,0],"api_sakuteki":[41,54],"api_lucky":[24,95],"api_locked":1,"api_locked_equip":0},"api_deck":[{"api_member_id":10104315,"api_id":1,"api_name":"第1艦隊","api_name_id":"162790307","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[687,3505,3963,6141,130,133]},{"api_member_id":10104315,"api_id":2,"api_name":"第2艦隊","api_name_id":"147651300","api_mission":[1,38,1515753603743,0],"api_flagship":"0","api_ship":[2092,4089,3037,3299,1717,792]},{"api_member_id":10104315,"api_id":3,"api_name":"第3艦隊","api_name_id":"151153234","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[482,4710,6067,5957,-1,-1]},{"api_member_id":10104315,"api_id":4,"api_name":"第4艦隊","api_name_id":"160743189","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[5457,5334,5972,3998,-1,-1]}]}
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
         * api_powerup_flag : 1
         * api_ship : {"api_id":6084,"api_sortno":1472,"api_ship_id":392,"api_lv":53,"api_exp":[140306,3394,39],"api_nowhp":89,"api_maxhp":89,"api_soku":10,"api_leng":3,"api_slot":[10993,10994,8752,10910,-1],"api_onslot":[3,3,3,3,0],"api_slot_ex":0,"api_kyouka":[20,0,34,18,0,0,0],"api_backs":8,"api_fuel":100,"api_bull":130,"api_slotnum":4,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":3,"api_cond":49,"api_karyoku":[138,96],"api_raisou":[0,0],"api_taiku":[67,78],"api_soukou":[97,96],"api_kaihi":[57,73],"api_taisen":[2,0],"api_sakuteki":[41,54],"api_lucky":[24,95],"api_locked":1,"api_locked_equip":0}
         * api_deck : [{"api_member_id":10104315,"api_id":1,"api_name":"第1艦隊","api_name_id":"162790307","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[687,3505,3963,6141,130,133]},{"api_member_id":10104315,"api_id":2,"api_name":"第2艦隊","api_name_id":"147651300","api_mission":[1,38,1515753603743,0],"api_flagship":"0","api_ship":[2092,4089,3037,3299,1717,792]},{"api_member_id":10104315,"api_id":3,"api_name":"第3艦隊","api_name_id":"151153234","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[482,4710,6067,5957,-1,-1]},{"api_member_id":10104315,"api_id":4,"api_name":"第4艦隊","api_name_id":"160743189","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[5457,5334,5972,3998,-1,-1]}]
         */

        private int api_powerup_flag;
        private ApiShipBean api_ship;
        private List<ApiDeckBean> api_deck;

        public int getApi_powerup_flag() {
            return api_powerup_flag;
        }

        public void setApi_powerup_flag(int api_powerup_flag) {
            this.api_powerup_flag = api_powerup_flag;
        }

        public ApiShipBean getApi_ship() {
            return api_ship;
        }

        public void setApi_ship(ApiShipBean api_ship) {
            this.api_ship = api_ship;
        }

        public List<ApiDeckBean> getApi_deck() {
            return api_deck;
        }

        public void setApi_deck(List<ApiDeckBean> api_deck) {
            this.api_deck = api_deck;
        }

        public static class ApiShipBean {
            /**
             * api_id : 6084
             * api_sortno : 1472
             * api_ship_id : 392
             * api_lv : 53
             * api_exp : [140306,3394,39]
             * api_nowhp : 89
             * api_maxhp : 89
             * api_soku : 10
             * api_leng : 3
             * api_slot : [10993,10994,8752,10910,-1]
             * api_onslot : [3,3,3,3,0]
             * api_slot_ex : 0
             * api_kyouka : [20,0,34,18,0,0,0]
             * api_backs : 8
             * api_fuel : 100
             * api_bull : 130
             * api_slotnum : 4
             * api_ndock_time : 0
             * api_ndock_item : [0,0]
             * api_srate : 3
             * api_cond : 49
             * api_karyoku : [138,96]
             * api_raisou : [0,0]
             * api_taiku : [67,78]
             * api_soukou : [97,96]
             * api_kaihi : [57,73]
             * api_taisen : [2,0]
             * api_sakuteki : [41,54]
             * api_lucky : [24,95]
             * api_locked : 1
             * api_locked_equip : 0
             */

            private int api_id;
            private int api_sortno;
            private int api_ship_id;
            private int api_lv;
            private int api_nowhp;
            private int api_maxhp;
            private int api_soku;
            private int api_leng;
            private int api_slot_ex;
            private int api_backs;
            private int api_fuel;
            private int api_bull;
            private int api_slotnum;
            private int api_ndock_time;
            private int api_srate;
            private int api_cond;
            private int api_locked;
            private int api_locked_equip;
            private List<Integer> api_exp;
            private List<Integer> api_slot;
            private List<Integer> api_onslot;
            private List<Integer> api_kyouka;
            private List<Integer> api_ndock_item;
            private List<Integer> api_karyoku;
            private List<Integer> api_raisou;
            private List<Integer> api_taiku;
            private List<Integer> api_soukou;
            private List<Integer> api_kaihi;
            private List<Integer> api_taisen;
            private List<Integer> api_sakuteki;
            private List<Integer> api_lucky;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_sortno() {
                return api_sortno;
            }

            public void setApi_sortno(int api_sortno) {
                this.api_sortno = api_sortno;
            }

            public int getApi_ship_id() {
                return api_ship_id;
            }

            public void setApi_ship_id(int api_ship_id) {
                this.api_ship_id = api_ship_id;
            }

            public int getApi_lv() {
                return api_lv;
            }

            public void setApi_lv(int api_lv) {
                this.api_lv = api_lv;
            }

            public int getApi_nowhp() {
                return api_nowhp;
            }

            public void setApi_nowhp(int api_nowhp) {
                this.api_nowhp = api_nowhp;
            }

            public int getApi_maxhp() {
                return api_maxhp;
            }

            public void setApi_maxhp(int api_maxhp) {
                this.api_maxhp = api_maxhp;
            }

            public int getApi_soku() {
                return api_soku;
            }

            public void setApi_soku(int api_soku) {
                this.api_soku = api_soku;
            }

            public int getApi_leng() {
                return api_leng;
            }

            public void setApi_leng(int api_leng) {
                this.api_leng = api_leng;
            }

            public int getApi_slot_ex() {
                return api_slot_ex;
            }

            public void setApi_slot_ex(int api_slot_ex) {
                this.api_slot_ex = api_slot_ex;
            }

            public int getApi_backs() {
                return api_backs;
            }

            public void setApi_backs(int api_backs) {
                this.api_backs = api_backs;
            }

            public int getApi_fuel() {
                return api_fuel;
            }

            public void setApi_fuel(int api_fuel) {
                this.api_fuel = api_fuel;
            }

            public int getApi_bull() {
                return api_bull;
            }

            public void setApi_bull(int api_bull) {
                this.api_bull = api_bull;
            }

            public int getApi_slotnum() {
                return api_slotnum;
            }

            public void setApi_slotnum(int api_slotnum) {
                this.api_slotnum = api_slotnum;
            }

            public int getApi_ndock_time() {
                return api_ndock_time;
            }

            public void setApi_ndock_time(int api_ndock_time) {
                this.api_ndock_time = api_ndock_time;
            }

            public int getApi_srate() {
                return api_srate;
            }

            public void setApi_srate(int api_srate) {
                this.api_srate = api_srate;
            }

            public int getApi_cond() {
                return api_cond;
            }

            public void setApi_cond(int api_cond) {
                this.api_cond = api_cond;
            }

            public int getApi_locked() {
                return api_locked;
            }

            public void setApi_locked(int api_locked) {
                this.api_locked = api_locked;
            }

            public int getApi_locked_equip() {
                return api_locked_equip;
            }

            public void setApi_locked_equip(int api_locked_equip) {
                this.api_locked_equip = api_locked_equip;
            }

            public List<Integer> getApi_exp() {
                return api_exp;
            }

            public void setApi_exp(List<Integer> api_exp) {
                this.api_exp = api_exp;
            }

            public List<Integer> getApi_slot() {
                return api_slot;
            }

            public void setApi_slot(List<Integer> api_slot) {
                this.api_slot = api_slot;
            }

            public List<Integer> getApi_onslot() {
                return api_onslot;
            }

            public void setApi_onslot(List<Integer> api_onslot) {
                this.api_onslot = api_onslot;
            }

            public List<Integer> getApi_kyouka() {
                return api_kyouka;
            }

            public void setApi_kyouka(List<Integer> api_kyouka) {
                this.api_kyouka = api_kyouka;
            }

            public List<Integer> getApi_ndock_item() {
                return api_ndock_item;
            }

            public void setApi_ndock_item(List<Integer> api_ndock_item) {
                this.api_ndock_item = api_ndock_item;
            }

            public List<Integer> getApi_karyoku() {
                return api_karyoku;
            }

            public void setApi_karyoku(List<Integer> api_karyoku) {
                this.api_karyoku = api_karyoku;
            }

            public List<Integer> getApi_raisou() {
                return api_raisou;
            }

            public void setApi_raisou(List<Integer> api_raisou) {
                this.api_raisou = api_raisou;
            }

            public List<Integer> getApi_taiku() {
                return api_taiku;
            }

            public void setApi_taiku(List<Integer> api_taiku) {
                this.api_taiku = api_taiku;
            }

            public List<Integer> getApi_soukou() {
                return api_soukou;
            }

            public void setApi_soukou(List<Integer> api_soukou) {
                this.api_soukou = api_soukou;
            }

            public List<Integer> getApi_kaihi() {
                return api_kaihi;
            }

            public void setApi_kaihi(List<Integer> api_kaihi) {
                this.api_kaihi = api_kaihi;
            }

            public List<Integer> getApi_taisen() {
                return api_taisen;
            }

            public void setApi_taisen(List<Integer> api_taisen) {
                this.api_taisen = api_taisen;
            }

            public List<Integer> getApi_sakuteki() {
                return api_sakuteki;
            }

            public void setApi_sakuteki(List<Integer> api_sakuteki) {
                this.api_sakuteki = api_sakuteki;
            }

            public List<Integer> getApi_lucky() {
                return api_lucky;
            }

            public void setApi_lucky(List<Integer> api_lucky) {
                this.api_lucky = api_lucky;
            }
        }

        public static class ApiDeckBean {
            /**
             * api_member_id : 10104315
             * api_id : 1
             * api_name : 第1艦隊
             * api_name_id : 162790307
             * api_mission : [0,0,0,0]
             * api_flagship : 0
             * api_ship : [687,3505,3963,6141,130,133]
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
}
