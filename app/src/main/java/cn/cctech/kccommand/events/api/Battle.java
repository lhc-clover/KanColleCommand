package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class Battle extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_deck_id":1,"api_ship_ke":[-1,1509,1506,1502,1502,-1,-1],"api_ship_lv":[-1,1,1,1,1,-1,-1],"api_e_nowhps":[-1,26,25,13,15,15,15,58,36,22,22,-1,-1],"api_e_maxhps":[-1,26,25,13,15,15,15,58,36,22,22,-1,-1],"api_midnight_flag":1,"api_eSlot":[[505,513,525,-1,-1],[506,525,-1,-1,-1],[502,-1,-1,-1,-1],[502,-1,-1,-1,-1],[-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1]],"api_eKyouka":[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]],"api_fParam":[[18,30,16,13],[14,24,13,10],[15,24,12,10],[11,34,19,8],[13,34,17,7],[14,34,18,7]],"api_eParam":[[32,32,16,28],[16,28,12,18],[7,16,7,6],[7,16,7,6],[0,0,0,0],[0,0,0,0]],"api_search":[6,1],"api_formation":[1,2,2],"api_stage_flag":[1,0,0],"api_kouku":{"api_plane_from":[[-1],[-1]],"api_stage1":{"api_f_count":0,"api_f_lostcount":0,"api_e_count":0,"api_e_lostcount":0,"api_disp_seiku":1,"api_touch_plane":[-1,-1]},"api_stage2":null,"api_stage3":null},"api_support_flag":0,"api_support_info":null,"api_opening_taisen_flag":0,"api_opening_taisen":null,"api_opening_flag":0,"api_opening_atack":null,"api_hourai_flag":[1,0,0,1],"api_hougeki1":{"api_at_list":[-1,1,7,2,8,4,9,3,10,6,5],"api_at_type":[-1,0,0,0,0,0,0,0,0,0,0],"api_df_list":[-1,[9],[2],[8],[1],[10],[2],[9],[5],[10],[10]],"api_si_list":[-1,[4],[505],[4],[506],[2],[502],[2],[502],[2],[2]],"api_cl_list":[-1,[1],[0],[0],[1],[1],[0],[2],[1],[0],[1]],"api_damage":[-1,[17],[0],[0],[4],[9.1],[0],[21],[1],[0],[12]]},"api_hougeki2":null,"api_hougeki3":null,"api_raigeki":{"api_frai":[-1,2,2,4,2,2,1],"api_erai":[-1,6,2,0,0,0,0],"api_fdam":[-1,0,0,0,0,0,0],"api_edam":[-1,6,45,0,29,0,0],"api_fydam":[-1,27,0,29,10,8,6],"api_eydam":[-1,0,0,0,0,0,0],"api_fcl":[-1,2,0,2,1,1,1],"api_ecl":[-1,0,0,0,0,0,0]}}
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
         * api_deck_id : 1
         * api_ship_ke : [-1,1509,1506,1502,1502,-1,-1]
         * api_ship_lv : [-1,1,1,1,1,-1,-1]
         * api_e_nowhps : [-1,26,25,13,15,15,15,58,36,22,22,-1,-1]
         * api_e_maxhps : [-1,26,25,13,15,15,15,58,36,22,22,-1,-1]
         * api_midnight_flag : 1
         * api_eSlot : [[505,513,525,-1,-1],[506,525,-1,-1,-1],[502,-1,-1,-1,-1],[502,-1,-1,-1,-1],[-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1]]
         * api_eKyouka : [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
         * api_fParam : [[18,30,16,13],[14,24,13,10],[15,24,12,10],[11,34,19,8],[13,34,17,7],[14,34,18,7]]
         * api_eParam : [[32,32,16,28],[16,28,12,18],[7,16,7,6],[7,16,7,6],[0,0,0,0],[0,0,0,0]]
         * api_search : [6,1]
         * api_formation : [1,2,2]
         * api_stage_flag : [1,0,0]
         * api_kouku : {"api_plane_from":[[-1],[-1]],"api_stage1":{"api_f_count":0,"api_f_lostcount":0,"api_e_count":0,"api_e_lostcount":0,"api_disp_seiku":1,"api_touch_plane":[-1,-1]},"api_stage2":null,"api_stage3":null}
         * api_support_flag : 0
         * api_support_info : null
         * api_opening_taisen_flag : 0
         * api_opening_taisen : null
         * api_opening_flag : 0
         * api_opening_atack : null
         * api_hourai_flag : [1,0,0,1]
         * api_hougeki1 : {"api_at_list":[-1,1,7,2,8,4,9,3,10,6,5],"api_at_type":[-1,0,0,0,0,0,0,0,0,0,0],"api_df_list":[-1,[9],[2],[8],[1],[10],[2],[9],[5],[10],[10]],"api_si_list":[-1,[4],[505],[4],[506],[2],[502],[2],[502],[2],[2]],"api_cl_list":[-1,[1],[0],[0],[1],[1],[0],[2],[1],[0],[1]],"api_damage":[-1,[17],[0],[0],[4],[9.1],[0],[21],[1],[0],[12]]}
         * api_hougeki2 : null
         * api_hougeki3 : null
         * api_raigeki : {"api_frai":[-1,2,2,4,2,2,1],"api_erai":[-1,6,2,0,0,0,0],"api_fdam":[-1,0,0,0,0,0,0],"api_edam":[-1,6,45,0,29,0,0],"api_fydam":[-1,27,0,29,10,8,6],"api_eydam":[-1,0,0,0,0,0,0],"api_fcl":[-1,2,0,2,1,1,1],"api_ecl":[-1,0,0,0,0,0,0]}
         */

        private int api_deck_id;
        private int api_midnight_flag;
        private ApiKoukuBean api_kouku;
        private int api_support_flag;
        private ApiSupportInfoBean api_support_info;
        private int api_opening_taisen_flag;
        private ApiOpeningTaisenBean api_opening_taisen;
        private int api_opening_flag;
        private ApiOpeningAtackBean api_opening_atack;
        private ApiHougekiBean api_hougeki1;
        private ApiHougekiBean api_hougeki2;
        private ApiHougekiBean api_hougeki3;
        private ApiRaigekiBean api_raigeki;
        private List<Integer> api_ship_ke;
        private List<Integer> api_ship_lv;
        private List<Integer> api_e_nowhps;
        private List<Integer> api_e_maxhps;
        private List<Integer> api_f_nowhps;
        private List<Integer> api_f_maxhps;
        private List<List<Integer>> api_eSlot;
        private List<List<Integer>> api_eKyouka;
        private List<List<Integer>> api_fParam;
        private List<List<Integer>> api_eParam;
        private List<Integer> api_search;
        private List<Integer> api_formation;
        private List<Integer> api_stage_flag;
        private List<Integer> api_hourai_flag;
        private ApiAirBaseInjectionBean api_air_base_injection;
        private ApiInjectionKoukuBean api_injection_kouku;
        private List<ApiAirBaseAttackBean> api_air_base_attack;

        public int getApi_deck_id() {
            return api_deck_id;
        }

        public void setApi_deck_id(int api_deck_id) {
            this.api_deck_id = api_deck_id;
        }

        public int getApi_midnight_flag() {
            return api_midnight_flag;
        }

        public void setApi_midnight_flag(int api_midnight_flag) {
            this.api_midnight_flag = api_midnight_flag;
        }

        public ApiKoukuBean getApi_kouku() {
            return api_kouku;
        }

        public void setApi_kouku(ApiKoukuBean api_kouku) {
            this.api_kouku = api_kouku;
        }

        public int getApi_support_flag() {
            return api_support_flag;
        }

        public void setApi_support_flag(int api_support_flag) {
            this.api_support_flag = api_support_flag;
        }

        public ApiSupportInfoBean getApi_support_info() {
            return api_support_info;
        }

        public void setApi_support_info(ApiSupportInfoBean api_support_info) {
            this.api_support_info = api_support_info;
        }

        public int getApi_opening_taisen_flag() {
            return api_opening_taisen_flag;
        }

        public void setApi_opening_taisen_flag(int api_opening_taisen_flag) {
            this.api_opening_taisen_flag = api_opening_taisen_flag;
        }

        public ApiOpeningTaisenBean getApi_opening_taisen() {
            return api_opening_taisen;
        }

        public void setApi_opening_taisen(ApiOpeningTaisenBean api_opening_taisen) {
            this.api_opening_taisen = api_opening_taisen;
        }

        public int getApi_opening_flag() {
            return api_opening_flag;
        }

        public void setApi_opening_flag(int api_opening_flag) {
            this.api_opening_flag = api_opening_flag;
        }

        public ApiOpeningAtackBean getApi_opening_atack() {
            return api_opening_atack;
        }

        public void setApi_opening_atack(ApiOpeningAtackBean api_opening_atack) {
            this.api_opening_atack = api_opening_atack;
        }

        public ApiHougekiBean getApi_hougeki1() {
            return api_hougeki1;
        }

        public void setApi_hougeki1(ApiHougekiBean api_hougeki1) {
            this.api_hougeki1 = api_hougeki1;
        }

        public ApiHougekiBean getApi_hougeki2() {
            return api_hougeki2;
        }

        public void setApi_hougeki2(ApiHougekiBean api_hougeki2) {
            this.api_hougeki2 = api_hougeki2;
        }

        public ApiHougekiBean getApi_hougeki3() {
            return api_hougeki3;
        }

        public void setApi_hougeki3(ApiHougekiBean api_hougeki3) {
            this.api_hougeki3 = api_hougeki3;
        }

        public ApiRaigekiBean getApi_raigeki() {
            return api_raigeki;
        }

        public void setApi_raigeki(ApiRaigekiBean api_raigeki) {
            this.api_raigeki = api_raigeki;
        }

        public List<Integer> getApi_ship_ke() {
            return api_ship_ke;
        }

        public void setApi_ship_ke(List<Integer> api_ship_ke) {
            this.api_ship_ke = api_ship_ke;
        }

        public List<Integer> getApi_ship_lv() {
            return api_ship_lv;
        }

        public void setApi_ship_lv(List<Integer> api_ship_lv) {
            this.api_ship_lv = api_ship_lv;
        }

        public List<Integer> getApi_e_nowhps() {
            return api_e_nowhps;
        }

        public void setApi_e_nowhps(List<Integer> api_e_nowhps) {
            this.api_e_nowhps = api_e_nowhps;
        }

        public List<Integer> getApi_e_maxhps() {
            return api_e_maxhps;
        }

        public void setApi_e_maxhps(List<Integer> api_e_maxhps) {
            this.api_e_maxhps = api_e_maxhps;
        }

        public List<Integer> getApi_f_nowhps() {
            return api_f_nowhps;
        }

        public void setApi_f_nowhps(List<Integer> api_f_nowhps) {
            this.api_f_nowhps = api_f_nowhps;
        }

        public List<Integer> getApi_f_maxhps() {
            return api_f_maxhps;
        }

        public void setApi_f_maxhps(List<Integer> api_f_maxhps) {
            this.api_f_maxhps = api_f_maxhps;
        }

        public List<List<Integer>> getApi_eSlot() {
            return api_eSlot;
        }

        public void setApi_eSlot(List<List<Integer>> api_eSlot) {
            this.api_eSlot = api_eSlot;
        }

        public List<List<Integer>> getApi_eKyouka() {
            return api_eKyouka;
        }

        public void setApi_eKyouka(List<List<Integer>> api_eKyouka) {
            this.api_eKyouka = api_eKyouka;
        }

        public List<List<Integer>> getApi_fParam() {
            return api_fParam;
        }

        public void setApi_fParam(List<List<Integer>> api_fParam) {
            this.api_fParam = api_fParam;
        }

        public List<List<Integer>> getApi_eParam() {
            return api_eParam;
        }

        public void setApi_eParam(List<List<Integer>> api_eParam) {
            this.api_eParam = api_eParam;
        }

        public List<Integer> getApi_search() {
            return api_search;
        }

        public void setApi_search(List<Integer> api_search) {
            this.api_search = api_search;
        }

        public List<Integer> getApi_formation() {
            return api_formation;
        }

        public void setApi_formation(List<Integer> api_formation) {
            this.api_formation = api_formation;
        }

        public List<Integer> getApi_stage_flag() {
            return api_stage_flag;
        }

        public void setApi_stage_flag(List<Integer> api_stage_flag) {
            this.api_stage_flag = api_stage_flag;
        }

        public List<Integer> getApi_hourai_flag() {
            return api_hourai_flag;
        }

        public void setApi_hourai_flag(List<Integer> api_hourai_flag) {
            this.api_hourai_flag = api_hourai_flag;
        }

        public ApiAirBaseInjectionBean getApi_air_base_injection() {
            return api_air_base_injection;
        }

        public void setApi_air_base_injection(ApiAirBaseInjectionBean api_air_base_injection) {
            this.api_air_base_injection = api_air_base_injection;
        }

        public ApiInjectionKoukuBean getApi_injection_kouku() {
            return api_injection_kouku;
        }

        public void setApi_injection_kouku(ApiInjectionKoukuBean api_injection_kouku) {
            this.api_injection_kouku = api_injection_kouku;
        }

        public List<ApiAirBaseAttackBean> getApi_air_base_attack() {
            return api_air_base_attack;
        }

        public void setApi_air_base_attack(List<ApiAirBaseAttackBean> api_air_base_attack) {
            this.api_air_base_attack = api_air_base_attack;
        }

        public static class ApiKoukuBean {
            /**
             * api_plane_from : [[-1],[-1]]
             * api_stage1 : {"api_f_count":0,"api_f_lostcount":0,"api_e_count":0,"api_e_lostcount":0,"api_disp_seiku":1,"api_touch_plane":[-1,-1]}
             * api_stage2 : null
             * api_stage3 : null
             */

            private ApiStage1Bean api_stage1;
            private Object api_stage2;
            private ApiStage3Bean api_stage3;
            private List<List<Integer>> api_plane_from;

            public ApiStage1Bean getApi_stage1() {
                return api_stage1;
            }

            public void setApi_stage1(ApiStage1Bean api_stage1) {
                this.api_stage1 = api_stage1;
            }

            public Object getApi_stage2() {
                return api_stage2;
            }

            public void setApi_stage2(Object api_stage2) {
                this.api_stage2 = api_stage2;
            }

            public ApiStage3Bean getApi_stage3() {
                return api_stage3;
            }

            public void setApi_stage3(ApiStage3Bean api_stage3) {
                this.api_stage3 = api_stage3;
            }

            public List<List<Integer>> getApi_plane_from() {
                return api_plane_from;
            }

            public void setApi_plane_from(List<List<Integer>> api_plane_from) {
                this.api_plane_from = api_plane_from;
            }

            public static class ApiStage1Bean {
                /**
                 * api_f_count : 0
                 * api_f_lostcount : 0
                 * api_e_count : 0
                 * api_e_lostcount : 0
                 * api_disp_seiku : 1
                 * api_touch_plane : [-1,-1]
                 */

                private int api_f_count;
                private int api_f_lostcount;
                private int api_e_count;
                private int api_e_lostcount;
                private int api_disp_seiku;
                private List<Integer> api_touch_plane;

                public int getApi_f_count() {
                    return api_f_count;
                }

                public void setApi_f_count(int api_f_count) {
                    this.api_f_count = api_f_count;
                }

                public int getApi_f_lostcount() {
                    return api_f_lostcount;
                }

                public void setApi_f_lostcount(int api_f_lostcount) {
                    this.api_f_lostcount = api_f_lostcount;
                }

                public int getApi_e_count() {
                    return api_e_count;
                }

                public void setApi_e_count(int api_e_count) {
                    this.api_e_count = api_e_count;
                }

                public int getApi_e_lostcount() {
                    return api_e_lostcount;
                }

                public void setApi_e_lostcount(int api_e_lostcount) {
                    this.api_e_lostcount = api_e_lostcount;
                }

                public int getApi_disp_seiku() {
                    return api_disp_seiku;
                }

                public void setApi_disp_seiku(int api_disp_seiku) {
                    this.api_disp_seiku = api_disp_seiku;
                }

                public List<Integer> getApi_touch_plane() {
                    return api_touch_plane;
                }

                public void setApi_touch_plane(List<Integer> api_touch_plane) {
                    this.api_touch_plane = api_touch_plane;
                }
            }

            public static class ApiStage3Bean {
                private List<Double> api_fdam;
                private List<Double> api_edam;

                public List<Double> getApi_fdam() {
                    return api_fdam;
                }

                public void setApi_fdam(List<Double> api_fdam) {
                    this.api_fdam = api_fdam;
                }

                public List<Double> getApi_edam() {
                    return api_edam;
                }

                public void setApi_edam(List<Double> api_edam) {
                    this.api_edam = api_edam;
                }
            }
        }

        public static class ApiHougekiBean {
            private List<Integer> api_at_eflag;
            private List<Object> api_at_list;
            private List<Object> api_at_type;
            private List<Object> api_df_list;
            private List<Object> api_si_list;
            private List<Object> api_cl_list;
            private List<Object> api_damage;

            public List<Integer> getApi_at_eflag() {
                return api_at_eflag;
            }

            public void setApi_at_eflag(List<Integer> api_at_eflag) {
                this.api_at_eflag = api_at_eflag;
            }

            public List<Object> getApi_at_list() {
                return api_at_list;
            }

            public void setApi_at_list(List<Object> api_at_list) {
                this.api_at_list = api_at_list;
            }

            public List<Object> getApi_at_type() {
                return api_at_type;
            }

            public void setApi_at_type(List<Object> api_at_type) {
                this.api_at_type = api_at_type;
            }

            public List<Object> getApi_df_list() {
                return api_df_list;
            }

            public void setApi_df_list(List<Object> api_df_list) {
                this.api_df_list = api_df_list;
            }

            public List<Object> getApi_si_list() {
                return api_si_list;
            }

            public void setApi_si_list(List<Object> api_si_list) {
                this.api_si_list = api_si_list;
            }

            public List<Object> getApi_cl_list() {
                return api_cl_list;
            }

            public void setApi_cl_list(List<Object> api_cl_list) {
                this.api_cl_list = api_cl_list;
            }

            public List<Object> getApi_damage() {
                return api_damage;
            }

            public void setApi_damage(List<Object> api_damage) {
                this.api_damage = api_damage;
            }
        }

        public static class ApiRaigekiBean {
            private List<Integer> api_frai;
            private List<Integer> api_erai;
            private List<Double> api_fdam;
            private List<Double> api_edam;
            private List<Double> api_fydam;
            private List<Double> api_eydam;
            private List<Integer> api_fcl;
            private List<Integer> api_ecl;

            public List<Integer> getApi_frai() {
                return api_frai;
            }

            public void setApi_frai(List<Integer> api_frai) {
                this.api_frai = api_frai;
            }

            public List<Integer> getApi_erai() {
                return api_erai;
            }

            public void setApi_erai(List<Integer> api_erai) {
                this.api_erai = api_erai;
            }

            public List<Double> getApi_fdam() {
                return api_fdam;
            }

            public void setApi_fdam(List<Double> api_fdam) {
                this.api_fdam = api_fdam;
            }

            public List<Double> getApi_edam() {
                return api_edam;
            }

            public void setApi_edam(List<Double> api_edam) {
                this.api_edam = api_edam;
            }

            public List<Double> getApi_fydam() {
                return api_fydam;
            }

            public void setApi_fydam(List<Double> api_fydam) {
                this.api_fydam = api_fydam;
            }

            public List<Double> getApi_eydam() {
                return api_eydam;
            }

            public void setApi_eydam(List<Double> api_eydam) {
                this.api_eydam = api_eydam;
            }

            public List<Integer> getApi_fcl() {
                return api_fcl;
            }

            public void setApi_fcl(List<Integer> api_fcl) {
                this.api_fcl = api_fcl;
            }

            public List<Integer> getApi_ecl() {
                return api_ecl;
            }

            public void setApi_ecl(List<Integer> api_ecl) {
                this.api_ecl = api_ecl;
            }
        }

        public static class ApiSupportInfoBean {

            private ApiSupportAirAttack api_support_airattack;
            private ApiSupportHourai api_support_hourai;

            public ApiSupportAirAttack getApi_support_airattack() {
                return api_support_airattack;
            }

            public void setApi_support_airattack(ApiSupportAirAttack api_support_airattack) {
                this.api_support_airattack = api_support_airattack;
            }

            public ApiSupportHourai getApi_support_hourai() {
                return api_support_hourai;
            }

            public void setApi_support_hourai(ApiSupportHourai api_support_hourai) {
                this.api_support_hourai = api_support_hourai;
            }

            public static class ApiSupportAirAttack {

                private ApiStage3Bean api_stage3;

                public ApiStage3Bean getApi_stage3() {
                    return api_stage3;
                }

                public void setApi_stage3(ApiStage3Bean api_stage3) {
                    this.api_stage3 = api_stage3;
                }

                public static class ApiStage3Bean {

                    private List<Double> api_edam;

                    public List<Double> getApi_edam() {
                        return api_edam;
                    }

                    public void setApi_edam(List<Double> api_edam) {
                        this.api_edam = api_edam;
                    }
                }

            }

            public static class ApiSupportHourai {

                private List<Double> api_damage;

                public List<Double> getApi_damage() {
                    return api_damage;
                }

                public void setApi_damage(List<Double> api_damage) {
                    this.api_damage = api_damage;
                }
            }

        }

        public static class ApiOpeningTaisenBean {

            private List<Integer> api_at_eflag;
            private List<Object> api_df_list;
            private List<Object> api_damage;

            public List<Integer> getApi_at_eflag() {
                return api_at_eflag;
            }

            public void setApi_at_eflag(List<Integer> api_at_eflag) {
                this.api_at_eflag = api_at_eflag;
            }

            public List<Object> getApi_df_list() {
                return api_df_list;
            }

            public void setApi_df_list(List<Object> api_df_list) {
                this.api_df_list = api_df_list;
            }

            public List<Object> getApi_damage() {
                return api_damage;
            }

            public void setApi_damage(List<Object> api_damage) {
                this.api_damage = api_damage;
            }
        }

        public static class ApiOpeningAtackBean {

            private List<Double> api_fdam;
            private List<Double> api_edam;

            public List<Double> getApi_fdam() {
                return api_fdam;
            }

            public void setApi_fdam(List<Double> api_fdam) {
                this.api_fdam = api_fdam;
            }

            public List<Double> getApi_edam() {
                return api_edam;
            }

            public void setApi_edam(List<Double> api_edam) {
                this.api_edam = api_edam;
            }
        }

        public static class ApiAirBaseInjectionBean {

            private ApiStage3Bean api_stage3;

            public ApiStage3Bean getApi_stage3() {
                return api_stage3;
            }

            public void setApi_stage3(ApiStage3Bean api_stage3) {
                this.api_stage3 = api_stage3;
            }

            public static class ApiStage3Bean {
                private List<Double> api_fdam;
                private List<Double> api_edam;

                public List<Double> getApi_fdam() {
                    return api_fdam;
                }

                public void setApi_fdam(List<Double> api_fdam) {
                    this.api_fdam = api_fdam;
                }

                public List<Double> getApi_edam() {
                    return api_edam;
                }

                public void setApi_edam(List<Double> api_edam) {
                    this.api_edam = api_edam;
                }
            }
        }

        public static class ApiInjectionKoukuBean {

            private ApiStage3Bean api_stage3;

            public ApiStage3Bean getApi_stage3() {
                return api_stage3;
            }

            public void setApi_stage3(ApiStage3Bean api_stage3) {
                this.api_stage3 = api_stage3;
            }

            public static class ApiStage3Bean {
                private List<Double> api_fdam;
                private List<Double> api_edam;

                public List<Double> getApi_fdam() {
                    return api_fdam;
                }

                public void setApi_fdam(List<Double> api_fdam) {
                    this.api_fdam = api_fdam;
                }

                public List<Double> getApi_edam() {
                    return api_edam;
                }

                public void setApi_edam(List<Double> api_edam) {
                    this.api_edam = api_edam;
                }
            }
        }

        public static class ApiAirBaseAttackBean {

            private ApiStage3Bean api_stage3;

            public ApiStage3Bean getApi_stage3() {
                return api_stage3;
            }

            public void setApi_stage3(ApiStage3Bean api_stage3) {
                this.api_stage3 = api_stage3;
            }

            public static class ApiStage3Bean {
                private List<Double> api_fdam;
                private List<Double> api_edam;

                public List<Double> getApi_fdam() {
                    return api_fdam;
                }

                public void setApi_fdam(List<Double> api_fdam) {
                    this.api_fdam = api_fdam;
                }

                public List<Double> getApi_edam() {
                    return api_edam;
                }

                public void setApi_edam(List<Double> api_edam) {
                    this.api_edam = api_edam;
                }
            }
        }

    }
}
