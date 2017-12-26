package cn.cctech.kccommand.events.api;

import java.util.List;
import java.util.Map;

import cn.cctech.kccommand.events.JsonEvent;

public class Start extends JsonEvent {

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
        private ApiMstItemShopEntity api_mst_item_shop;
        private ApiMstConstEntity api_mst_const;
        private List<ApiMstShipEntity> api_mst_ship;
        private List<ApiMstShipgraphEntity> api_mst_shipgraph;
        private List<ApiMstSlotitemEquiptypeEntity> api_mst_slotitem_equiptype;
        private List<Integer> api_mst_equip_exslot;
        private List<ApiMstStypeEntity> api_mst_stype;
        private List<ApiMstSlotitemEntity> api_mst_slotitem;
        private List<ApiMstFurnitureEntity> api_mst_furniture;
        private List<ApiMstFurnituregraphEntity> api_mst_furnituregraph;
        private List<ApiMstUseitemEntity> api_mst_useitem;
        private List<ApiMstPayitemEntity> api_mst_payitem;
        private List<ApiMstMapareaEntity> api_mst_maparea;
        private List<ApiMstMapinfoEntity> api_mst_mapinfo;
        private List<ApiMstMapbgmEntity> api_mst_mapbgm;
        private List<ApiMstMapcellEntity> api_mst_mapcell;
        private List<ApiMstMissionEntity> api_mst_mission;
        private List<ApiMstShipupgradeEntity> api_mst_shipupgrade;
        private List<ApiMstBgmEntity> api_mst_bgm;

        public ApiMstItemShopEntity getApi_mst_item_shop() {
            return api_mst_item_shop;
        }

        public void setApi_mst_item_shop(ApiMstItemShopEntity api_mst_item_shop) {
            this.api_mst_item_shop = api_mst_item_shop;
        }

        public ApiMstConstEntity getApi_mst_const() {
            return api_mst_const;
        }

        public void setApi_mst_const(ApiMstConstEntity api_mst_const) {
            this.api_mst_const = api_mst_const;
        }

        public List<ApiMstShipEntity> getApi_mst_ship() {
            return api_mst_ship;
        }

        public void setApi_mst_ship(List<ApiMstShipEntity> api_mst_ship) {
            this.api_mst_ship = api_mst_ship;
        }

        public List<ApiMstShipgraphEntity> getApi_mst_shipgraph() {
            return api_mst_shipgraph;
        }

        public void setApi_mst_shipgraph(List<ApiMstShipgraphEntity> api_mst_shipgraph) {
            this.api_mst_shipgraph = api_mst_shipgraph;
        }

        public List<ApiMstSlotitemEquiptypeEntity> getApi_mst_slotitem_equiptype() {
            return api_mst_slotitem_equiptype;
        }

        public void setApi_mst_slotitem_equiptype(List<ApiMstSlotitemEquiptypeEntity> api_mst_slotitem_equiptype) {
            this.api_mst_slotitem_equiptype = api_mst_slotitem_equiptype;
        }

        public List<Integer> getApi_mst_equip_exslot() {
            return api_mst_equip_exslot;
        }

        public void setApi_mst_equip_exslot(List<Integer> api_mst_equip_exslot) {
            this.api_mst_equip_exslot = api_mst_equip_exslot;
        }

        public List<ApiMstStypeEntity> getApi_mst_stype() {
            return api_mst_stype;
        }

        public void setApi_mst_stype(List<ApiMstStypeEntity> api_mst_stype) {
            this.api_mst_stype = api_mst_stype;
        }

        public List<ApiMstSlotitemEntity> getApi_mst_slotitem() {
            return api_mst_slotitem;
        }

        public void setApi_mst_slotitem(List<ApiMstSlotitemEntity> api_mst_slotitem) {
            this.api_mst_slotitem = api_mst_slotitem;
        }

        public List<ApiMstFurnitureEntity> getApi_mst_furniture() {
            return api_mst_furniture;
        }

        public void setApi_mst_furniture(List<ApiMstFurnitureEntity> api_mst_furniture) {
            this.api_mst_furniture = api_mst_furniture;
        }

        public List<ApiMstFurnituregraphEntity> getApi_mst_furnituregraph() {
            return api_mst_furnituregraph;
        }

        public void setApi_mst_furnituregraph(List<ApiMstFurnituregraphEntity> api_mst_furnituregraph) {
            this.api_mst_furnituregraph = api_mst_furnituregraph;
        }

        public List<ApiMstUseitemEntity> getApi_mst_useitem() {
            return api_mst_useitem;
        }

        public void setApi_mst_useitem(List<ApiMstUseitemEntity> api_mst_useitem) {
            this.api_mst_useitem = api_mst_useitem;
        }

        public List<ApiMstPayitemEntity> getApi_mst_payitem() {
            return api_mst_payitem;
        }

        public void setApi_mst_payitem(List<ApiMstPayitemEntity> api_mst_payitem) {
            this.api_mst_payitem = api_mst_payitem;
        }

        public List<ApiMstMapareaEntity> getApi_mst_maparea() {
            return api_mst_maparea;
        }

        public void setApi_mst_maparea(List<ApiMstMapareaEntity> api_mst_maparea) {
            this.api_mst_maparea = api_mst_maparea;
        }

        public List<ApiMstMapinfoEntity> getApi_mst_mapinfo() {
            return api_mst_mapinfo;
        }

        public void setApi_mst_mapinfo(List<ApiMstMapinfoEntity> api_mst_mapinfo) {
            this.api_mst_mapinfo = api_mst_mapinfo;
        }

        public List<ApiMstMapbgmEntity> getApi_mst_mapbgm() {
            return api_mst_mapbgm;
        }

        public void setApi_mst_mapbgm(List<ApiMstMapbgmEntity> api_mst_mapbgm) {
            this.api_mst_mapbgm = api_mst_mapbgm;
        }

        public List<ApiMstMapcellEntity> getApi_mst_mapcell() {
            return api_mst_mapcell;
        }

        public void setApi_mst_mapcell(List<ApiMstMapcellEntity> api_mst_mapcell) {
            this.api_mst_mapcell = api_mst_mapcell;
        }

        public List<ApiMstMissionEntity> getApi_mst_mission() {
            return api_mst_mission;
        }

        public void setApi_mst_mission(List<ApiMstMissionEntity> api_mst_mission) {
            this.api_mst_mission = api_mst_mission;
        }

        public List<ApiMstShipupgradeEntity> getApi_mst_shipupgrade() {
            return api_mst_shipupgrade;
        }

        public void setApi_mst_shipupgrade(List<ApiMstShipupgradeEntity> api_mst_shipupgrade) {
            this.api_mst_shipupgrade = api_mst_shipupgrade;
        }

        public List<ApiMstBgmEntity> getApi_mst_bgm() {
            return api_mst_bgm;
        }

        public void setApi_mst_bgm(List<ApiMstBgmEntity> api_mst_bgm) {
            this.api_mst_bgm = api_mst_bgm;
        }

        public static class ApiMstItemShopEntity {
            private List<Integer> api_cabinet_1;
            private List<Integer> api_cabinet_2;

            public List<Integer> getApi_cabinet_1() {
                return api_cabinet_1;
            }

            public void setApi_cabinet_1(List<Integer> api_cabinet_1) {
                this.api_cabinet_1 = api_cabinet_1;
            }

            public List<Integer> getApi_cabinet_2() {
                return api_cabinet_2;
            }

            public void setApi_cabinet_2(List<Integer> api_cabinet_2) {
                this.api_cabinet_2 = api_cabinet_2;
            }
        }

        public static class ApiMstConstEntity {
            private ApiDpflagQuestEntity api_dpflag_quest;
            private ApiParallelQuestMaxEntity api_parallel_quest_max;
            private ApiBokoMaxShipsEntity api_boko_max_ships;

            public ApiDpflagQuestEntity getApi_dpflag_quest() {
                return api_dpflag_quest;
            }

            public void setApi_dpflag_quest(ApiDpflagQuestEntity api_dpflag_quest) {
                this.api_dpflag_quest = api_dpflag_quest;
            }

            public ApiParallelQuestMaxEntity getApi_parallel_quest_max() {
                return api_parallel_quest_max;
            }

            public void setApi_parallel_quest_max(ApiParallelQuestMaxEntity api_parallel_quest_max) {
                this.api_parallel_quest_max = api_parallel_quest_max;
            }

            public ApiBokoMaxShipsEntity getApi_boko_max_ships() {
                return api_boko_max_ships;
            }

            public void setApi_boko_max_ships(ApiBokoMaxShipsEntity api_boko_max_ships) {
                this.api_boko_max_ships = api_boko_max_ships;
            }

            public static class ApiDpflagQuestEntity {
                private String api_string_value;
                private int api_int_value;

                public String getApi_string_value() {
                    return api_string_value;
                }

                public void setApi_string_value(String api_string_value) {
                    this.api_string_value = api_string_value;
                }

                public int getApi_int_value() {
                    return api_int_value;
                }

                public void setApi_int_value(int api_int_value) {
                    this.api_int_value = api_int_value;
                }
            }

            public static class ApiParallelQuestMaxEntity {
                private String api_string_value;
                private int api_int_value;

                public String getApi_string_value() {
                    return api_string_value;
                }

                public void setApi_string_value(String api_string_value) {
                    this.api_string_value = api_string_value;
                }

                public int getApi_int_value() {
                    return api_int_value;
                }

                public void setApi_int_value(int api_int_value) {
                    this.api_int_value = api_int_value;
                }
            }

            public static class ApiBokoMaxShipsEntity {
                private String api_string_value;
                private int api_int_value;

                public String getApi_string_value() {
                    return api_string_value;
                }

                public void setApi_string_value(String api_string_value) {
                    this.api_string_value = api_string_value;
                }

                public int getApi_int_value() {
                    return api_int_value;
                }

                public void setApi_int_value(int api_int_value) {
                    this.api_int_value = api_int_value;
                }
            }
        }

        public static class ApiMstShipEntity {
            private int api_id;
            private int api_sortno;
            private String api_name;
            private String api_yomi;
            private int api_stype;
            private int api_afterlv;
            private String api_aftershipid;
            private int api_soku;
            private int api_leng;
            private int api_slot_num;
            private long api_buildtime;
            private int api_backs;
            private String api_getmes;
            private int api_afterfuel;
            private int api_afterbull;
            private int api_fuel_max;
            private int api_bull_max;
            private int api_voicef;
            private List<Integer> api_taik;
            private List<Integer> api_souk;
            private List<Integer> api_houg;
            private List<Integer> api_raig;
            private List<Integer> api_tyku;
            private List<Integer> api_luck;
            private List<Integer> api_maxeq;
            private List<Integer> api_broken;
            private List<Integer> api_powup;

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

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public String getApi_yomi() {
                return api_yomi;
            }

            public void setApi_yomi(String api_yomi) {
                this.api_yomi = api_yomi;
            }

            public int getApi_stype() {
                return api_stype;
            }

            public void setApi_stype(int api_stype) {
                this.api_stype = api_stype;
            }

            public int getApi_afterlv() {
                return api_afterlv;
            }

            public void setApi_afterlv(int api_afterlv) {
                this.api_afterlv = api_afterlv;
            }

            public String getApi_aftershipid() {
                return api_aftershipid;
            }

            public void setApi_aftershipid(String api_aftershipid) {
                this.api_aftershipid = api_aftershipid;
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

            public int getApi_slot_num() {
                return api_slot_num;
            }

            public void setApi_slot_num(int api_slot_num) {
                this.api_slot_num = api_slot_num;
            }

            public long getApi_buildtime() {
                return api_buildtime;
            }

            public void setApi_buildtime(long api_buildtime) {
                this.api_buildtime = api_buildtime;
            }

            public int getApi_backs() {
                return api_backs;
            }

            public void setApi_backs(int api_backs) {
                this.api_backs = api_backs;
            }

            public String getApi_getmes() {
                return api_getmes;
            }

            public void setApi_getmes(String api_getmes) {
                this.api_getmes = api_getmes;
            }

            public int getApi_afterfuel() {
                return api_afterfuel;
            }

            public void setApi_afterfuel(int api_afterfuel) {
                this.api_afterfuel = api_afterfuel;
            }

            public int getApi_afterbull() {
                return api_afterbull;
            }

            public void setApi_afterbull(int api_afterbull) {
                this.api_afterbull = api_afterbull;
            }

            public int getApi_fuel_max() {
                return api_fuel_max;
            }

            public void setApi_fuel_max(int api_fuel_max) {
                this.api_fuel_max = api_fuel_max;
            }

            public int getApi_bull_max() {
                return api_bull_max;
            }

            public void setApi_bull_max(int api_bull_max) {
                this.api_bull_max = api_bull_max;
            }

            public int getApi_voicef() {
                return api_voicef;
            }

            public void setApi_voicef(int api_voicef) {
                this.api_voicef = api_voicef;
            }

            public List<Integer> getApi_taik() {
                return api_taik;
            }

            public void setApi_taik(List<Integer> api_taik) {
                this.api_taik = api_taik;
            }

            public List<Integer> getApi_souk() {
                return api_souk;
            }

            public void setApi_souk(List<Integer> api_souk) {
                this.api_souk = api_souk;
            }

            public List<Integer> getApi_houg() {
                return api_houg;
            }

            public void setApi_houg(List<Integer> api_houg) {
                this.api_houg = api_houg;
            }

            public List<Integer> getApi_raig() {
                return api_raig;
            }

            public void setApi_raig(List<Integer> api_raig) {
                this.api_raig = api_raig;
            }

            public List<Integer> getApi_tyku() {
                return api_tyku;
            }

            public void setApi_tyku(List<Integer> api_tyku) {
                this.api_tyku = api_tyku;
            }

            public List<Integer> getApi_luck() {
                return api_luck;
            }

            public void setApi_luck(List<Integer> api_luck) {
                this.api_luck = api_luck;
            }

            public List<Integer> getApi_maxeq() {
                return api_maxeq;
            }

            public void setApi_maxeq(List<Integer> api_maxeq) {
                this.api_maxeq = api_maxeq;
            }

            public List<Integer> getApi_broken() {
                return api_broken;
            }

            public void setApi_broken(List<Integer> api_broken) {
                this.api_broken = api_broken;
            }

            public List<Integer> getApi_powup() {
                return api_powup;
            }

            public void setApi_powup(List<Integer> api_powup) {
                this.api_powup = api_powup;
            }
        }

        public static class ApiMstShipgraphEntity {
            private int api_id;
            private int api_sortno;
            private String api_filename;
            private List<String> api_version;
            private List<Integer> api_boko_n;
            private List<Integer> api_boko_d;
            private List<Integer> api_kaisyu_n;
            private List<Integer> api_kaisyu_d;
            private List<Integer> api_kaizo_n;
            private List<Integer> api_kaizo_d;
            private List<Integer> api_map_n;
            private List<Integer> api_map_d;
            private List<Integer> api_ensyuf_n;
            private List<Integer> api_ensyuf_d;
            private List<Integer> api_ensyue_n;
            private List<Integer> api_battle_n;
            private List<Integer> api_battle_d;
            private List<Integer> api_weda;
            private List<Integer> api_wedb;

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

            public String getApi_filename() {
                return api_filename;
            }

            public void setApi_filename(String api_filename) {
                this.api_filename = api_filename;
            }

            public List<String> getApi_version() {
                return api_version;
            }

            public void setApi_version(List<String> api_version) {
                this.api_version = api_version;
            }

            public List<Integer> getApi_boko_n() {
                return api_boko_n;
            }

            public void setApi_boko_n(List<Integer> api_boko_n) {
                this.api_boko_n = api_boko_n;
            }

            public List<Integer> getApi_boko_d() {
                return api_boko_d;
            }

            public void setApi_boko_d(List<Integer> api_boko_d) {
                this.api_boko_d = api_boko_d;
            }

            public List<Integer> getApi_kaisyu_n() {
                return api_kaisyu_n;
            }

            public void setApi_kaisyu_n(List<Integer> api_kaisyu_n) {
                this.api_kaisyu_n = api_kaisyu_n;
            }

            public List<Integer> getApi_kaisyu_d() {
                return api_kaisyu_d;
            }

            public void setApi_kaisyu_d(List<Integer> api_kaisyu_d) {
                this.api_kaisyu_d = api_kaisyu_d;
            }

            public List<Integer> getApi_kaizo_n() {
                return api_kaizo_n;
            }

            public void setApi_kaizo_n(List<Integer> api_kaizo_n) {
                this.api_kaizo_n = api_kaizo_n;
            }

            public List<Integer> getApi_kaizo_d() {
                return api_kaizo_d;
            }

            public void setApi_kaizo_d(List<Integer> api_kaizo_d) {
                this.api_kaizo_d = api_kaizo_d;
            }

            public List<Integer> getApi_map_n() {
                return api_map_n;
            }

            public void setApi_map_n(List<Integer> api_map_n) {
                this.api_map_n = api_map_n;
            }

            public List<Integer> getApi_map_d() {
                return api_map_d;
            }

            public void setApi_map_d(List<Integer> api_map_d) {
                this.api_map_d = api_map_d;
            }

            public List<Integer> getApi_ensyuf_n() {
                return api_ensyuf_n;
            }

            public void setApi_ensyuf_n(List<Integer> api_ensyuf_n) {
                this.api_ensyuf_n = api_ensyuf_n;
            }

            public List<Integer> getApi_ensyuf_d() {
                return api_ensyuf_d;
            }

            public void setApi_ensyuf_d(List<Integer> api_ensyuf_d) {
                this.api_ensyuf_d = api_ensyuf_d;
            }

            public List<Integer> getApi_ensyue_n() {
                return api_ensyue_n;
            }

            public void setApi_ensyue_n(List<Integer> api_ensyue_n) {
                this.api_ensyue_n = api_ensyue_n;
            }

            public List<Integer> getApi_battle_n() {
                return api_battle_n;
            }

            public void setApi_battle_n(List<Integer> api_battle_n) {
                this.api_battle_n = api_battle_n;
            }

            public List<Integer> getApi_battle_d() {
                return api_battle_d;
            }

            public void setApi_battle_d(List<Integer> api_battle_d) {
                this.api_battle_d = api_battle_d;
            }

            public List<Integer> getApi_weda() {
                return api_weda;
            }

            public void setApi_weda(List<Integer> api_weda) {
                this.api_weda = api_weda;
            }

            public List<Integer> getApi_wedb() {
                return api_wedb;
            }

            public void setApi_wedb(List<Integer> api_wedb) {
                this.api_wedb = api_wedb;
            }
        }

        public static class ApiMstSlotitemEquiptypeEntity {
            private int api_id;
            private String api_name;
            private int api_show_flg;

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

            public int getApi_show_flg() {
                return api_show_flg;
            }

            public void setApi_show_flg(int api_show_flg) {
                this.api_show_flg = api_show_flg;
            }
        }

        public static class ApiMstStypeEntity {
            private int api_id;
            private int api_sortno;
            private String api_name;
            private int api_scnt;
            private int api_kcnt;
            private Map<String, Integer> api_equip_type;

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

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public int getApi_scnt() {
                return api_scnt;
            }

            public void setApi_scnt(int api_scnt) {
                this.api_scnt = api_scnt;
            }

            public int getApi_kcnt() {
                return api_kcnt;
            }

            public void setApi_kcnt(int api_kcnt) {
                this.api_kcnt = api_kcnt;
            }

            public Map<String, Integer> getApi_equip_type() {
                return api_equip_type;
            }

            public void setApi_equip_type(Map<String, Integer> api_equip_type) {
                this.api_equip_type = api_equip_type;
            }

        }

        public static class ApiMstSlotitemEntity {
            private int api_id;
            private int api_sortno;
            private String api_name;
            private int api_taik;
            private int api_souk;
            private int api_houg;
            private int api_raig;
            private int api_soku;
            private int api_baku;
            private int api_tyku;
            private int api_tais;
            private int api_atap;
            private int api_houm;
            private int api_raim;
            private int api_houk;
            private int api_raik;
            private int api_bakk;
            private int api_saku;
            private int api_sakb;
            private int api_luck;
            private int api_leng;
            private int api_rare;
            private String api_info;
            private String api_usebull;
            private List<Integer> api_type;
            private List<Integer> api_broken;

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

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public int getApi_taik() {
                return api_taik;
            }

            public void setApi_taik(int api_taik) {
                this.api_taik = api_taik;
            }

            public int getApi_souk() {
                return api_souk;
            }

            public void setApi_souk(int api_souk) {
                this.api_souk = api_souk;
            }

            public int getApi_houg() {
                return api_houg;
            }

            public void setApi_houg(int api_houg) {
                this.api_houg = api_houg;
            }

            public int getApi_raig() {
                return api_raig;
            }

            public void setApi_raig(int api_raig) {
                this.api_raig = api_raig;
            }

            public int getApi_soku() {
                return api_soku;
            }

            public void setApi_soku(int api_soku) {
                this.api_soku = api_soku;
            }

            public int getApi_baku() {
                return api_baku;
            }

            public void setApi_baku(int api_baku) {
                this.api_baku = api_baku;
            }

            public int getApi_tyku() {
                return api_tyku;
            }

            public void setApi_tyku(int api_tyku) {
                this.api_tyku = api_tyku;
            }

            public int getApi_tais() {
                return api_tais;
            }

            public void setApi_tais(int api_tais) {
                this.api_tais = api_tais;
            }

            public int getApi_atap() {
                return api_atap;
            }

            public void setApi_atap(int api_atap) {
                this.api_atap = api_atap;
            }

            public int getApi_houm() {
                return api_houm;
            }

            public void setApi_houm(int api_houm) {
                this.api_houm = api_houm;
            }

            public int getApi_raim() {
                return api_raim;
            }

            public void setApi_raim(int api_raim) {
                this.api_raim = api_raim;
            }

            public int getApi_houk() {
                return api_houk;
            }

            public void setApi_houk(int api_houk) {
                this.api_houk = api_houk;
            }

            public int getApi_raik() {
                return api_raik;
            }

            public void setApi_raik(int api_raik) {
                this.api_raik = api_raik;
            }

            public int getApi_bakk() {
                return api_bakk;
            }

            public void setApi_bakk(int api_bakk) {
                this.api_bakk = api_bakk;
            }

            public int getApi_saku() {
                return api_saku;
            }

            public void setApi_saku(int api_saku) {
                this.api_saku = api_saku;
            }

            public int getApi_sakb() {
                return api_sakb;
            }

            public void setApi_sakb(int api_sakb) {
                this.api_sakb = api_sakb;
            }

            public int getApi_luck() {
                return api_luck;
            }

            public void setApi_luck(int api_luck) {
                this.api_luck = api_luck;
            }

            public int getApi_leng() {
                return api_leng;
            }

            public void setApi_leng(int api_leng) {
                this.api_leng = api_leng;
            }

            public int getApi_rare() {
                return api_rare;
            }

            public void setApi_rare(int api_rare) {
                this.api_rare = api_rare;
            }

            public String getApi_info() {
                return api_info;
            }

            public void setApi_info(String api_info) {
                this.api_info = api_info;
            }

            public String getApi_usebull() {
                return api_usebull;
            }

            public void setApi_usebull(String api_usebull) {
                this.api_usebull = api_usebull;
            }

            public List<Integer> getApi_type() {
                return api_type;
            }

            public void setApi_type(List<Integer> api_type) {
                this.api_type = api_type;
            }

            public List<Integer> getApi_broken() {
                return api_broken;
            }

            public void setApi_broken(List<Integer> api_broken) {
                this.api_broken = api_broken;
            }
        }

        public static class ApiMstFurnitureEntity {
            private int api_id;
            private int api_type;
            private int api_no;
            private String api_title;
            private String api_description;
            private int api_rarity;
            private int api_price;
            private int api_saleflg;
            private int api_season;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public String getApi_title() {
                return api_title;
            }

            public void setApi_title(String api_title) {
                this.api_title = api_title;
            }

            public String getApi_description() {
                return api_description;
            }

            public void setApi_description(String api_description) {
                this.api_description = api_description;
            }

            public int getApi_rarity() {
                return api_rarity;
            }

            public void setApi_rarity(int api_rarity) {
                this.api_rarity = api_rarity;
            }

            public int getApi_price() {
                return api_price;
            }

            public void setApi_price(int api_price) {
                this.api_price = api_price;
            }

            public int getApi_saleflg() {
                return api_saleflg;
            }

            public void setApi_saleflg(int api_saleflg) {
                this.api_saleflg = api_saleflg;
            }

            public int getApi_season() {
                return api_season;
            }

            public void setApi_season(int api_season) {
                this.api_season = api_season;
            }
        }

        public static class ApiMstFurnituregraphEntity {
            private int api_id;
            private int api_type;
            private int api_no;
            private String api_filename;
            private String api_version;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public String getApi_filename() {
                return api_filename;
            }

            public void setApi_filename(String api_filename) {
                this.api_filename = api_filename;
            }

            public String getApi_version() {
                return api_version;
            }

            public void setApi_version(String api_version) {
                this.api_version = api_version;
            }
        }

        public static class ApiMstUseitemEntity {
            private int api_id;
            private int api_usetype;
            private int api_category;
            private String api_name;
            private int api_price;
            private List<String> api_description;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_usetype() {
                return api_usetype;
            }

            public void setApi_usetype(int api_usetype) {
                this.api_usetype = api_usetype;
            }

            public int getApi_category() {
                return api_category;
            }

            public void setApi_category(int api_category) {
                this.api_category = api_category;
            }

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public int getApi_price() {
                return api_price;
            }

            public void setApi_price(int api_price) {
                this.api_price = api_price;
            }

            public List<String> getApi_description() {
                return api_description;
            }

            public void setApi_description(List<String> api_description) {
                this.api_description = api_description;
            }
        }

        public static class ApiMstPayitemEntity {
            private int api_id;
            private int api_type;
            private String api_name;
            private String api_description;
            private int api_price;
            private List<Integer> api_item;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public String getApi_description() {
                return api_description;
            }

            public void setApi_description(String api_description) {
                this.api_description = api_description;
            }

            public int getApi_price() {
                return api_price;
            }

            public void setApi_price(int api_price) {
                this.api_price = api_price;
            }

            public List<Integer> getApi_item() {
                return api_item;
            }

            public void setApi_item(List<Integer> api_item) {
                this.api_item = api_item;
            }
        }

        public static class ApiMstMapareaEntity {
            private int api_id;
            private String api_name;
            private int api_type;

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

            public int getApi_type() {
                return api_type;
            }

            public void setApi_type(int api_type) {
                this.api_type = api_type;
            }
        }

        public static class ApiMstMapinfoEntity {
            private int api_id;
            private int api_maparea_id;
            private int api_no;
            private String api_name;
            private int api_level;
            private String api_opetext;
            private String api_infotext;
            private Object api_max_maphp;
            private Object api_required_defeat_count;
            private List<Integer> api_item;
            private List<Integer> api_sally_flag;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_maparea_id() {
                return api_maparea_id;
            }

            public void setApi_maparea_id(int api_maparea_id) {
                this.api_maparea_id = api_maparea_id;
            }

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public int getApi_level() {
                return api_level;
            }

            public void setApi_level(int api_level) {
                this.api_level = api_level;
            }

            public String getApi_opetext() {
                return api_opetext;
            }

            public void setApi_opetext(String api_opetext) {
                this.api_opetext = api_opetext;
            }

            public String getApi_infotext() {
                return api_infotext;
            }

            public void setApi_infotext(String api_infotext) {
                this.api_infotext = api_infotext;
            }

            public Object getApi_max_maphp() {
                return api_max_maphp;
            }

            public void setApi_max_maphp(Object api_max_maphp) {
                this.api_max_maphp = api_max_maphp;
            }

            public Object getApi_required_defeat_count() {
                return api_required_defeat_count;
            }

            public void setApi_required_defeat_count(Object api_required_defeat_count) {
                this.api_required_defeat_count = api_required_defeat_count;
            }

            public List<Integer> getApi_item() {
                return api_item;
            }

            public void setApi_item(List<Integer> api_item) {
                this.api_item = api_item;
            }

            public List<Integer> getApi_sally_flag() {
                return api_sally_flag;
            }

            public void setApi_sally_flag(List<Integer> api_sally_flag) {
                this.api_sally_flag = api_sally_flag;
            }
        }

        public static class ApiMstMapbgmEntity {
            private int api_id;
            private int api_maparea_id;
            private int api_no;
            private List<Integer> api_map_bgm;
            private List<Integer> api_boss_bgm;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_maparea_id() {
                return api_maparea_id;
            }

            public void setApi_maparea_id(int api_maparea_id) {
                this.api_maparea_id = api_maparea_id;
            }

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public List<Integer> getApi_map_bgm() {
                return api_map_bgm;
            }

            public void setApi_map_bgm(List<Integer> api_map_bgm) {
                this.api_map_bgm = api_map_bgm;
            }

            public List<Integer> getApi_boss_bgm() {
                return api_boss_bgm;
            }

            public void setApi_boss_bgm(List<Integer> api_boss_bgm) {
                this.api_boss_bgm = api_boss_bgm;
            }
        }

        public static class ApiMstMapcellEntity {
            private int api_map_no;
            private int api_maparea_id;
            private int api_mapinfo_no;
            private int api_id;
            private int api_no;
            private int api_color_no;

            public int getApi_map_no() {
                return api_map_no;
            }

            public void setApi_map_no(int api_map_no) {
                this.api_map_no = api_map_no;
            }

            public int getApi_maparea_id() {
                return api_maparea_id;
            }

            public void setApi_maparea_id(int api_maparea_id) {
                this.api_maparea_id = api_maparea_id;
            }

            public int getApi_mapinfo_no() {
                return api_mapinfo_no;
            }

            public void setApi_mapinfo_no(int api_mapinfo_no) {
                this.api_mapinfo_no = api_mapinfo_no;
            }

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_no() {
                return api_no;
            }

            public void setApi_no(int api_no) {
                this.api_no = api_no;
            }

            public int getApi_color_no() {
                return api_color_no;
            }

            public void setApi_color_no(int api_color_no) {
                this.api_color_no = api_color_no;
            }
        }

        public static class ApiMstMissionEntity {
            private int api_id;
            private int api_maparea_id;
            private String api_name;
            private String api_details;
            private long api_time;
            private int api_difficulty;
            private double api_use_fuel;
            private double api_use_bull;
            private int api_return_flag;
            private List<Integer> api_win_item1;
            private List<Integer> api_win_item2;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_maparea_id() {
                return api_maparea_id;
            }

            public void setApi_maparea_id(int api_maparea_id) {
                this.api_maparea_id = api_maparea_id;
            }

            public String getApi_name() {
                return api_name;
            }

            public void setApi_name(String api_name) {
                this.api_name = api_name;
            }

            public String getApi_details() {
                return api_details;
            }

            public void setApi_details(String api_details) {
                this.api_details = api_details;
            }

            public long getApi_time() {
                return api_time;
            }

            public void setApi_time(long api_time) {
                this.api_time = api_time;
            }

            public int getApi_difficulty() {
                return api_difficulty;
            }

            public void setApi_difficulty(int api_difficulty) {
                this.api_difficulty = api_difficulty;
            }

            public double getApi_use_fuel() {
                return api_use_fuel;
            }

            public void setApi_use_fuel(double api_use_fuel) {
                this.api_use_fuel = api_use_fuel;
            }

            public double getApi_use_bull() {
                return api_use_bull;
            }

            public void setApi_use_bull(double api_use_bull) {
                this.api_use_bull = api_use_bull;
            }

            public int getApi_return_flag() {
                return api_return_flag;
            }

            public void setApi_return_flag(int api_return_flag) {
                this.api_return_flag = api_return_flag;
            }

            public List<Integer> getApi_win_item1() {
                return api_win_item1;
            }

            public void setApi_win_item1(List<Integer> api_win_item1) {
                this.api_win_item1 = api_win_item1;
            }

            public List<Integer> getApi_win_item2() {
                return api_win_item2;
            }

            public void setApi_win_item2(List<Integer> api_win_item2) {
                this.api_win_item2 = api_win_item2;
            }
        }

        public static class ApiMstShipupgradeEntity {
            private int api_id;
            private int api_current_ship_id;
            private int api_original_ship_id;
            private int api_upgrade_type;
            private int api_upgrade_level;
            private int api_drawing_count;
            private int api_catapult_count;
            private int api_sortno;

            public int getApi_id() {
                return api_id;
            }

            public void setApi_id(int api_id) {
                this.api_id = api_id;
            }

            public int getApi_current_ship_id() {
                return api_current_ship_id;
            }

            public void setApi_current_ship_id(int api_current_ship_id) {
                this.api_current_ship_id = api_current_ship_id;
            }

            public int getApi_original_ship_id() {
                return api_original_ship_id;
            }

            public void setApi_original_ship_id(int api_original_ship_id) {
                this.api_original_ship_id = api_original_ship_id;
            }

            public int getApi_upgrade_type() {
                return api_upgrade_type;
            }

            public void setApi_upgrade_type(int api_upgrade_type) {
                this.api_upgrade_type = api_upgrade_type;
            }

            public int getApi_upgrade_level() {
                return api_upgrade_level;
            }

            public void setApi_upgrade_level(int api_upgrade_level) {
                this.api_upgrade_level = api_upgrade_level;
            }

            public int getApi_drawing_count() {
                return api_drawing_count;
            }

            public void setApi_drawing_count(int api_drawing_count) {
                this.api_drawing_count = api_drawing_count;
            }

            public int getApi_catapult_count() {
                return api_catapult_count;
            }

            public void setApi_catapult_count(int api_catapult_count) {
                this.api_catapult_count = api_catapult_count;
            }

            public int getApi_sortno() {
                return api_sortno;
            }

            public void setApi_sortno(int api_sortno) {
                this.api_sortno = api_sortno;
            }
        }

        public static class ApiMstBgmEntity {
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
