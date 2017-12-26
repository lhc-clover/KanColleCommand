package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class GetShip extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_id":85,"api_ship_id":56,"api_kdock":[{"api_id":1,"api_state":0,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":1},{"api_id":2,"api_state":0,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":1},{"api_id":3,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0},{"api_id":4,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0}],"api_ship":{"api_id":85,"api_sortno":48,"api_ship_id":56,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":26,"api_maxhp":26,"api_soku":10,"api_leng":2,"api_slot":[118,-1,-1,-1,-1],"api_onslot":[1,1,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0,0,0],"api_backs":2,"api_fuel":25,"api_bull":25,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":40,"api_karyoku":[16,39],"api_raisou":[24,79],"api_taiku":[13,49],"api_soukou":[11,29],"api_kaihi":[38,69],"api_taisen":[24,69],"api_sakuteki":[8,39],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0,"api_sally_area":0},"api_slotitem":[{"api_id":118,"api_slotitem_id":4}]}
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
         * api_id : 85
         * api_ship_id : 56
         * api_kdock : [{"api_id":1,"api_state":0,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":1},{"api_id":2,"api_state":0,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":1},{"api_id":3,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0},{"api_id":4,"api_state":-1,"api_created_ship_id":0,"api_complete_time":0,"api_complete_time_str":"0","api_item1":0,"api_item2":0,"api_item3":0,"api_item4":0,"api_item5":0}]
         * api_ship : {"api_id":85,"api_sortno":48,"api_ship_id":56,"api_lv":1,"api_exp":[0,100,0],"api_nowhp":26,"api_maxhp":26,"api_soku":10,"api_leng":2,"api_slot":[118,-1,-1,-1,-1],"api_onslot":[1,1,0,0,0],"api_slot_ex":0,"api_kyouka":[0,0,0,0,0,0,0],"api_backs":2,"api_fuel":25,"api_bull":25,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":40,"api_karyoku":[16,39],"api_raisou":[24,79],"api_taiku":[13,49],"api_soukou":[11,29],"api_kaihi":[38,69],"api_taisen":[24,69],"api_sakuteki":[8,39],"api_lucky":[10,49],"api_locked":0,"api_locked_equip":0,"api_sally_area":0}
         * api_slotitem : [{"api_id":118,"api_slotitem_id":4}]
         */

        private int api_id;
        private int api_ship_id;
        private ApiShipBean api_ship;
        private List<ApiKdockBean> api_kdock;
        private List<ApiSlotitemBean> api_slotitem;

        public int getApi_id() {
            return api_id;
        }

        public void setApi_id(int api_id) {
            this.api_id = api_id;
        }

        public int getApi_ship_id() {
            return api_ship_id;
        }

        public void setApi_ship_id(int api_ship_id) {
            this.api_ship_id = api_ship_id;
        }

        public ApiShipBean getApi_ship() {
            return api_ship;
        }

        public void setApi_ship(ApiShipBean api_ship) {
            this.api_ship = api_ship;
        }

        public List<ApiKdockBean> getApi_kdock() {
            return api_kdock;
        }

        public void setApi_kdock(List<ApiKdockBean> api_kdock) {
            this.api_kdock = api_kdock;
        }

        public List<ApiSlotitemBean> getApi_slotitem() {
            return api_slotitem;
        }

        public void setApi_slotitem(List<ApiSlotitemBean> api_slotitem) {
            this.api_slotitem = api_slotitem;
        }

        public static class ApiShipBean {
            /**
             * api_id : 85
             * api_sortno : 48
             * api_ship_id : 56
             * api_lv : 1
             * api_exp : [0,100,0]
             * api_nowhp : 26
             * api_maxhp : 26
             * api_soku : 10
             * api_leng : 2
             * api_slot : [118,-1,-1,-1,-1]
             * api_onslot : [1,1,0,0,0]
             * api_slot_ex : 0
             * api_kyouka : [0,0,0,0,0,0,0]
             * api_backs : 2
             * api_fuel : 25
             * api_bull : 25
             * api_slotnum : 2
             * api_ndock_time : 0
             * api_ndock_item : [0,0]
             * api_srate : 0
             * api_cond : 40
             * api_karyoku : [16,39]
             * api_raisou : [24,79]
             * api_taiku : [13,49]
             * api_soukou : [11,29]
             * api_kaihi : [38,69]
             * api_taisen : [24,69]
             * api_sakuteki : [8,39]
             * api_lucky : [10,49]
             * api_locked : 0
             * api_locked_equip : 0
             * api_sally_area : 0
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
            private int api_sally_area;
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

            public int getApi_sally_area() {
                return api_sally_area;
            }

            public void setApi_sally_area(int api_sally_area) {
                this.api_sally_area = api_sally_area;
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

        public static class ApiKdockBean {
            /**
             * api_id : 1
             * api_state : 0
             * api_created_ship_id : 0
             * api_complete_time : 0
             * api_complete_time_str : 0
             * api_item1 : 0
             * api_item2 : 0
             * api_item3 : 0
             * api_item4 : 0
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

        public static class ApiSlotitemBean {
            /**
             * api_id : 118
             * api_slotitem_id : 4
             */

            private int api_id;
            private int api_slotitem_id;

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
        }
    }
}
