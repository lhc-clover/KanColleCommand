package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class PracticeNight extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_deck_id":1,"api_formation":[1,1,1],"api_f_nowhps":[7,7,1,1,4,15],"api_f_maxhps":[32,63,15,15,15,63],"api_fParam":[[11,82,17,19],[73,0,38,58],[13,36,22,9],[15,37,17,10],[15,39,20,7],[79,0,50,67]],"api_ship_ke":[151,275,276,278,112,277],"api_ship_lv":[80,55,45,34,73,73],"api_e_nowhps":[75,90,66,74,66,71],"api_e_maxhps":[81,90,90,79,75,77],"api_eSlot":[[8,104,25,35,-1],[8,8,25,30,-1],[8,8,25,39,-1],[17,24,21,21,-1],[21,18,18,54,-1],[57,18,22,12,-1]],"api_eParam":[[96,0,77,89],[99,0,72,98],[99,0,61,98],[17,0,46,54],[39,0,76,72],[49,0,72,79]],"api_touch_plane":[-1,-1],"api_flare_pos":[-1,-1],"api_hougeki":{"api_at_eflag":[1,1,1,0],"api_at_list":[0,1,2,4],"api_n_mother_list":[0,0,0,0],"api_df_list":[[0,0],[3,3],[3,3],[4,4]],"api_si_list":[[8,104],[8,8],[8,8],["2","2"]],"api_cl_list":[[1,1],[1,1],[1,2],[2,1]],"api_sp_list":[1,1,1,1],"api_damage":[[4,0],[0,0],[0,0],[7,7]]}}
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
         * api_formation : [1,1,1]
         * api_f_nowhps : [7,7,1,1,4,15]
         * api_f_maxhps : [32,63,15,15,15,63]
         * api_fParam : [[11,82,17,19],[73,0,38,58],[13,36,22,9],[15,37,17,10],[15,39,20,7],[79,0,50,67]]
         * api_ship_ke : [151,275,276,278,112,277]
         * api_ship_lv : [80,55,45,34,73,73]
         * api_e_nowhps : [75,90,66,74,66,71]
         * api_e_maxhps : [81,90,90,79,75,77]
         * api_eSlot : [[8,104,25,35,-1],[8,8,25,30,-1],[8,8,25,39,-1],[17,24,21,21,-1],[21,18,18,54,-1],[57,18,22,12,-1]]
         * api_eParam : [[96,0,77,89],[99,0,72,98],[99,0,61,98],[17,0,46,54],[39,0,76,72],[49,0,72,79]]
         * api_touch_plane : [-1,-1]
         * api_flare_pos : [-1,-1]
         * api_hougeki : {"api_at_eflag":[1,1,1,0],"api_at_list":[0,1,2,4],"api_n_mother_list":[0,0,0,0],"api_df_list":[[0,0],[3,3],[3,3],[4,4]],"api_si_list":[[8,104],[8,8],[8,8],["2","2"]],"api_cl_list":[[1,1],[1,1],[1,2],[2,1]],"api_sp_list":[1,1,1,1],"api_damage":[[4,0],[0,0],[0,0],[7,7]]}
         */

        private int api_deck_id;
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

        public int getApi_deck_id() {
            return api_deck_id;
        }

        public void setApi_deck_id(int api_deck_id) {
            this.api_deck_id = api_deck_id;
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
