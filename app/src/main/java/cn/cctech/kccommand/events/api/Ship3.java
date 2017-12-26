package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.entities.ApiShipData;
import cn.cctech.kccommand.events.JsonEvent;

public class Ship3 extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_ship_data":[{"api_id":6,"api_sortno":35,"api_ship_id":6,"api_lv":4,"api_exp":[612,388,3],"api_nowhp":13,"api_maxhp":13,"api_soku":10,"api_leng":1,"api_slot":[8,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[4,1,1,1,0],"api_backs":2,"api_fuel":15,"api_bull":15,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[11,29],"api_raisou":[19,49],"api_taiku":[9,29],"api_soukou":[6,18],"api_kaihi":[38,69],"api_taisen":[16,39],"api_sakuteki":[4,17],"api_lucky":[15,69],"api_locked":0,"api_locked_equip":0}],"api_deck_data":[{"api_member_id":11141519,"api_id":1,"api_name":"第1艦隊","api_name_id":"","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[6,4,1,2,8,5]}],"api_slot_data":{"api_slottype1":[7],"api_slottype2":-1,"api_slottype3":-1,"api_slottype4":-1,"api_slottype5":-1,"api_slottype6":-1,"api_slottype7":-1,"api_slottype8":-1,"api_slottype9":-1,"api_slottype10":-1,"api_slottype11":-1,"api_slottype12":-1,"api_slottype13":-1,"api_slottype14":-1,"api_slottype15":-1,"api_slottype16":-1,"api_slottype17":-1,"api_slottype18":-1,"api_slottype19":-1,"api_slottype20":-1,"api_slottype21":-1,"api_slottype22":-1,"api_slottype23":[1,2],"api_slottype24":-1,"api_slottype25":-1,"api_slottype26":-1,"api_slottype27":-1,"api_slottype28":-1,"api_slottype29":-1,"api_slottype30":-1,"api_slottype31":-1,"api_slottype32":-1,"api_slottype33":-1,"api_slottype34":-1,"api_slottype35":-1,"api_slottype36":-1,"api_slottype37":-1,"api_slottype38":-1,"api_slottype39":-1,"api_slottype40":-1,"api_slottype41":-1,"api_slottype42":-1,"api_slottype43":-1,"api_slottype44":-1,"api_slottype45":-1,"api_slottype46":-1,"api_slottype47":-1,"api_slottype48":-1,"api_slottype56":-1,"api_slottype57":-1,"api_slottype58":-1,"api_slottype59":-1}}
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
         * api_ship_data : [{"api_id":6,"api_sortno":35,"api_ship_id":6,"api_lv":4,"api_exp":[612,388,3],"api_nowhp":13,"api_maxhp":13,"api_soku":10,"api_leng":1,"api_slot":[8,-1,-1,-1,-1],"api_onslot":[0,0,0,0,0],"api_slot_ex":0,"api_kyouka":[4,1,1,1,0],"api_backs":2,"api_fuel":15,"api_bull":15,"api_slotnum":2,"api_ndock_time":0,"api_ndock_item":[0,0],"api_srate":0,"api_cond":49,"api_karyoku":[11,29],"api_raisou":[19,49],"api_taiku":[9,29],"api_soukou":[6,18],"api_kaihi":[38,69],"api_taisen":[16,39],"api_sakuteki":[4,17],"api_lucky":[15,69],"api_locked":0,"api_locked_equip":0}]
         * api_deck_data : [{"api_member_id":11141519,"api_id":1,"api_name":"第1艦隊","api_name_id":"","api_mission":[0,0,0,0],"api_flagship":"0","api_ship":[6,4,1,2,8,5]}]
         * api_slot_data : {"api_slottype1":[7],"api_slottype2":-1,"api_slottype3":-1,"api_slottype4":-1,"api_slottype5":-1,"api_slottype6":-1,"api_slottype7":-1,"api_slottype8":-1,"api_slottype9":-1,"api_slottype10":-1,"api_slottype11":-1,"api_slottype12":-1,"api_slottype13":-1,"api_slottype14":-1,"api_slottype15":-1,"api_slottype16":-1,"api_slottype17":-1,"api_slottype18":-1,"api_slottype19":-1,"api_slottype20":-1,"api_slottype21":-1,"api_slottype22":-1,"api_slottype23":[1,2],"api_slottype24":-1,"api_slottype25":-1,"api_slottype26":-1,"api_slottype27":-1,"api_slottype28":-1,"api_slottype29":-1,"api_slottype30":-1,"api_slottype31":-1,"api_slottype32":-1,"api_slottype33":-1,"api_slottype34":-1,"api_slottype35":-1,"api_slottype36":-1,"api_slottype37":-1,"api_slottype38":-1,"api_slottype39":-1,"api_slottype40":-1,"api_slottype41":-1,"api_slottype42":-1,"api_slottype43":-1,"api_slottype44":-1,"api_slottype45":-1,"api_slottype46":-1,"api_slottype47":-1,"api_slottype48":-1,"api_slottype56":-1,"api_slottype57":-1,"api_slottype58":-1,"api_slottype59":-1}
         */

//        private ApiSlotDataBean api_slot_data;
        private List<ApiShipData> api_ship_data;
        private List<ApiDeckDataBean> api_deck_data;

//        public ApiSlotDataBean getApi_slot_data() {
//            return api_slot_data;
//        }
//
//        public void setApi_slot_data(ApiSlotDataBean api_slot_data) {
//            this.api_slot_data = api_slot_data;
//        }

        public List<ApiShipData> getApi_ship_data() {
            return api_ship_data;
        }

        public void setApi_ship_data(List<ApiShipData> api_ship_data) {
            this.api_ship_data = api_ship_data;
        }

        public List<ApiDeckDataBean> getApi_deck_data() {
            return api_deck_data;
        }

        public void setApi_deck_data(List<ApiDeckDataBean> api_deck_data) {
            this.api_deck_data = api_deck_data;
        }

//        public static class ApiSlotDataBean {
//            /**
//             * api_slottype1 : [7]
//             * api_slottype2 : -1
//             * api_slottype3 : -1
//             * api_slottype4 : -1
//             * api_slottype5 : -1
//             * api_slottype6 : -1
//             * api_slottype7 : -1
//             * api_slottype8 : -1
//             * api_slottype9 : -1
//             * api_slottype10 : -1
//             * api_slottype11 : -1
//             * api_slottype12 : -1
//             * api_slottype13 : -1
//             * api_slottype14 : -1
//             * api_slottype15 : -1
//             * api_slottype16 : -1
//             * api_slottype17 : -1
//             * api_slottype18 : -1
//             * api_slottype19 : -1
//             * api_slottype20 : -1
//             * api_slottype21 : -1
//             * api_slottype22 : -1
//             * api_slottype23 : [1,2]
//             * api_slottype24 : -1
//             * api_slottype25 : -1
//             * api_slottype26 : -1
//             * api_slottype27 : -1
//             * api_slottype28 : -1
//             * api_slottype29 : -1
//             * api_slottype30 : -1
//             * api_slottype31 : -1
//             * api_slottype32 : -1
//             * api_slottype33 : -1
//             * api_slottype34 : -1
//             * api_slottype35 : -1
//             * api_slottype36 : -1
//             * api_slottype37 : -1
//             * api_slottype38 : -1
//             * api_slottype39 : -1
//             * api_slottype40 : -1
//             * api_slottype41 : -1
//             * api_slottype42 : -1
//             * api_slottype43 : -1
//             * api_slottype44 : -1
//             * api_slottype45 : -1
//             * api_slottype46 : -1
//             * api_slottype47 : -1
//             * api_slottype48 : -1
//             * api_slottype56 : -1
//             * api_slottype57 : -1
//             * api_slottype58 : -1
//             * api_slottype59 : -1
//             */
//
//            private int api_slottype2;
//            private int api_slottype3;
//            private int api_slottype4;
//            private int api_slottype5;
//            private int api_slottype6;
//            private int api_slottype7;
//            private int api_slottype8;
//            private int api_slottype9;
//            private int api_slottype10;
//            private int api_slottype11;
//            private int api_slottype12;
//            private int api_slottype13;
//            private int api_slottype14;
//            private int api_slottype15;
//            private int api_slottype16;
//            private int api_slottype17;
//            private int api_slottype18;
//            private int api_slottype19;
//            private int api_slottype20;
//            private int api_slottype21;
//            private int api_slottype22;
//            private int api_slottype24;
//            private int api_slottype25;
//            private int api_slottype26;
//            private int api_slottype27;
//            private int api_slottype28;
//            private int api_slottype29;
//            private int api_slottype30;
//            private int api_slottype31;
//            private int api_slottype32;
//            private int api_slottype33;
//            private int api_slottype34;
//            private int api_slottype35;
//            private int api_slottype36;
//            private int api_slottype37;
//            private int api_slottype38;
//            private int api_slottype39;
//            private int api_slottype40;
//            private int api_slottype41;
//            private int api_slottype42;
//            private int api_slottype43;
//            private int api_slottype44;
//            private int api_slottype45;
//            private int api_slottype46;
//            private int api_slottype47;
//            private int api_slottype48;
//            private int api_slottype56;
//            private int api_slottype57;
//            private int api_slottype58;
//            private int api_slottype59;
//            private List<Integer> api_slottype1;
//            private List<Integer> api_slottype23;
//
//            public int getApi_slottype2() {
//                return api_slottype2;
//            }
//
//            public void setApi_slottype2(int api_slottype2) {
//                this.api_slottype2 = api_slottype2;
//            }
//
//            public int getApi_slottype3() {
//                return api_slottype3;
//            }
//
//            public void setApi_slottype3(int api_slottype3) {
//                this.api_slottype3 = api_slottype3;
//            }
//
//            public int getApi_slottype4() {
//                return api_slottype4;
//            }
//
//            public void setApi_slottype4(int api_slottype4) {
//                this.api_slottype4 = api_slottype4;
//            }
//
//            public int getApi_slottype5() {
//                return api_slottype5;
//            }
//
//            public void setApi_slottype5(int api_slottype5) {
//                this.api_slottype5 = api_slottype5;
//            }
//
//            public int getApi_slottype6() {
//                return api_slottype6;
//            }
//
//            public void setApi_slottype6(int api_slottype6) {
//                this.api_slottype6 = api_slottype6;
//            }
//
//            public int getApi_slottype7() {
//                return api_slottype7;
//            }
//
//            public void setApi_slottype7(int api_slottype7) {
//                this.api_slottype7 = api_slottype7;
//            }
//
//            public int getApi_slottype8() {
//                return api_slottype8;
//            }
//
//            public void setApi_slottype8(int api_slottype8) {
//                this.api_slottype8 = api_slottype8;
//            }
//
//            public int getApi_slottype9() {
//                return api_slottype9;
//            }
//
//            public void setApi_slottype9(int api_slottype9) {
//                this.api_slottype9 = api_slottype9;
//            }
//
//            public int getApi_slottype10() {
//                return api_slottype10;
//            }
//
//            public void setApi_slottype10(int api_slottype10) {
//                this.api_slottype10 = api_slottype10;
//            }
//
//            public int getApi_slottype11() {
//                return api_slottype11;
//            }
//
//            public void setApi_slottype11(int api_slottype11) {
//                this.api_slottype11 = api_slottype11;
//            }
//
//            public int getApi_slottype12() {
//                return api_slottype12;
//            }
//
//            public void setApi_slottype12(int api_slottype12) {
//                this.api_slottype12 = api_slottype12;
//            }
//
//            public int getApi_slottype13() {
//                return api_slottype13;
//            }
//
//            public void setApi_slottype13(int api_slottype13) {
//                this.api_slottype13 = api_slottype13;
//            }
//
//            public int getApi_slottype14() {
//                return api_slottype14;
//            }
//
//            public void setApi_slottype14(int api_slottype14) {
//                this.api_slottype14 = api_slottype14;
//            }
//
//            public int getApi_slottype15() {
//                return api_slottype15;
//            }
//
//            public void setApi_slottype15(int api_slottype15) {
//                this.api_slottype15 = api_slottype15;
//            }
//
//            public int getApi_slottype16() {
//                return api_slottype16;
//            }
//
//            public void setApi_slottype16(int api_slottype16) {
//                this.api_slottype16 = api_slottype16;
//            }
//
//            public int getApi_slottype17() {
//                return api_slottype17;
//            }
//
//            public void setApi_slottype17(int api_slottype17) {
//                this.api_slottype17 = api_slottype17;
//            }
//
//            public int getApi_slottype18() {
//                return api_slottype18;
//            }
//
//            public void setApi_slottype18(int api_slottype18) {
//                this.api_slottype18 = api_slottype18;
//            }
//
//            public int getApi_slottype19() {
//                return api_slottype19;
//            }
//
//            public void setApi_slottype19(int api_slottype19) {
//                this.api_slottype19 = api_slottype19;
//            }
//
//            public int getApi_slottype20() {
//                return api_slottype20;
//            }
//
//            public void setApi_slottype20(int api_slottype20) {
//                this.api_slottype20 = api_slottype20;
//            }
//
//            public int getApi_slottype21() {
//                return api_slottype21;
//            }
//
//            public void setApi_slottype21(int api_slottype21) {
//                this.api_slottype21 = api_slottype21;
//            }
//
//            public int getApi_slottype22() {
//                return api_slottype22;
//            }
//
//            public void setApi_slottype22(int api_slottype22) {
//                this.api_slottype22 = api_slottype22;
//            }
//
//            public int getApi_slottype24() {
//                return api_slottype24;
//            }
//
//            public void setApi_slottype24(int api_slottype24) {
//                this.api_slottype24 = api_slottype24;
//            }
//
//            public int getApi_slottype25() {
//                return api_slottype25;
//            }
//
//            public void setApi_slottype25(int api_slottype25) {
//                this.api_slottype25 = api_slottype25;
//            }
//
//            public int getApi_slottype26() {
//                return api_slottype26;
//            }
//
//            public void setApi_slottype26(int api_slottype26) {
//                this.api_slottype26 = api_slottype26;
//            }
//
//            public int getApi_slottype27() {
//                return api_slottype27;
//            }
//
//            public void setApi_slottype27(int api_slottype27) {
//                this.api_slottype27 = api_slottype27;
//            }
//
//            public int getApi_slottype28() {
//                return api_slottype28;
//            }
//
//            public void setApi_slottype28(int api_slottype28) {
//                this.api_slottype28 = api_slottype28;
//            }
//
//            public int getApi_slottype29() {
//                return api_slottype29;
//            }
//
//            public void setApi_slottype29(int api_slottype29) {
//                this.api_slottype29 = api_slottype29;
//            }
//
//            public int getApi_slottype30() {
//                return api_slottype30;
//            }
//
//            public void setApi_slottype30(int api_slottype30) {
//                this.api_slottype30 = api_slottype30;
//            }
//
//            public int getApi_slottype31() {
//                return api_slottype31;
//            }
//
//            public void setApi_slottype31(int api_slottype31) {
//                this.api_slottype31 = api_slottype31;
//            }
//
//            public int getApi_slottype32() {
//                return api_slottype32;
//            }
//
//            public void setApi_slottype32(int api_slottype32) {
//                this.api_slottype32 = api_slottype32;
//            }
//
//            public int getApi_slottype33() {
//                return api_slottype33;
//            }
//
//            public void setApi_slottype33(int api_slottype33) {
//                this.api_slottype33 = api_slottype33;
//            }
//
//            public int getApi_slottype34() {
//                return api_slottype34;
//            }
//
//            public void setApi_slottype34(int api_slottype34) {
//                this.api_slottype34 = api_slottype34;
//            }
//
//            public int getApi_slottype35() {
//                return api_slottype35;
//            }
//
//            public void setApi_slottype35(int api_slottype35) {
//                this.api_slottype35 = api_slottype35;
//            }
//
//            public int getApi_slottype36() {
//                return api_slottype36;
//            }
//
//            public void setApi_slottype36(int api_slottype36) {
//                this.api_slottype36 = api_slottype36;
//            }
//
//            public int getApi_slottype37() {
//                return api_slottype37;
//            }
//
//            public void setApi_slottype37(int api_slottype37) {
//                this.api_slottype37 = api_slottype37;
//            }
//
//            public int getApi_slottype38() {
//                return api_slottype38;
//            }
//
//            public void setApi_slottype38(int api_slottype38) {
//                this.api_slottype38 = api_slottype38;
//            }
//
//            public int getApi_slottype39() {
//                return api_slottype39;
//            }
//
//            public void setApi_slottype39(int api_slottype39) {
//                this.api_slottype39 = api_slottype39;
//            }
//
//            public int getApi_slottype40() {
//                return api_slottype40;
//            }
//
//            public void setApi_slottype40(int api_slottype40) {
//                this.api_slottype40 = api_slottype40;
//            }
//
//            public int getApi_slottype41() {
//                return api_slottype41;
//            }
//
//            public void setApi_slottype41(int api_slottype41) {
//                this.api_slottype41 = api_slottype41;
//            }
//
//            public int getApi_slottype42() {
//                return api_slottype42;
//            }
//
//            public void setApi_slottype42(int api_slottype42) {
//                this.api_slottype42 = api_slottype42;
//            }
//
//            public int getApi_slottype43() {
//                return api_slottype43;
//            }
//
//            public void setApi_slottype43(int api_slottype43) {
//                this.api_slottype43 = api_slottype43;
//            }
//
//            public int getApi_slottype44() {
//                return api_slottype44;
//            }
//
//            public void setApi_slottype44(int api_slottype44) {
//                this.api_slottype44 = api_slottype44;
//            }
//
//            public int getApi_slottype45() {
//                return api_slottype45;
//            }
//
//            public void setApi_slottype45(int api_slottype45) {
//                this.api_slottype45 = api_slottype45;
//            }
//
//            public int getApi_slottype46() {
//                return api_slottype46;
//            }
//
//            public void setApi_slottype46(int api_slottype46) {
//                this.api_slottype46 = api_slottype46;
//            }
//
//            public int getApi_slottype47() {
//                return api_slottype47;
//            }
//
//            public void setApi_slottype47(int api_slottype47) {
//                this.api_slottype47 = api_slottype47;
//            }
//
//            public int getApi_slottype48() {
//                return api_slottype48;
//            }
//
//            public void setApi_slottype48(int api_slottype48) {
//                this.api_slottype48 = api_slottype48;
//            }
//
//            public int getApi_slottype56() {
//                return api_slottype56;
//            }
//
//            public void setApi_slottype56(int api_slottype56) {
//                this.api_slottype56 = api_slottype56;
//            }
//
//            public int getApi_slottype57() {
//                return api_slottype57;
//            }
//
//            public void setApi_slottype57(int api_slottype57) {
//                this.api_slottype57 = api_slottype57;
//            }
//
//            public int getApi_slottype58() {
//                return api_slottype58;
//            }
//
//            public void setApi_slottype58(int api_slottype58) {
//                this.api_slottype58 = api_slottype58;
//            }
//
//            public int getApi_slottype59() {
//                return api_slottype59;
//            }
//
//            public void setApi_slottype59(int api_slottype59) {
//                this.api_slottype59 = api_slottype59;
//            }
//
//            public List<Integer> getApi_slottype1() {
//                return api_slottype1;
//            }
//
//            public void setApi_slottype1(List<Integer> api_slottype1) {
//                this.api_slottype1 = api_slottype1;
//            }
//
//            public List<Integer> getApi_slottype23() {
//                return api_slottype23;
//            }
//
//            public void setApi_slottype23(List<Integer> api_slottype23) {
//                this.api_slottype23 = api_slottype23;
//            }
//        }


        public static class ApiDeckDataBean {
            /**
             * api_member_id : 11141519
             * api_id : 1
             * api_name : 第1艦隊
             * api_name_id :
             * api_mission : [0,0,0,0]
             * api_flagship : 0
             * api_ship : [6,4,1,2,8,5]
             */

            private int api_member_id;
            private int api_id;
            private String api_name;
            private String api_name_id;
            private String api_flagship;
            private List<Integer> api_mission;
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

            public List<Integer> getApi_mission() {
                return api_mission;
            }

            public void setApi_mission(List<Integer> api_mission) {
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
