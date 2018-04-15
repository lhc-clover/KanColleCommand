package cn.cctech.kccommand.utils

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import cn.cctech.kancolle.oyodo.entities.Ship
import cn.cctech.kancolle.oyodo.managers.*
import cn.cctech.kccommand.R
import com.orhanobut.logger.Logger

fun getFleetTagColor(index: Int): Int {
    return when {
        isFleetLock(index) -> R.color.tabBgColorBattle
        isFleetInBattle(index) -> R.color.tabBgColorBattle
        isFleetInExpedition(index) -> R.color.tabBgColorExpedition
        isFleetBadlyDamage(index) -> R.color.tabBgColorBadlyDamage
        isFleetNeedSupply(index) -> R.color.tabBgColorSupply
        isFleetMemberRepair(index) -> R.color.tabBgColorSupply
        else -> R.color.tabBgColorNormal
    }
}

private fun isFleetInBattle(index: Int): Boolean {
    return Battle.friendIndex == index
}

private fun isFleetInExpedition(index: Int): Boolean {
    val expedition = Dock.expeditionList.find { it?.value?.fleetIndex == index + 1 }
    return try {
        expedition?.value?.missionId?.toInt()!! > 0
    } catch (e: Exception) {
        false
    }
}

private fun isFleetNeedSupply(index: Int): Boolean {
    return getShips(index).count {
        (it.nowFuel < it.maxFuel) || (it.nowBullet < it.maxBullet)
    } > 0
}

private fun isFleetBadlyDamage(index: Int): Boolean {
    return getShips(index).count {
        val percent: Double = it.hp().toDouble().div(it.maxHp)
        percent in 0.0..BADLY_DAMAGE
    } > 0
}

private fun isFleetMemberRepair(index: Int): Boolean {
    return getShips(index).count { ship ->
        Dock.repairList.any { ship.id == it.value?.shipId }
    } > 0
}

private fun isFleetLock(index: Int): Boolean {
    return index >= User.deckCount.value
}

fun getSlotImage(slotId: Int): Int {
    var slotImageId = -1
    try {
        if (slotId > 0) {
            Fleet.slotMap[slotId]?.let { slotImageId = getSlotItemIcon(it.type) }
        }
    } catch (e: Exception) {
        Logger.e(e, "Can't get slot image for $slotId\n")
    }
    return slotImageId
}

private fun getSlotItemIcon(slotItemNum: Int): Int {
    return getImageResourceId("slot_$slotItemNum")
}

private fun getImageResourceId(name: String): Int {
    val drawables = R.drawable()
    var resId = R.drawable.slot_0
    try {
        val field = R.drawable::class.java.getField(name)
        resId = field.get(drawables) as Int
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return resId
}

fun getShipCondColor(context: Context, ship: Ship?): Int {
    val colorResId = ship?.let {
        when (ship.condition) {
            in 0..19 -> R.color.condColorRed
            in 20..29 -> R.color.condColorOrange
            in 50..100 -> R.color.condColorKira
            else -> R.color.condColorNormal
        }
    } ?: R.color.condColorNormal
    return ResourcesCompat.getColor(context.resources, colorResId, context.theme)
}

fun getHpColor(context: Context, ship: Ship?): Int {
    val colorResId = ship?.let {
        val percent = ship.hp().toDouble().div(ship.maxHp)
        when (percent) {
            in 0.0..BADLY_DAMAGE -> R.color.bloodBarColorBadlyDamage
            in BADLY_DAMAGE..HALF_DAMAGE -> R.color.bloodBarColorHalfDamage
            in HALF_DAMAGE..SLIGHT_DAMAGE -> R.color.bloodBarColorSlightDamage
            in SLIGHT_DAMAGE..1.0 -> R.color.bloodBarColorNoDamage
            else -> R.color.bloodBarColorNoDamage
        }
    } ?: R.color.bloodBarColorNoDamage
    return ResourcesCompat.getColor(context.resources, colorResId, context.theme)
}

fun getTagImage(ship: Ship?): Int {
    return if (isShipRepairing(ship?.id ?: -1)) R.drawable.tag_repair
    else -1
}

private fun isShipRepairing(shipId: Int): Boolean {
    return if (shipId < 0) false
    else Dock.repairList.any { shipId == it.value?.shipId ?: -1 }
}

fun getShipNameFixed(ship: Ship?): String {
    return ship?.let {
        if (ship.yomi.contains("flagship")
                || ship.yomi.contains("elite")) "${ship.name} ${ship.yomi}"
        else ship.name
    } ?: ""
}

fun getHpDisplay(ship: Ship?): String {
    return ship?.let {
        var display = "${ship.hp()} / ${ship.maxHp}"
        val damage = ship.damage.sum()
        if (damage > 0) display += " (-$damage)"
        display
    } ?: ""

}
