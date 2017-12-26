package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class BattleNight extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_deck_id":"1","api_nowhps":[-1,22,25,13,15,14,15,52,0,0,0,-1,-1],"api_ship_ke":[-1,1509,1506,1502,1502,-1,-1],"api_ship_lv":[-1,1,1,1,1,-1,-1],"api_maxhps":[-1,26,25,13,15,15,15,58,36,22,22,-1,-1],"api_eSlot":[[505,513,525,-1,-1],[506,525,-1,-1,-1],[502,-1,-1,-1,-1],[502,-1,-1,-1,-1],[-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1]],"api_eKyouka":[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]],"api_fParam":[[18,30,16,13],[14,24,13,10],[15,24,12,10],[11,34,19,8],[13,34,17,7],[14,34,18,7]],"api_eParam":[[32,32,16,28],[16,28,12,18],[7,16,7,6],[7,16,7,6]],"api_touch_plane":[-1,-1],"api_flare_pos":[-1,-1],"api_hougeki":{"api_at_list":[-1,1],"api_n_mother_list":[-1,0],"api_df_list":[-1,[7,7]],"api_si_list":[-1,["4","2"]],"api_cl_list":[-1,[1,2]],"api_sp_list":[-1,1],"api_damage":[-1,[6,69]]}}
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
         * api_nowhps : [-1,22,25,13,15,14,15,52,0,0,0,-1,-1]
         * api_ship_ke : [-1,1509,1506,1502,1502,-1,-1]
         * api_ship_lv : [-1,1,1,1,1,-1,-1]
         * api_maxhps : [-1,26,25,13,15,15,15,58,36,22,22,-1,-1]
         * api_eSlot : [[505,513,525,-1,-1],[506,525,-1,-1,-1],[502,-1,-1,-1,-1],[502,-1,-1,-1,-1],[-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1]]
         * api_eKyouka : [[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
         * api_fParam : [[18,30,16,13],[14,24,13,10],[15,24,12,10],[11,34,19,8],[13,34,17,7],[14,34,18,7]]
         * api_eParam : [[32,32,16,28],[16,28,12,18],[7,16,7,6],[7,16,7,6]]
         * api_touch_plane : [-1,-1]
         * api_flare_pos : [-1,-1]
         * api_hougeki : {"api_at_list":[-1,1],"api_n_mother_list":[-1,0],"api_df_list":[-1,[7,7]],"api_si_list":[-1,["4","2"]],"api_cl_list":[-1,[1,2]],"api_sp_list":[-1,1],"api_damage":[-1,[6,69]]}
         */

        private String api_deck_id;
        private ApiHougekiBean api_hougeki;
        private List<Integer> api_f_nowhps;
        private List<Integer> api_f_maxhps;
        private List<Integer> api_ship_ke;
        private List<Integer> api_ship_lv;
        private List<Integer> api_e_nowhps;
        private List<Integer> api_e_maxhps;
        private List<List<Integer>> api_eSlot;
        private List<List<Integer>> api_eKyouka;
        private List<List<Integer>> api_fParam;
        private List<List<Integer>> api_eParam;
        private List<Integer> api_touch_plane;
        private List<Integer> api_flare_pos;

        public String getApi_deck_id() {
            return api_deck_id;
        }

        public void setApi_deck_id(String api_deck_id) {
            this.api_deck_id = api_deck_id;
        }

        public ApiHougekiBean getApi_hougeki() {
            return api_hougeki;
        }

        public void setApi_hougeki(ApiHougekiBean api_hougeki) {
            this.api_hougeki = api_hougeki;
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
