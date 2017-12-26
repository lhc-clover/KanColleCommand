package cn.cctech.kccommand.entities;

import java.util.List;

public class ApiShipData {

    /**
     * api_id : 6
     * api_sortno : 35
     * api_ship_id : 6
     * api_lv : 4
     * api_exp : [612,388,3]
     * api_nowhp : 13
     * api_maxhp : 13
     * api_soku : 10
     * api_leng : 1
     * api_slot : [8,-1,-1,-1,-1]
     * api_onslot : [0,0,0,0,0]
     * api_slot_ex : 0
     * api_kyouka : [4,1,1,1,0]
     * api_backs : 2
     * api_fuel : 15
     * api_bull : 15
     * api_slotnum : 2
     * api_ndock_time : 0
     * api_ndock_item : [0,0]
     * api_srate : 0
     * api_cond : 49
     * api_karyoku : [11,29]
     * api_raisou : [19,49]
     * api_taiku : [9,29]
     * api_soukou : [6,18]
     * api_kaihi : [38,69]
     * api_taisen : [16,39]
     * api_sakuteki : [4,17]
     * api_lucky : [15,69]
     * api_locked : 0
     * api_locked_equip : 0
     */

    private int api_id;
    private int api_sortno;
    private int api_ship_id;
    private int api_lv;
    private int api_nowhp;
    private int api_maxhp;
    private int api_soku;
    private int api_leng;
    private int api_slot_ex;
    private int api_backs;
    private int api_fuel;
    private int api_bull;
    private int api_slotnum;
    private int api_ndock_time;
    private int api_srate;
    private int api_cond;
    private int api_locked;
    private int api_locked_equip;
    private List<Integer> api_exp;
    private List<Integer> api_slot;
    private List<Integer> api_onslot;
    private List<Integer> api_kyouka;
    private List<Integer> api_ndock_item;
    private List<Integer> api_karyoku;
    private List<Integer> api_raisou;
    private List<Integer> api_taiku;
    private List<Integer> api_soukou;
    private List<Integer> api_kaihi;
    private List<Integer> api_taisen;
    private List<Integer> api_sakuteki;
    private List<Integer> api_lucky;

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

    public int getApi_ship_id() {
        return api_ship_id;
    }

    public void setApi_ship_id(int api_ship_id) {
        this.api_ship_id = api_ship_id;
    }

    public int getApi_lv() {
        return api_lv;
    }

    public void setApi_lv(int api_lv) {
        this.api_lv = api_lv;
    }

    public int getApi_nowhp() {
        return api_nowhp;
    }

    public void setApi_nowhp(int api_nowhp) {
        this.api_nowhp = api_nowhp;
    }

    public int getApi_maxhp() {
        return api_maxhp;
    }

    public void setApi_maxhp(int api_maxhp) {
        this.api_maxhp = api_maxhp;
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

    public int getApi_slot_ex() {
        return api_slot_ex;
    }

    public void setApi_slot_ex(int api_slot_ex) {
        this.api_slot_ex = api_slot_ex;
    }

    public int getApi_backs() {
        return api_backs;
    }

    public void setApi_backs(int api_backs) {
        this.api_backs = api_backs;
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

    public int getApi_slotnum() {
        return api_slotnum;
    }

    public void setApi_slotnum(int api_slotnum) {
        this.api_slotnum = api_slotnum;
    }

    public int getApi_ndock_time() {
        return api_ndock_time;
    }

    public void setApi_ndock_time(int api_ndock_time) {
        this.api_ndock_time = api_ndock_time;
    }

    public int getApi_srate() {
        return api_srate;
    }

    public void setApi_srate(int api_srate) {
        this.api_srate = api_srate;
    }

    public int getApi_cond() {
        return api_cond;
    }

    public void setApi_cond(int api_cond) {
        this.api_cond = api_cond;
    }

    public int getApi_locked() {
        return api_locked;
    }

    public void setApi_locked(int api_locked) {
        this.api_locked = api_locked;
    }

    public int getApi_locked_equip() {
        return api_locked_equip;
    }

    public void setApi_locked_equip(int api_locked_equip) {
        this.api_locked_equip = api_locked_equip;
    }

    public List<Integer> getApi_exp() {
        return api_exp;
    }

    public void setApi_exp(List<Integer> api_exp) {
        this.api_exp = api_exp;
    }

    public List<Integer> getApi_slot() {
        return api_slot;
    }

    public void setApi_slot(List<Integer> api_slot) {
        this.api_slot = api_slot;
    }

    public List<Integer> getApi_onslot() {
        return api_onslot;
    }

    public void setApi_onslot(List<Integer> api_onslot) {
        this.api_onslot = api_onslot;
    }

    public List<Integer> getApi_kyouka() {
        return api_kyouka;
    }

    public void setApi_kyouka(List<Integer> api_kyouka) {
        this.api_kyouka = api_kyouka;
    }

    public List<Integer> getApi_ndock_item() {
        return api_ndock_item;
    }

    public void setApi_ndock_item(List<Integer> api_ndock_item) {
        this.api_ndock_item = api_ndock_item;
    }

    public List<Integer> getApi_karyoku() {
        return api_karyoku;
    }

    public void setApi_karyoku(List<Integer> api_karyoku) {
        this.api_karyoku = api_karyoku;
    }

    public List<Integer> getApi_raisou() {
        return api_raisou;
    }

    public void setApi_raisou(List<Integer> api_raisou) {
        this.api_raisou = api_raisou;
    }

    public List<Integer> getApi_taiku() {
        return api_taiku;
    }

    public void setApi_taiku(List<Integer> api_taiku) {
        this.api_taiku = api_taiku;
    }

    public List<Integer> getApi_soukou() {
        return api_soukou;
    }

    public void setApi_soukou(List<Integer> api_soukou) {
        this.api_soukou = api_soukou;
    }

    public List<Integer> getApi_kaihi() {
        return api_kaihi;
    }

    public void setApi_kaihi(List<Integer> api_kaihi) {
        this.api_kaihi = api_kaihi;
    }

    public List<Integer> getApi_taisen() {
        return api_taisen;
    }

    public void setApi_taisen(List<Integer> api_taisen) {
        this.api_taisen = api_taisen;
    }

    public List<Integer> getApi_sakuteki() {
        return api_sakuteki;
    }

    public void setApi_sakuteki(List<Integer> api_sakuteki) {
        this.api_sakuteki = api_sakuteki;
    }

    public List<Integer> getApi_lucky() {
        return api_lucky;
    }

    public void setApi_lucky(List<Integer> api_lucky) {
        this.api_lucky = api_lucky;
    }

}
