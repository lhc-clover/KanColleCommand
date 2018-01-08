package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class CreateItem extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_create_flag":1,"api_shizai_flag":1,"api_slot_item":{"api_id":11008,"api_slotitem_id":1},"api_material":[58842,61015,108727,23787,316,237,1704,7],"api_type3":1,"api_unsetslot":[11008,10972,11002,10977,10980,10969,9179,4829,1683,6973,5495,4919,4533,5535,5983,9304,9413]}
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
         * api_create_flag : 1
         * api_shizai_flag : 1
         * api_slot_item : {"api_id":11008,"api_slotitem_id":1}
         * api_material : [58842,61015,108727,23787,316,237,1704,7]
         * api_type3 : 1
         * api_unsetslot : [11008,10972,11002,10977,10980,10969,9179,4829,1683,6973,5495,4919,4533,5535,5983,9304,9413]
         */

        private int api_create_flag;
        private int api_shizai_flag;
        private ApiSlotItemBean api_slot_item;
        private int api_type3;
        private List<Integer> api_material;
        private List<Integer> api_unsetslot;

        public int getApi_create_flag() {
            return api_create_flag;
        }

        public void setApi_create_flag(int api_create_flag) {
            this.api_create_flag = api_create_flag;
        }

        public int getApi_shizai_flag() {
            return api_shizai_flag;
        }

        public void setApi_shizai_flag(int api_shizai_flag) {
            this.api_shizai_flag = api_shizai_flag;
        }

        public ApiSlotItemBean getApi_slot_item() {
            return api_slot_item;
        }

        public void setApi_slot_item(ApiSlotItemBean api_slot_item) {
            this.api_slot_item = api_slot_item;
        }

        public int getApi_type3() {
            return api_type3;
        }

        public void setApi_type3(int api_type3) {
            this.api_type3 = api_type3;
        }

        public List<Integer> getApi_material() {
            return api_material;
        }

        public void setApi_material(List<Integer> api_material) {
            this.api_material = api_material;
        }

        public List<Integer> getApi_unsetslot() {
            return api_unsetslot;
        }

        public void setApi_unsetslot(List<Integer> api_unsetslot) {
            this.api_unsetslot = api_unsetslot;
        }

        public static class ApiSlotItemBean {
            /**
             * api_id : 11008
             * api_slotitem_id : 1
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
