package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class BattleNightSp extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_deck_id":1,"api_formation":[1,1,4],"api_f_nowhps":[37,92,59,58,92,26],"api_f_maxhps":[37,92,59,58,92,32],"api_fParam":[[60,54,110,54],[105,0,94,90],[77,82,82,79],[77,83,83,79],[102,0,90,92],[59,89,59,59]],"api_ship_ke":[1555,1527,1527,1521,1521,1552],"api_ship_lv":[1,1,1,1,1,1],"api_e_nowhps":[57,76,76,50,50,43],"api_e_maxhps":[57,76,76,50,50,43],"api_eSlot":[[506,525,542,543,-1],[505,506,515,525,-1],[505,506,515,525,-1],[506,514,514,-1,-1],[506,514,514,-1,-1],[502,515,542,-1,-1]],"api_eParam":[[48,80,30,39],[68,48,40,70],[68,48,40,70],[35,72,20,34],[35,72,20,34],[33,60,24,24]],"api_n_support_flag":2,"api_n_support_info":{"api_support_airatack":null,"api_support_hourai":{"api_deck_id":4,"api_ship_id":[3595,4783,464,31,700,9],"api_undressing_flag":[0,0,0,0,0,0],"api_cl_list":[0,0,2,1,2,0,0],"api_damage":[0,0,8,67,142,0,0]}},"api_touch_plane":[-1,-1],"api_flare_pos":[-1,-1],"api_hougeki":{"api_at_eflag":[0,0,1,0,1,0,0],"api_at_list":[0,1,1,2,2,3,5],"api_n_mother_list":[0,0,0,0,0,0,0],"api_df_list":[[0,0],[5,5],[4,4],[5,5],[3],[5,5],[1,1]],"api_si_list":[["122","122"],["117","9"],[505,515],["123","123"],[505],["50","50"],["147","147"]],"api_cl_list":[[1,1],[1,1],[1,1],[1,1],[2],[1,1],[1,1]],"api_sp_list":[1,1,2,1,0,1,1],"api_damage":[[95,0],[5,3],[62,22],[3,3],[38],[131,0],[127,95]]}}
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
         * api_formation : [1,1,4]
         * api_f_nowhps : [37,92,59,58,92,26]
         * api_f_maxhps : [37,92,59,58,92,32]
         * api_fParam : [[60,54,110,54],[105,0,94,90],[77,82,82,79],[77,83,83,79],[102,0,90,92],[59,89,59,59]]
         * api_ship_ke : [1555,1527,1527,1521,1521,1552]
         * api_ship_lv : [1,1,1,1,1,1]
         * api_e_nowhps : [57,76,76,50,50,43]
         * api_e_maxhps : [57,76,76,50,50,43]
         * api_eSlot : [[506,525,542,543,-1],[505,506,515,525,-1],[505,506,515,525,-1],[506,514,514,-1,-1],[506,514,514,-1,-1],[502,515,542,-1,-1]]
         * api_eParam : [[48,80,30,39],[68,48,40,70],[68,48,40,70],[35,72,20,34],[35,72,20,34],[33,60,24,24]]
         * api_n_support_flag : 2
         * api_n_support_info : {"api_support_airatack":null,"api_support_hourai":{"api_deck_id":4,"api_ship_id":[3595,4783,464,31,700,9],"api_undressing_flag":[0,0,0,0,0,0],"api_cl_list":[0,0,2,1,2,0,0],"api_damage":[0,0,8,67,142,0,0]}}
         * api_touch_plane : [-1,-1]
         * api_flare_pos : [-1,-1]
         * api_hougeki : {"api_at_eflag":[0,0,1,0,1,0,0],"api_at_list":[0,1,1,2,2,3,5],"api_n_mother_list":[0,0,0,0,0,0,0],"api_df_list":[[0,0],[5,5],[4,4],[5,5],[3],[5,5],[1,1]],"api_si_list":[["122","122"],["117","9"],[505,515],["123","123"],[505],["50","50"],["147","147"]],"api_cl_list":[[1,1],[1,1],[1,1],[1,1],[2],[1,1],[1,1]],"api_sp_list":[1,1,2,1,0,1,1],"api_damage":[[95,0],[5,3],[62,22],[3,3],[38],[131,0],[127,95]]}
         */

        private String api_deck_id;
        private String api_n_support_flag;
        private ApiNSupportInfoBean api_n_support_info;
        private ApiHougekiBean api_hougeki;
        private List<Integer> api_formation;
        private List<Integer> api_f_nowhps;
        private List<Integer> api_f_maxhps;
        private List<List<Integer>> api_fParam;
        private List<Integer> api_ship_ke;
        private List<Integer> api_ship_lv;
        private List<Integer> api_e_nowhps;
        private List<Integer> api_e_maxhps;
        private List<List<Integer>> api_eSlot;
        private List<List<Integer>> api_eParam;
        private List<Integer> api_touch_plane;
        private List<Integer> api_flare_pos;

        public String getApi_deck_id() {
            return api_deck_id;
        }

        public void setApi_deck_id(String api_deck_id) {
            this.api_deck_id = api_deck_id;
        }

        public String getApi_n_support_flag() {
            return api_n_support_flag;
        }

        public void setApi_n_support_flag(String api_n_support_flag) {
            this.api_n_support_flag = api_n_support_flag;
        }

        public ApiNSupportInfoBean getApi_n_support_info() {
            return api_n_support_info;
        }

        public void setApi_n_support_info(ApiNSupportInfoBean api_n_support_info) {
            this.api_n_support_info = api_n_support_info;
        }

        public ApiHougekiBean getApi_hougeki() {
            return api_hougeki;
        }

        public void setApi_hougeki(ApiHougekiBean api_hougeki) {
            this.api_hougeki = api_hougeki;
        }

        public List<Integer> getApi_formation() {
            return api_formation;
        }

        public void setApi_formation(List<Integer> api_formation) {
            this.api_formation = api_formation;
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

        public List<List<Integer>> getApi_fParam() {
            return api_fParam;
        }

        public void setApi_fParam(List<List<Integer>> api_fParam) {
            this.api_fParam = api_fParam;
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

        public List<List<Integer>> getApi_eSlot() {
            return api_eSlot;
        }

        public void setApi_eSlot(List<List<Integer>> api_eSlot) {
            this.api_eSlot = api_eSlot;
        }

        public List<List<Integer>> getApi_eParam() {
            return api_eParam;
        }

        public void setApi_eParam(List<List<Integer>> api_eParam) {
            this.api_eParam = api_eParam;
        }

        public List<Integer> getApi_touch_plane() {
            return api_touch_plane;
        }

        public void setApi_touch_plane(List<Integer> api_touch_plane) {
            this.api_touch_plane = api_touch_plane;
        }

        public List<Integer> getApi_flare_pos() {
            return api_flare_pos;
        }

        public void setApi_flare_pos(List<Integer> api_flare_pos) {
            this.api_flare_pos = api_flare_pos;
        }

        public static class ApiNSupportInfoBean {
            /**
             * api_support_airatack : null
             * api_support_hourai : {"api_deck_id":4,"api_ship_id":[3595,4783,464,31,700,9],"api_undressing_flag":[0,0,0,0,0,0],"api_cl_list":[0,0,2,1,2,0,0],"api_damage":[0,0,8,67,142,0,0]}
             */

            private Object api_support_airatack;
            private ApiSupportHouraiBean api_support_hourai;

            public Object getApi_support_airatack() {
                return api_support_airatack;
            }

            public void setApi_support_airatack(Object api_support_airatack) {
                this.api_support_airatack = api_support_airatack;
            }

            public ApiSupportHouraiBean getApi_support_hourai() {
                return api_support_hourai;
            }

            public void setApi_support_hourai(ApiSupportHouraiBean api_support_hourai) {
                this.api_support_hourai = api_support_hourai;
            }

            public static class ApiSupportHouraiBean {
                /**
                 * api_deck_id : 4
                 * api_ship_id : [3595,4783,464,31,700,9]
                 * api_undressing_flag : [0,0,0,0,0,0]
                 * api_cl_list : [0,0,2,1,2,0,0]
                 * api_damage : [0,0,8,67,142,0,0]
                 */

                private int api_deck_id;
                private List<Object> api_ship_id;
                private List<Object> api_undressing_flag;
                private List<Object> api_cl_list;
                private List<Double> api_damage;

                public int getApi_deck_id() {
                    return api_deck_id;
                }

                public void setApi_deck_id(int api_deck_id) {
                    this.api_deck_id = api_deck_id;
                }

                public List<Object> getApi_ship_id() {
                    return api_ship_id;
                }

                public void setApi_ship_id(List<Object> api_ship_id) {
                    this.api_ship_id = api_ship_id;
                }

                public List<Object> getApi_undressing_flag() {
                    return api_undressing_flag;
                }

                public void setApi_undressing_flag(List<Object> api_undressing_flag) {
                    this.api_undressing_flag = api_undressing_flag;
                }

                public List<Object> getApi_cl_list() {
                    return api_cl_list;
                }

                public void setApi_cl_list(List<Object> api_cl_list) {
                    this.api_cl_list = api_cl_list;
                }

                public List<Double> getApi_damage() {
                    return api_damage;
                }

                public void setApi_damage(List<Double> api_damage) {
                    this.api_damage = api_damage;
                }
            }
        }

        public static class ApiHougekiBean {
            private List<Integer> api_at_eflag;
            private List<Object> api_at_list;
            private List<Object> api_n_mother_list;
            private List<Object> api_df_list;
            private List<Object> api_si_list;
            private List<Object> api_cl_list;
            private List<Object> api_sp_list;
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

            public List<Object> getApi_n_mother_list() {
                return api_n_mother_list;
            }

            public void setApi_n_mother_list(List<Object> api_n_mother_list) {
                this.api_n_mother_list = api_n_mother_list;
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

            public List<Object> getApi_sp_list() {
                return api_sp_list;
            }

            public void setApi_sp_list(List<Object> api_sp_list) {
                this.api_sp_list = api_sp_list;
            }

            public List<Object> getApi_damage() {
                return api_damage;
            }

            public void setApi_damage(List<Object> api_damage) {
                this.api_damage = api_damage;
            }
        }
    }
}
