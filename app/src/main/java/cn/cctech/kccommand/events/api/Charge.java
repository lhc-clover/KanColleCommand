package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class Charge extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_ship":[{"api_id":4,"api_fuel":15,"api_bull":15,"api_onslot":[0,0,0,0,0]},{"api_id":1,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":2,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":5,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":6,"api_fuel":15,"api_bull":15,"api_onslot":[0,0,0,0,0]},{"api_id":8,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]}],"api_material":[1482,1422,1500,1500],"api_use_bou":0}
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
         * api_ship : [{"api_id":4,"api_fuel":15,"api_bull":15,"api_onslot":[0,0,0,0,0]},{"api_id":1,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":2,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":5,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]},{"api_id":6,"api_fuel":15,"api_bull":15,"api_onslot":[0,0,0,0,0]},{"api_id":8,"api_fuel":15,"api_bull":20,"api_onslot":[0,0,0,0,0]}]
         * api_material : [1482,1422,1500,1500]
         * api_use_bou : 0
         */

        private int api_use_bou;
        private List<ApiShipBean> api_ship;
        private List<Integer> api_material;

        public int getApi_use_bou() {
            return api_use_bou;
        }

        public void setApi_use_bou(int api_use_bou) {
            this.api_use_bou = api_use_bou;
        }

        public List<ApiShipBean> getApi_ship() {
            return api_ship;
        }

        public void setApi_ship(List<ApiShipBean> api_ship) {
            this.api_ship = api_ship;
        }

        public List<Integer> getApi_material() {
            return api_material;
        }

        public void setApi_material(List<Integer> api_material) {
            this.api_material = api_material;
        }

        public static class ApiShipBean {
            /**
             * api_id : 4
             * api_fuel : 15
             * api_bull : 15
             * api_onslot : [0,0,0,0,0]
             */

            private int api_id;
            private int api_fuel;
            private int api_bull;
            private List<Integer> api_onslot;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
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

            public List<Integer> getApi_onslot() {
                return api_onslot;
            }

            public void setApi_onslot(List<Integer> api_onslot) {
                this.api_onslot = api_onslot;
            }
        }
    }
}
