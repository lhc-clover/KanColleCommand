package cn.cctech.kccommand.entities

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import cn.cctech.kccommand.R
import cn.cctech.kccommand.events.api.GetShip
import cn.cctech.kccommand.events.api.PowerUp
import cn.cctech.kccommand.events.api.Start
import cn.cctech.kccommand.managers.DockManager
import cn.cctech.kccommand.managers.EquipManager
import cn.cctech.kccommand.utils.*
import com.orhanobut.logger.Logger
import java.util.*

@Suppress("MemberVisibilityCanPrivate")
class Ship {

    var id: Int = 0
    var sortNum: Int = 0 //图鉴编号
    var level: Int = 0 //等级
    var nowHp: Int = 0 //当前HP
    var maxHp: Int = 0 //最大HP
    var nowFuel: Int = 0 //当前油料
    var maxFuel: Int = 0 //最大油料
    var nowBullet: Int = 0 //当前弹药
    var maxBullet: Int = 0 //最大弹药
    var condition: Int = 0 //士气
    var name: String = "" //舰名
    var items = ArrayList<Int>() //装备
    var soku: Int = 0 //航速
    var carrys = ArrayList<Int>()//搭载
    var scout: Int = 0 //索敌
    var damage: Int = 0 //本轮损伤
    var yomi: String = "" //舰假名或舰阶

    constructor()

    constructor(rawShip: Start.ApiDataEntity.ApiMstShipEntity?, portShip: ApiShipData) {
        id = portShip.api_id
        sortNum = portShip.api_sortno
        level = portShip.api_lv
        nowHp = portShip.api_nowhp
        maxHp = portShip.api_maxhp
        nowFuel = portShip.api_fuel
        nowBullet = portShip.api_bull
        condition = portShip.api_cond
        items.addAll(portShip.api_slot)
        items.add(portShip.api_slot_ex)
        soku = portShip.api_soku
        carrys.addAll(portShip.api_onslot)
        scout = portShip.api_sakuteki[0]
        if (rawShip != null) {
            maxFuel = rawShip.api_fuel_max
            maxBullet = rawShip.api_bull_max
            name = rawShip.api_name
        }
    }

    constructor(rawShip: Start.ApiDataEntity.ApiMstShipEntity?, newShip: GetShip.ApiDataBean.ApiShipBean) {
        id = newShip.api_id
        sortNum = newShip.api_sortno
        level = newShip.api_lv
        nowHp = newShip.api_nowhp
        maxHp = newShip.api_maxhp
        nowFuel = newShip.api_fuel
        nowBullet = newShip.api_bull
        condition = newShip.api_cond
        items.addAll(newShip.api_slot)
        items.add(newShip.api_slot_ex)
        soku = newShip.api_soku
        carrys.addAll(newShip.api_onslot)
        scout = newShip.api_sakuteki[0]
        if (rawShip != null) {
            maxFuel = rawShip.api_fuel_max
            maxBullet = rawShip.api_bull_max
            name = rawShip.api_name
        }
    }

    constructor(rawShip: Start.ApiDataEntity.ApiMstShipEntity?) {
        if (rawShip != null) {
            id = rawShip.api_id
            sortNum = rawShip.api_sortno
            name = rawShip.api_name
            soku = rawShip.api_soku
            yomi = rawShip.api_yomi
        }
    }

    fun getSlotImage(index: Int): Int {
        var slotImageId = -1
        try {
            val slotItemId = items[index]
            if (slotItemId > 0) {
                val equip = EquipManager.getEquipById(slotItemId)
                if (equip != null) slotImageId = ApiParser.getSlotItemIcon(equip.type)
            }
        } catch (e: Exception) {
            Logger.e(e, "Can't get slot image\n")
        }
        return slotImageId
    }

    fun getHpColor(context: Context): Int {
        val percent: Double = getHpFixed().toDouble().div(maxHp)
        val colorResId = when (percent) {
            in SLIGHT_DAMAGE..1.0 -> R.color.bloodBarColorNoDamage
            in HALF_DAMAGE..SLIGHT_DAMAGE -> R.color.bloodBarColorSlightDamage
            in BADLY_DAMAGE..HALF_DAMAGE -> R.color.bloodBarColorHalfDamage
            in 0.0..BADLY_DAMAGE -> R.color.bloodBarColorBadlyDamage
            else -> R.color.bloodBarColorNoDamage
        }
        return ResourcesCompat.getColor(context.resources, colorResId, context.theme)
    }

    fun getCondColor(context: Context): Int {
        val colorResId = when (condition) {
            in 50..100 -> R.color.condColorKira
            in 20..29 -> R.color.condColorOrange
            in 0..19 -> R.color.condColorRed
            else -> R.color.condColorNormal
        }
        return ResourcesCompat.getColor(context.resources, colorResId, context.theme)
    }

    fun getAirPower(): Int {
        val totalAAC = intArrayOf(0, 0)
        for ((index, equipId) in items.withIndex()) {
            val carry = try {
                carrys[index]
            } catch (e: Exception) {
                0
            }
            val equip = EquipManager.getEquipById(equipId)
            if (equip != null) {
                val baseAAC = calcBasicAAC(equip.type, equip.calcLevelAAC(), carry)
                val masteryAAC = equip.calcMasteryAAC(0)
                totalAAC[0] += Math.floor(baseAAC + masteryAAC[0]).toInt()
                totalAAC[1] += Math.floor(baseAAC + masteryAAC[1]).toInt()
            }
        }
        return totalAAC[0]
    }

    private fun calcBasicAAC(type: Int, aac: Double, carry: Int): Double {
        return when (type) {
            FIGHTER, BOMBER, TORPEDO_BOMBER, SEA_BOMBER, SEA_FIGHTER, LBA_AIRCRAFT, ITCP_FIGHTER,
            JET_FIGHTER, JET_BOMBER, JET_TORPEDO_BOMBER -> Math.sqrt(carry.toDouble()) * aac
            else -> 0.0
        }
    }

    fun needSupply(): Boolean {
        return (nowFuel < maxFuel) || (nowBullet < maxBullet)
    }

    fun badlyDamage(): Boolean {
        val percent: Double = getHpFixed().toDouble().div(maxHp)
        return percent in 0.0..BADLY_DAMAGE
    }

    fun getHpDisplay(): String {
        var display = "${getHpFixed()} / $maxHp"
        if (damage > 0) display += " (-$damage)"
        return display
    }

    fun getHpFixed(): Int = maxOf(nowHp - damage, 0)

    fun getTagImage(): Int {
        return if (DockManager.isShipRepairing(id)) R.drawable.tag_repair
        else -1
    }

    fun getShipNameFixed(): String {
        return if (yomi.contains("flagship") || yomi.contains("elite")) "$name $yomi" else name
    }

    fun powerUp(entity: PowerUp.ApiDataBean.ApiShipBean?) {
        if (entity != null) {
            maxHp = entity.api_maxhp
        }
    }

}
