package cn.cctech.kccommand.events.api;

import java.util.List;
import java.util.Map;

import cn.cctech.kccommand.events.JsonEvent;

public class RequireInfo extends JsonEvent {

    private int api_result;
    private String api_result_msg;
    private ApiDataEntity api_data;

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

    public ApiDataEntity getApi_data() {
        return api_data;
    }

    public void setApi_data(ApiDataEntity api_data) {
        this.api_data = api_data;
    }

    public static class ApiDataEntity {
        private ApiBasicEntity api_basic;
        private Map<String, Object> api_unsetslot;
        private List<ApiSlotItemEntity> api_slot_item;
        private List<ApiKdockEntity> api_kdock;
        private List<ApiFurnitureEntity> api_furniture;

        public ApiBasicEntity getApi_basic() {
            return api_basic;
        }

        public void setApi_basic(ApiBasicEntity api_basic) {
            this.api_basic = api_basic;
        }

        public Map<String, Object> getApi_unsetslot() {
            return api_unsetslot;
        }

        public void setApi_unsetslot(Map<String, Object> api_unsetslot) {
            this.api_unsetslot = api_unsetslot;
        }

        public List<ApiSlotItemEntity> getApi_slot_item() {
            return api_slot_item;
        }

        public void setApi_slot_item(List<ApiSlotItemEntity> api_slot_item) {
            this.api_slot_item = api_slot_item;
        }

        public List<ApiKdockEntity> getApi_kdock() {
            return api_kdock;
        }

        public void setApi_kdock(List<ApiKdockEntity> api_kdock) {
            this.api_kdock = api_kdock;
        }

        public List<ApiFurnitureEntity> getApi_furniture() {
            return api_furniture;
        }

        public void setApi_furniture(List<ApiFurnitureEntity> api_furniture) {
            this.api_furniture = api_furniture;
        }

        public static class ApiBasicEntity {
            private int api_member_id;
            private int api_firstflag;

            public int getApi_member_id() {
                return api_member_id;
            }

            public void setApi_member_id(int api_member_id) {
                this.api_member_id = api_member_id;
            }

            public int getApi_firstflag() {
                return api_firstflag;
            }

            public void setApi_firstflag(int api_firstflag) {
                this.api_firstflag = api_firstflag;
            }
        }

        public static class ApiSlotItemEntity {
            private int api_id;
            private int api_slotitem_id;
            private int api_locked;
            private int api_level;
            private int api_alv;

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

            public int getApi_locked() {
                return api_locked;
            }

            public void setApi_locked(int api_locked) {
                this.api_locked = api_locked;
            }

            public int getApi_level() {
                return api_level;
            }

            public void setApi_level(int api_level) {
                this.api_level = api_level;
            }

            public int getApi_alv() {
                return api_alv;
            }

            public void setApi_alv(int api_alv) {
                this.api_alv = api_alv;
            }
        }

        public static class ApiKdockEntity {
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

        public static class ApiFurnitureEntity {
            private int api_id;
            private int api_furniture_type;
            private int api_furniture_no;
            private int api_furniture_id;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_furniture_type() {
                return api_furniture_type;
            }

            public void setApi_furniture_type(int api_furniture_type) {
                this.api_furniture_type = api_furniture_type;
            }

            public int getApi_furniture_no() {
                return api_furniture_no;
            }

            public void setApi_furniture_no(int api_furniture_no) {
                this.api_furniture_no = api_furniture_no;
            }

            public int getApi_furniture_id() {
                return api_furniture_id;
            }

            public void setApi_furniture_id(int api_furniture_id) {
                this.api_furniture_id = api_furniture_id;
            }
        }
    }
}
