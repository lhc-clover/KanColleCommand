package cn.cctech.kccommand.events.api;

import java.util.List;

import cn.cctech.kccommand.events.JsonEvent;

public class ClearItemGet extends JsonEvent {

    /**
     * api_result : 1
     * api_result_msg : 成功
     * api_data : {"api_material":[100,100,100,100],"api_bounus_count":1,"api_bounus":[{"api_type":1,"api_count":2,"api_item":{"api_id":7,"api_name":""}}]}
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
         * api_material : [100,100,100,100]
         * api_bounus_count : 1
         * api_bounus : [{"api_type":1,"api_count":2,"api_item":{"api_id":7,"api_name":""}}]
         */

        private int api_bounus_count;
        private List<Integer> api_material;
        private List<ApiBounusBean> api_bounus;

        public int getApi_bounus_count() {
            return api_bounus_count;
        }

        public void setApi_bounus_count(int api_bounus_count) {
            this.api_bounus_count = api_bounus_count;
        }

        public List<Integer> getApi_material() {
            return api_material;
        }

        public void setApi_material(List<Integer> api_material) {
            this.api_material = api_material;
        }

        public List<ApiBounusBean> getApi_bounus() {
            return api_bounus;
        }

        public void setApi_bounus(List<ApiBounusBean> api_bounus) {
            this.api_bounus = api_bounus;
        }

        public static class ApiBounusBean {
            /**
             * api_type : 1
             * api_count : 2
             * api_item : {"api_id":7,"api_name":""}
             */

            private int api_type;
            private int api_count;
            private ApiItemBean api_item;

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }

            public int getApi_count() {
                return api_count;
            }

            public void setApi_count(int api_count) {
                this.api_count = api_count;
            }

            public ApiItemBean getApi_item() {
                return api_item;
            }

            public void setApi_item(ApiItemBean api_item) {
                this.api_item = api_item;
            }

            public static class ApiItemBean {
                /**
                 * api_id : 7
                 * api_name :
                 */

                private int api_id;
                private String api_name;

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
            }
        }
    }
}
