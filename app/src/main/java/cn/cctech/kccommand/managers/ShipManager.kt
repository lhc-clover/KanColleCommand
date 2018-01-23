package cn.cctech.kccommand.managers

import android.util.SparseArray
import cn.cctech.kccommand.R
import cn.cctech.kccommand.cache.ApiCacheHelper
import cn.cctech.kccommand.entities.Ship
import cn.cctech.kccommand.events.api.*
import cn.cctech.kccommand.events.ui.FleetRefresh
import cn.cctech.kccommand.utils.*
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused")
object ShipManager : IManager() {

    private val mShipMap = SparseArray<Ship>()
    private val mFleets = SparseArray<ArrayList<Int>>()
    private val mNames = SparseArray<String>()

    fun getShipById(id: Int): Ship? {
        return mShipMap.get(id)
    }

    fun getFleet(num: Int): List<Int>? {
        return mFleets.get(num)
    }

    fun getFleetSpeedType(index: Int): Speed {
        var isSlowFleet = false
        val fleet = getFleet(index)
        if (fleet != null) {
            for (shipId in fleet) {
                val ship: Ship? = getShipById(shipId)
                if (ship != null && ship.soku < SPEED_FAST) {
                    isSlowFleet = true
                    break
                }
            }
        }
        return if (isSlowFleet) Speed.SLOW else Speed.FAST
    }

    fun getFleetLevel(index: Int): Int {
        var fleetLevel = 0
        val fleet = getFleet(index)
        fleet?.map { getShipById(it) }?.forEach { fleetLevel += it?.level ?: 0 }
        return fleetLevel
    }

    fun getFleetAirPower(index: Int): Pair<Int, Int> {
        var min = 0
        var max = 0
        val fleet = getFleet(index)
        fleet?.map { getShipById(it) }?.forEach {
            val valuePair = it?.getAirPower()
            min += valuePair?.first ?: 0
            max += valuePair?.second ?: 0
        }
        return Pair(min, max)
    }

    fun getFleetScout(index: Int): Double {
        var equipScoutSum = 0.0
        var shipScoutSum = 0.0
        val fleet = getFleet(index)
        fleet?.map { getShipById(it) }?.forEach { ship ->
            run {
                shipScoutSum += Math.sqrt(ship?.scout?.toDouble() ?: 0.0)
                ship?.items?.map { EquipManager.getEquipById(it) }
                        ?.forEach { equipScoutSum += it?.calcScout() ?: 0.0 }
            }
        }
        return equipScoutSum + shipScoutSum + getCommandLevelPenaltyScout() + getFleetCountBonusScout(index)
    }

    private fun getCommandLevelPenaltyScout(): Double {
        return Math.ceil(BasicManager.basic.level * 0.4) * -1
    }

    private fun getFleetCountBonusScout(index: Int): Double {
        val shipCount = getFleet(index).orEmpty().count { it > 0 }
        return (MAX_SHIP_COUNT - shipCount) * 2.0
    }

    fun getFleetTagColor(index: Int): Int {
        return when {
            BattleManager.isFleetInBattle(index) -> R.color.tabBgColorBattle
            DockManager.isFleetOnExpedition(index) -> R.color.tabBgColorExpedition
            fleetBadlyDamage(index) -> R.color.tabBgColorBadlyDamage
            fleetNeedSupply(index) -> R.color.tabBgColorSupply
            fleetMemberInDock(index) -> R.color.tabBgColorSupply
            else -> R.color.tabBgColorNormal
        }
    }

    private fun fleetNeedSupply(index: Int): Boolean {
        return getFleet(index).orEmpty().count { getShipById(it)?.needSupply() ?: false } > 0
    }

    private fun fleetBadlyDamage(index: Int): Boolean {
        return getFleet(index).orEmpty().count { getShipById(it)?.badlyDamage() ?: false } > 0
    }

    private fun fleetMemberInDock(index: Int): Boolean {
        return getFleet(index).orEmpty().count { DockManager.isShipRepairing(getShipById(it)?.id ?: -1) } > 0
    }

    fun notifyFleetRefresh() {
        val fleetRefreshEvent = FleetRefresh()
        fleetRefreshEvent.dispatch()
    }

    private fun fillFleet(fleet: MutableList<Int>) {
        val count = fleet.size
        for (i in 0 until MAX_SHIP_COUNT - count) {
            fleet.add(-1)
        }
    }

    fun getFleetName(index: Int): String? {
        return try {
            mNames[index]
        } catch (e: Exception) {
            null
        }
    }

    private fun setShip(shipId: Int, ship: Ship?) {
        mShipMap.put(shipId, ship)
    }

    fun setShipRecovery(shipId: Int) {
        val ship = mShipMap[shipId]
        ship.nowHp = ship.maxHp
        notifyFleetRefresh()
    }

    fun addNewShip(newShip: GetShip.ApiDataBean.ApiShipBean) {
        val rawShip = ApiCacheHelper.getShip(newShip.api_ship_id)
        val ship = Ship(rawShip, newShip)
        mShipMap.put(newShip.api_id, ship)
    }

    fun removeShip(shipId: Int) {
        if (shipId > 0) mShipMap.remove(shipId)
    }

    fun getShipCount(): Int {
        return mShipMap.size()
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPort(event: Port) {
        if (event.api_result == 1) {
            try {
                val deckPort = event.api_data.api_deck_port
                for (i in deckPort.indices) {
                    val fleetInfo = deckPort[i]
                    mFleets.put(i, fleetInfo.api_ship as ArrayList<Int>?)
                    mNames.put(i, fleetInfo.api_name)
                }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }

            try {
                for (item in event.api_data.api_ship) {
                    val rawShip = ApiCacheHelper.getShip(item.api_ship_id)
                    val ship = Ship(rawShip, item)
                    mShipMap.put(item.api_id, ship)
                }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }

            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onCharge(event: Charge) {
        if (event.api_result == 1) {
            for (info in event.api_data.api_ship) {
                try {
                    val ship = mShipMap.get(info.api_id)
                    ship.nowFuel = info.api_fuel
                    ship.nowBullet = info.api_bull
                } catch (e: Exception) {
                    Logger.e(e, e.message)
                }

            }
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onChange(event: Change) {
        if (event.api_result == 1 && event.inflate()) {
            Logger.d("api_id = " + event.apiId + "\napi_ship_id = " + event.apiShipId + "\napi_ship_idx = " + event.apiShipIdx)
            val fleet = mFleets.get(event.apiId - 1)
            if (event.apiShipId > 0) {
                val destShip = fleet[event.apiShipIdx]
                for (i in 0 until MAX_FLEET_COUNT) {
                    val deck = mFleets.get(i)
                    try {
                        val srcIndex = deck.indexOf(event.apiShipId)
                        if (srcIndex != -1) {
                            fleet[srcIndex] = destShip
                            break
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
                fleet[event.apiShipIdx] = event.apiShipId
            } else if (event.apiShipId == -2) { //编队解除
                val flagShip = fleet[0]
                fleet.clear()
                fleet.add(flagShip)
            } else if (event.apiShipId == -1) { //单舰解除
                fleet.removeAt(event.apiShipIdx)
            }
            fillFleet(fleet)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onShip3(event: Ship3) {
        val shipData = event.api_data.api_ship_data[0]
        val rawShip = ApiCacheHelper.getShip(shipData.api_ship_id)
        val ship = Ship(rawShip, shipData)
        mShipMap.put(shipData.api_id, ship)
        notifyFleetRefresh()
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSlotExchangeIndex(event: SlotExchangeIndex) {
        try {
            val forms = ApiParser.convertFormToMap(event.requestBody)
            val shipId = Integer.parseInt(forms["api_id"])
            val ship = mShipMap.get(shipId)
            ship.items = event.api_data.api_slot as ArrayList<Int>
            mShipMap.put(shipId, ship)
            notifyFleetRefresh()
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onDeck(event: Deck) {
        if (event.api_result == 1) {
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattle(event: Battle) {
        if (event.api_result == 1) {
            val fleetIndex = try {
                event.api_data.api_deck_id - 1
            } catch (e: Exception) {
                null
            }
            setHps(fleetIndex, event.api_data?.api_f_nowhps, event.api_data?.api_f_maxhps)

            calcOrdinalDamage(fleetIndex, event.api_data?.api_kouku?.api_stage3?.api_fdam)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_air_base_injection?.api_stage3?.api_fdam)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_injection_kouku?.api_stage3?.api_fdam)
            event.api_data?.api_air_base_attack?.forEach { calcOrdinalDamage(fleetIndex, it.api_stage3?.api_fdam) }

//            calcOrdinalDamage(fleetIndex, event.api_data.api_support_info.api_support_airattack.api_stage3.api_edam)
//            calcOrdinalDamage(fleetIndex, event.api_data.api_support_info.api_support_hourai.api_damage)
            calcTargetDamage(fleetIndex, event.api_data?.api_opening_taisen?.api_df_list,
                    event.api_data?.api_opening_taisen?.api_damage,
                    event.api_data?.api_opening_taisen?.api_at_eflag)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_opening_atack?.api_fdam)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki1?.api_df_list,
                    event.api_data?.api_hougeki1?.api_damage,
                    event.api_data?.api_hougeki1?.api_at_eflag)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki2?.api_df_list,
                    event.api_data?.api_hougeki2?.api_damage,
                    event.api_data?.api_hougeki2?.api_at_eflag)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki3?.api_df_list,
                    event.api_data?.api_hougeki3?.api_damage,
                    event.api_data?.api_hougeki3?.api_at_eflag)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_raigeki?.api_fdam)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattleNight(event: BattleNight) {
        if (event.api_result == 1) {
            val fleetIndex = try {
                event.api_data.api_deck_id.toInt() - 1
            } catch (e: Exception) {
                null
            }
            setHps(fleetIndex, event.api_data?.api_f_nowhps, event.api_data?.api_f_maxhps)

            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki?.api_df_list,
                    event.api_data?.api_hougeki?.api_damage,
                    event.api_data?.api_hougeki?.api_at_eflag)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNext(event: Next) {
        if (event.api_result == 1) {
            try {
                val fleetIndex = BattleManager.getInBattleFleet()
                val fleet = getFleet(fleetIndex)
                fleet?.forEach {
                    val ship = getShipById(it)
                    if (ship != null) {
                        ship.nowHp = ship.getHpFixed()
                        ship.damage = 0
                        setShip(it, ship)
                    }
                }
                notifyFleetRefresh()
            } catch (e: Exception) {
                Logger.e(e, "Can't set hp when next.")
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPractice(event: Practice) {
        if (event.api_result == 1) {
            val fleetIndex = try {
                event.api_data.api_deck_id - 1
            } catch (e: Exception) {
                null
            }
            setHps(fleetIndex, event.api_data?.api_f_nowhps, event.api_data?.api_f_maxhps)

            calcOrdinalDamage(fleetIndex, event.api_data?.api_kouku?.api_stage3?.api_fdam)

            calcTargetDamage(fleetIndex, event.api_data?.api_opening_taisen?.api_df_list,
                    event.api_data?.api_opening_taisen?.api_damage,
                    event.api_data?.api_opening_taisen?.api_at_eflag)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_opening_atack?.api_fdam)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki1?.api_df_list,
                    event.api_data?.api_hougeki1?.api_damage,
                    event.api_data?.api_hougeki1?.api_at_eflag)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki2?.api_df_list,
                    event.api_data?.api_hougeki2?.api_damage,
                    event.api_data?.api_hougeki2?.api_at_eflag)
            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki3?.api_df_list,
                    event.api_data?.api_hougeki3?.api_damage,
                    event.api_data?.api_hougeki3?.api_at_eflag)
            calcOrdinalDamage(fleetIndex, event.api_data?.api_raigeki?.api_fdam)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPracticeNight(event: PracticeNight) {
        if (event.api_result == 1) {
            val fleetIndex = try {
                event.api_data.api_deck_id.minus(1)
            } catch (e: Exception) {
                null
            }
            setHps(fleetIndex, event.api_data?.api_f_nowhps, event.api_data?.api_f_maxhps)

            calcTargetDamage(fleetIndex, event.api_data?.api_hougeki?.api_df_list,
                    event.api_data?.api_hougeki?.api_damage,
                    event.api_data?.api_hougeki?.api_at_eflag)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNdock(event: Ndock) {
        if (event.api_result == 1) {
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSlotDeprive(event: SlotDeprive) {
        if (event.api_result == 1) {
            val destBean = event.api_data.api_ship_data.api_set_ship
            val shipDest = getShipById(destBean.api_id)
            shipDest?.items?.clear()
            shipDest?.items?.addAll(destBean.api_slot)
            shipDest?.items?.add(destBean.api_slot_ex)
            setShip(destBean.api_id, shipDest)
            val srcBean = event.api_data.api_ship_data.api_unset_ship
            val shipSrc = getShipById(srcBean.api_id)
            shipSrc?.items?.clear()
            shipSrc?.items?.addAll(srcBean.api_slot)
            shipSrc?.items?.add(srcBean.api_slot_ex)
            setShip(srcBean.api_id, shipSrc)
            notifyFleetRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPowerUp(event: PowerUp) {
        if (event.api_result == 1) {
            event.paramMap["api_id_items"]?.split("%2C")?.forEach {
                val shipId = try {
                    it.toInt()
                } catch (e: Exception) {
                    -1
                }
                if (shipId > 0) {
                    val ship = ShipManager.getShipById(shipId)
                    ship?.items?.forEach { EquipManager.removeEquip(it) }
                    BasicManager.basic.slotCount = EquipManager.getEquipCount()
                    ShipManager.removeShip(shipId)
                    BasicManager.basic.shipCount = ShipManager.getShipCount()
                    BasicManager.notifyBasicRefresh()
                }
            }
            if (event.api_data?.api_powerup_flag == 1) {
                val shipId = event.api_data?.api_ship?.api_id ?: -1
                ShipManager.getShipById(shipId)?.powerUp(event.api_data?.api_ship)
            }
            event.api_data?.api_deck?.forEachIndexed { index, apiDeckBean ->
                mFleets.put(index, apiDeckBean.api_ship as ArrayList<Int>?)
                mNames.put(index, apiDeckBean.api_name)
            }
            notifyFleetRefresh()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun calcTargetDamage(index: Int?, targetList: MutableList<Any>?, damageList: MutableList<Any>?, flagList: MutableList<Int>?) {
        if (targetList == null || damageList == null || index == null || flagList == null) return
        try {
            val fleet = getFleet(index)
            if (fleet != null) {
                for ((i, target) in targetList.withIndex()) {
                    val flag = flagList[i]
                    if (flag != 1) continue
                    val tArr = target as ArrayList<Int>
                    val dArr = damageList[i] as ArrayList<Double>
                    for ((j, t) in tArr.withIndex()) {
                        try {
                            val shipId = fleet[t]
                            val ship = getShipById(shipId)
                            ship!!.damage += dArr[j].toInt()
                            setShip(shipId, ship)
                        } catch (e: Exception) {
                            Logger.e(e, "Can't set damage for ship $i in fleet $index\n")
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Logger.e(e, "Can't set hougeki damage for fleet $index\n")
        }
    }

    private fun calcOrdinalDamage(index: Int?, damageList: List<Double>?) {
        if (damageList == null || index == null) return
        try {
            val fleet = getFleet(index)
            if (fleet != null) {
                for ((i, value) in damageList.withIndex()) {
                    try {
                        val shipId = fleet[i]
                        val ship = getShipById(shipId)
                        ship!!.damage += value.toInt()
                        setShip(shipId, ship)
                    } catch (e: Exception) {
                        Logger.e(e, "Can't set fdam for ship $i in fleet $index\n")
                    }
                }
            }
        } catch (e: Exception) {
            Logger.e(e, "Can't set fdam for fleet $index\n")
        }
    }

    private fun setHps(index: Int?, nowHps: List<Int>?, maxHps: List<Int>?) {
        if (nowHps == null || maxHps == null || index == null) return
        try {
            val fleet = getFleet(index)
            if (fleet != null) {
                for ((i, value) in nowHps.withIndex()) {
                    try {
                        val shipId = fleet[i]
                        val ship = getShipById(shipId)
                        ship?.nowHp = value
                        ship?.maxHp = maxHps[i]
                        ship?.damage = 0
                        setShip(shipId, ship)
                    } catch (e: Exception) {
                        Logger.e(e, "Can't set hps for ship $i in fleet $index\n")
                    }
                }
            }
        } catch (e: Exception) {
            Logger.e(e, "Can't set hps for fleet $index\n")
        }
    }

}
