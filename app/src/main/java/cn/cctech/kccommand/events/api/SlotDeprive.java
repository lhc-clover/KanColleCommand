package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class SlotDeprive extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_ship_data":{"api_set_ship":{"api_id":133,"api_sortno":122,"api_ship_id":297,"api_lv":99,"api_exp":[1000000,0,0],"api_nowhp":18,"api_maxhp":58,"api_soku":10,"api_leng":1,"api_slot":[8255,747,10623,2703,-1],"api_onslot":[24,16,11,8,0],"api_slot_ex":0,"api_kyouka":[34,0,42,33,0,0,0],"api_backs":6,"api_fuel":45,"api_bull":40,"api_slotnum":4,"api_ndock_time":38130000,"api_ndock_item":[57,108],"api_srate":4,"api_cond":49,"api_karyoku":[34,34],"api_raisou":[23,0],"api_taiku":[80,72],"api_soukou":[65,65],"api_kaihi":[72,69],"api_taisen":[18,0],"api_sakuteki":[86,79],"api_lucky":[13,59],"api_locked":1,"api_locked_equip":0},"api_unset_ship":{"api_id":4757,"api_sortno":1445,"api_ship_id":365,"api_lv":86,"api_exp":[476444,15056,11],"api_nowhp":48,"api_maxhp":48,"api_soku":10,"api_leng":1,"api_slot":[3223,-1,-1,-1,-1],"api_onslot":[15,26,15,10,0],"api_slot_ex":0,"api_kyouka":[24,0,42,29,0,0,0],"api_backs":8,"api_fuel":45,"api_bull":55,"api_slotnum":4,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":4,"api_cond":65,"api_karyoku":[24,24],"api_raisou":[8,0],"api_taiku":[72,72],"api_soukou":[57,57],"api_kaihi":[66,72],"api_taisen":[5,0],"api_sakuteki":[69,72],"api_lucky":[7,37],"api_locked":1,"api_locked_equip":0}},"api_unset_list":{"api_type3No":4,"api_slot_list":[2875,4947,10756,532,2560,2842,11096,1535,1539,712,2049,5586,952,5839,5885,2568,1979,5740,5856,6860,6625]}}
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
         * api_ship_data : {"api_set_ship":{"api_id":133,"api_sortno":122,"api_ship_id":297,"api_lv":99,"api_exp":[1000000,0,0],"api_nowhp":18,"api_maxhp":58,"api_soku":10,"api_leng":1,"api_slot":[8255,747,10623,2703,-1],"api_onslot":[24,16,11,8,0],"api_slot_ex":0,"api_kyouka":[34,0,42,33,0,0,0],"api_backs":6,"api_fuel":45,"api_bull":40,"api_slotnum":4,"api_ndock_time":38130000,"api_ndock_item":[57,108],"api_srate":4,"api_cond":49,"api_karyoku":[34,34],"api_raisou":[23,0],"api_taiku":[80,72],"api_soukou":[65,65],"api_kaihi":[72,69],"api_taisen":[18,0],"api_sakuteki":[86,79],"api_lucky":[13,59],"api_locked":1,"api_locked_equip":0},"api_unset_ship":{"api_id":4757,"api_sortno":1445,"api_ship_id":365,"api_lv":86,"api_exp":[476444,15056,11],"api_nowhp":48,"api_maxhp":48,"api_soku":10,"api_leng":1,"api_slot":[3223,-1,-1,-1,-1],"api_onslot":[15,26,15,10,0],"api_slot_ex":0,"api_kyouka":[24,0,42,29,0,0,0],"api_backs":8,"api_fuel":45,"api_bull":55,"api_slotnum":4,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":4,"api_cond":65,"api_karyoku":[24,24],"api_raisou":[8,0],"api_taiku":[72,72],"api_soukou":[57,57],"api_kaihi":[66,72],"api_taisen":[5,0],"api_sakuteki":[69,72],"api_lucky":[7,37],"api_locked":1,"api_locked_equip":0}}
         * api_unset_list : {"api_type3No":4,"api_slot_list":[2875,4947,10756,532,2560,2842,11096,1535,1539,712,2049,5586,952,5839,5885,2568,1979,5740,5856,6860,6625]}
         */

        private ApiShipDataBean api_ship_data;
        private ApiUnsetListBean api_unset_list;

        public ApiShipDataBean getApi_ship_data() {
            return api_ship_data;
        }

        public void setApi_ship_data(ApiShipDataBean api_ship_data) {
            this.api_ship_data = api_ship_data;
        }

        public ApiUnsetListBean getApi_unset_list() {
            return api_unset_list;
        }

        public void setApi_unset_list(ApiUnsetListBean api_unset_list) {
            this.api_unset_list = api_unset_list;
        }

        public static class ApiShipDataBean {
            /**
             * api_set_ship : {"api_id":133,"api_sortno":122,"api_ship_id":297,"api_lv":99,"api_exp":[1000000,0,0],"api_nowhp":18,"api_maxhp":58,"api_soku":10,"api_leng":1,"api_slot":[8255,747,10623,2703,-1],"api_onslot":[24,16,11,8,0],"api_slot_ex":0,"api_kyouka":[34,0,42,33,0,0,0],"api_backs":6,"api_fuel":45,"api_bull":40,"api_slotnum":4,"api_ndock_time":38130000,"api_ndock_item":[57,108],"api_srate":4,"api_cond":49,"api_karyoku":[34,34],"api_raisou":[23,0],"api_taiku":[80,72],"api_soukou":[65,65],"api_kaihi":[72,69],"api_taisen":[18,0],"api_sakuteki":[86,79],"api_lucky":[13,59],"api_locked":1,"api_locked_equip":0}
             * api_unset_ship : {"api_id":4757,"api_sortno":1445,"api_ship_id":365,"api_lv":86,"api_exp":[476444,15056,11],"api_nowhp":48,"api_maxhp":48,"api_soku":10,"api_leng":1,"api_slot":[3223,-1,-1,-1,-1],"api_onslot":[15,26,15,10,0],"api_slot_ex":0,"api_kyouka":[24,0,42,29,0,0,0],"api_backs":8,"api_fuel":45,"api_bull":55,"api_slotnum":4,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":4,"api_cond":65,"api_karyoku":[24,24],"api_raisou":[8,0],"api_taiku":[72,72],"api_soukou":[57,57],"api_kaihi":[66,72],"api_taisen":[5,0],"api_sakuteki":[69,72],"api_lucky":[7,37],"api_locked":1,"api_locked_equip":0}
             */

            private ApiSetShipBean api_set_ship;
            private ApiUnsetShipBean api_unset_ship;

            public ApiSetShipBean getApi_set_ship() {
                return api_set_ship;
            }

            public void setApi_set_ship(ApiSetShipBean api_set_ship) {
                this.api_set_ship = api_set_ship;
            }

            public ApiUnsetShipBean getApi_unset_ship() {
                return api_unset_ship;
            }

            public void setApi_unset_ship(ApiUnsetShipBean api_unset_ship) {
                this.api_unset_ship = api_unset_ship;
            }

            public static class ApiSetShipBean {
                /**
                 * api_id : 133
                 * api_sortno : 122
                 * api_ship_id : 297
                 * api_lv : 99
                 * api_exp : [1000000,0,0]
                 * api_nowhp : 18
                 * api_maxhp : 58
                 * api_soku : 10
                 * api_leng : 1
                 * api_slot : [8255,747,10623,2703,-1]
                 * api_onslot : [24,16,11,8,0]
                 * api_slot_ex : 0
                 * api_kyouka : [34,0,42,33,0,0,0]
                 * api_backs : 6
                 * api_fuel : 45
                 * api_bull : 40
                 * api_slotnum : 4
                 * api_ndock_time : 38130000
                 * api_ndock_item : [57,108]
                 * api_srate : 4
                 * api_cond : 49
                 * api_karyoku : [34,34]
                 * api_raisou : [23,0]
                 * api_taiku : [80,72]
                 * api_soukou : [65,65]
                 * api_kaihi : [72,69]
                 * api_taisen : [18,0]
                 * api_sakuteki : [86,79]
                 * api_lucky : [13,59]
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

            public static class ApiUnsetShipBean {
                /**
                 * api_id : 4757
                 * api_sortno : 1445
                 * api_ship_id : 365
                 * api_lv : 86
                 * api_exp : [476444,15056,11]
                 * api_nowhp : 48
                 * api_maxhp : 48
                 * api_soku : 10
                 * api_leng : 1
                 * api_slot : [3223,-1,-1,-1,-1]
                 * api_onslot : [15,26,15,10,0]
                 * api_slot_ex : 0
                 * api_kyouka : [24,0,42,29,0,0,0]
                 * api_backs : 8
                 * api_fuel : 45
                 * api_bull : 55
                 * api_slotnum : 4
                 * api_ndock_time : 0
                 * api_ndock_item : [0,0]
                 * api_srate : 4
                 * api_cond : 65
                 * api_karyoku : [24,24]
                 * api_raisou : [8,0]
                 * api_taiku : [72,72]
                 * api_soukou : [57,57]
                 * api_kaihi : [66,72]
                 * api_taisen : [5,0]
                 * api_sakuteki : [69,72]
                 * api_lucky : [7,37]
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
        }

        public static class ApiUnsetListBean {
            /**
             * api_type3No : 4
             * api_slot_list : [2875,4947,10756,532,2560,2842,11096,1535,1539,712,2049,5586,952,5839,5885,2568,1979,5740,5856,6860,6625]
             */

            private int api_type3No;
            private List<Integer> api_slot_list;

            public int getApi_type3No() {
                return api_type3No;
            }

            public void setApi_type3No(int api_type3No) {
                this.api_type3No = api_type3No;
            }

            public List<Integer> getApi_slot_list() {
                return api_slot_list;
            }

            public void setApi_slot_list(List<Integer> api_slot_list) {
                this.api_slot_list = api_slot_list;
            }
        }
    }
}
