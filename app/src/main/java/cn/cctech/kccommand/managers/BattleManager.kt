package cn.cctech.kccommand.managers

import cn.cctech.kccommand.cache.ApiCacheHelper
import cn.cctech.kccommand.entities.Ship
import cn.cctech.kccommand.events.api.*
import cn.cctech.kccommand.events.ui.BattleRefresh
import cn.cctech.kccommand.utils.*
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

@Suppress("unused")
object BattleManager : IManager() {

    var mArea: Int = -1
    var mMap: Int = -1
    var mNode: Int = -1
    var mHeading: Int = -1
    var mAirCommand: Int = -1
    var mRank: String = ""
    var mNext: Int = -1
    var mNodeType: Int = -1
    var mGet: String = ""

    private var mFleet: Int = -1
    private var mMineFormation: Int = -1
    private var mEnemyList: MutableList<Ship> = mutableListOf()
    private var mEnemyFormation: Int = -1

    fun isFleetInBattle(index: Int): Boolean {
        return when {
            mFleet == COMBINED_FLEET_INDEX -> index == 1 || index == 2
            index == mFleet -> true
            else -> false
        }
    }

    fun getEnemyList(): List<Ship> {
        return mEnemyList
    }

    fun getInBattleFleet(): Int {
        return mFleet
    }

    private fun notifyBattleRefresh() {
        val event = BattleRefresh()
        event.dispatch()
    }

    @Suppress("UNCHECKED_CAST")
    private fun calcTargetDamage(targetList: MutableList<Any>?, damageList: MutableList<Any>?, flagList: MutableList<Int>?) {
        if (targetList == null || damageList == null || flagList == null) return
        for ((i, target) in targetList.withIndex()) {
            try {
                val flag = flagList[i]
                if (flag != 0) continue
                val tArr = target as ArrayList<Int>
                val dArr = damageList[i] as ArrayList<Double>
                for ((j, t) in tArr.withIndex()) {
                    try {
                        val ship = mEnemyList[t]
                        ship.damage[ship.damage.lastIndex] += dArr[j].toInt()
                    } catch (e: Exception) {
                        Logger.e(e, "Can't set enemy damage for ship $i\n")
                    }
                }
            } catch (e: Exception) {
                Logger.e(e, "Can't set enemy damage for enemy $i")
            }
        }
    }

    private fun calcOrdinalDamage(damageList: List<Double>?) {
        if (damageList == null) return
        for ((i, value) in damageList.withIndex()) {
            try {
                val ship = mEnemyList[i]
                ship.damage[ship.damage.lastIndex] += value.toInt()
            } catch (e: Exception) {
                Logger.e(e, "Can't set edam for ship $i\n")
            }
        }
    }

    private fun setHps(nowHps: List<Int>?, maxHps: List<Int>?) {
        if (nowHps == null || maxHps == null) return
        for ((i, value) in nowHps.withIndex()) {
            try {
                val ship = mEnemyList[i]
                ship.nowHp = value
                ship.maxHp = maxHps[i]
                ship.saveDamage()
            } catch (e: Exception) {
                Logger.e(e, "Can't set hps for enemy ship $i\n")
            }
        }
    }

    private fun newTurn() {
        mEnemyList.forEach {
            it.damage.add(0)
        }
    }

    private fun calcRank(): String {
        var friendCount = 0
        var friendNowSum = 0
        var friendSunkCount = 0
        var friendAfterSum = 0
//        var friendFlagshipCritical = false
        var friendDamageSum = 0
        val fleet = ShipManager.getFleet(mFleet)
        if (fleet != null) {
            friendCount = fleet.size
            val shipList = fleet.map { ShipManager.getShipById(it) }
            friendSunkCount = shipList.count {
                it?.getHpFixed() ?: Int.MAX_VALUE <= 0
            }
            friendNowSum = shipList.sumBy { it?.nowHp ?: 0 }
            friendAfterSum = shipList.sumBy { it?.getHpFixed() ?: 0 }
//            friendFlagshipCritical = shipList[0]?.getHpFixed()?.times(4) ?: 0 <= shipList[0]?.maxHp ?: 0
            friendDamageSum = shipList.sumBy { it?.damage?.sum() ?: 0 }
        }
        val enemyCount = mEnemyList.size
        val enemySunkCount = mEnemyList.count { it.getHpFixed() <= 0 }
        val enemyNowSum = mEnemyList.sumBy { it.nowHp }
        val enemyAfterSum = mEnemyList.sumBy { it.getHpFixed() }
        val enemyFlagShipSunk = mEnemyList[0].getHpFixed() <= 0
        val enemyDamageSum = mEnemyList.sumBy { it.damage.sum() }

        val friendDamageRate = friendDamageSum * 100 / friendNowSum
        val enemyDamageRate = enemyDamageSum * 100 / enemyNowSum
        val rank = if (friendSunkCount == 0) {
            if (enemySunkCount == enemyCount) {
                if (friendDamageSum == 0) // TODO:使用女神？
                    "SS"
                else
                    "S"
            } else if (enemyCount > 1 && enemySunkCount >= Math.floor(0.7 * enemyCount).toInt()) {
                "A"
            } else if (enemyFlagShipSunk && friendSunkCount < enemySunkCount) {
                "B"
            } /*else if (friendCount == 1 && friendFlagshipCritical) {
                "D"
            }*/ else if (enemyDamageRate * 2 > friendDamageRate * 5) {
                "B"
            } else if (enemyDamageRate * 10 > friendDamageRate * 9) {
                "C"
            } else {
                "D"
            }
        } else if (friendCount - friendSunkCount == 1) {
            "E"
        } else {
            "D"
        }
        Logger.d("Calc rank : $rank")
        return rank
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattleStart(event: BattleStart) {
        if (event.api_result == 1) {
            try {
                mArea = event.api_data?.api_maparea_id ?: -1
                mMap = event.api_data?.api_mapinfo_no ?: -1
                mNode = event.api_data?.api_from_no ?: -1
                mNext = event.api_data?.api_no ?: -1
                mNodeType = event.api_data?.api_color_no ?: StartSpot
                mFleet = event.paramMap?.get("api_deck_id")?.toInt()?.minus(1) ?: -1
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }
            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNext(event: Next) {
        if (event.api_result == 1) {
            try {
                mArea = event.api_data?.api_maparea_id ?: -1
                mMap = event.api_data?.api_mapinfo_no ?: -1
                when (mNodeType) {
                    BattleSpot, BossBattle, AirStrike, LongDistanceAerialBattle,
                    NightBattle, EnemyCombinedFleet -> {
                    }
                    else -> mNode = mNext
                }
                mNext = event.api_data?.api_no ?: -1
                mNodeType = event.api_data?.api_color_no ?: -1
                mMineFormation = -1
                mEnemyFormation = -1
                mAirCommand = -1
                mHeading = -1
                mEnemyList.clear()
                mRank = ""
                mGet = ""
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }
            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattle(event: Battle) {
        if (event.api_result == 1) {
            try {
                mEnemyList.clear()

                mMineFormation = event.api_data?.api_formation?.get(0) ?: -1
                mEnemyFormation = event.api_data?.api_formation?.get(1) ?: -1
                mHeading = event.api_data?.api_formation?.get(2) ?: -1
                mAirCommand = event.api_data?.api_kouku?.api_stage1?.api_disp_seiku ?: -1

                val enemies: MutableList<Int>? = event.api_data?.api_ship_ke
                enemies?.forEachIndexed { index, id ->
                    let {
                        val rawShip = ApiCacheHelper.getShip(id)
                        val ship = Ship(rawShip)
                        ship.level = event.api_data?.api_ship_lv?.get(index) ?: 0
                        ship.nowHp = event.api_data?.api_e_nowhps?.get(index) ?: 0
                        ship.maxHp = event.api_data?.api_e_maxhps?.get(index) ?: 0
                        ship.items.addAll(event.api_data?.api_eSlot?.get(index) ?: emptyList())
                        mEnemyList.add(ship)
                    }
                }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }

            newTurn()

            calcOrdinalDamage(event.api_data?.api_kouku?.api_stage3?.api_edam)
            calcOrdinalDamage(event.api_data?.api_air_base_injection?.api_stage3?.api_edam)
            calcOrdinalDamage(event.api_data?.api_injection_kouku?.api_stage3?.api_edam)
            event.api_data?.api_air_base_attack?.forEach { calcOrdinalDamage(it.api_stage3?.api_edam) }

            calcOrdinalDamage(event.api_data?.api_support_info?.api_support_airattack?.api_stage3?.api_edam)
            calcOrdinalDamage(event.api_data?.api_support_info?.api_support_hourai?.api_damage)

            calcTargetDamage(event.api_data?.api_opening_taisen?.api_df_list,
                    event.api_data?.api_opening_taisen?.api_damage,
                    event.api_data?.api_opening_taisen?.api_at_eflag)
            calcOrdinalDamage(event.api_data?.api_opening_atack?.api_edam)
            calcTargetDamage(event.api_data?.api_hougeki1?.api_df_list,
                    event.api_data?.api_hougeki1?.api_damage,
                    event.api_data?.api_hougeki1?.api_at_eflag)
            calcTargetDamage(event.api_data?.api_hougeki2?.api_df_list,
                    event.api_data?.api_hougeki2?.api_damage,
                    event.api_data?.api_hougeki2?.api_at_eflag)
            calcTargetDamage(event.api_data?.api_hougeki3?.api_df_list,
                    event.api_data?.api_hougeki3?.api_damage,
                    event.api_data?.api_hougeki3?.api_at_eflag)
            calcOrdinalDamage(event.api_data?.api_raigeki?.api_edam)

            mRank = calcRank()
            mNode = mNext
            mNext = -1

            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattleNight(event: BattleNight) {
        if (event.api_result == 1) {
//            setHps(event.api_data?.api_e_nowhps, event.api_data?.api_e_maxhps)
            newTurn()

            calcTargetDamage(event.api_data?.api_hougeki?.api_df_list,
                    event.api_data?.api_hougeki?.api_damage,
                    event.api_data?.api_hougeki?.api_at_eflag)

            mRank = calcRank()

            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattleNightSp(event: BattleNightSp) {
        if (event.api_result == 1) {
            try {
                mEnemyList.clear()

                mMineFormation = event.api_data?.api_formation?.get(0) ?: -1
                mEnemyFormation = event.api_data?.api_formation?.get(1) ?: -1
                mHeading = event.api_data?.api_formation?.get(2) ?: -1

                val enemies: MutableList<Int>? = event.api_data?.api_ship_ke
                enemies?.forEachIndexed { index, id ->
                    let {
                        val rawShip = ApiCacheHelper.getShip(id)
                        val ship = Ship(rawShip)
                        ship.level = event.api_data?.api_ship_lv?.get(index) ?: 0
                        ship.nowHp = event.api_data?.api_e_nowhps?.get(index) ?: 0
                        ship.maxHp = event.api_data?.api_e_maxhps?.get(index) ?: 0
                        ship.items.addAll(event.api_data?.api_eSlot?.get(index) ?: emptyList())
                        mEnemyList.add(ship)
                    }
                }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }

            newTurn()

            calcOrdinalDamage(event.api_data?.api_n_support_info?.api_support_hourai?.api_damage)
            calcTargetDamage(event.api_data?.api_hougeki?.api_df_list,
                    event.api_data?.api_hougeki?.api_damage,
                    event.api_data?.api_hougeki?.api_at_eflag)

            mRank = calcRank()
            mNode = mNext
            mNext = -1

            notifyBattleRefresh()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPort(event: Port) {
        mArea = -1
        mMap = -1
        mNode = -1
        mNext = -1
        mNodeType = -1
        mFleet = -1
        mEnemyList.clear()
        mHeading = -1
        mAirCommand = -1
        mMineFormation = -1
        mEnemyFormation = -1
        mRank = ""
        mGet = ""
        notifyBattleRefresh()
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onBattleResult(event: BattleResult) {
        if (event.api_result == 1) {
            mGet = event.api_data?.api_get_ship?.api_ship_name ?: ""
            Logger.d("Get ship $mGet")
//            mRank = event.api_data?.api_win_rank ?: "D"
            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPractice(event: Practice) {
        if (event.api_result == 1) {
            try {
                mFleet = event.api_data?.api_deck_id?.minus(1) ?: -1
                mMineFormation = event.api_data?.api_formation?.get(0) ?: -1
                mEnemyFormation = event.api_data?.api_formation?.get(1) ?: -1
                mHeading = event.api_data?.api_formation?.get(2) ?: -1
                mAirCommand = event.api_data?.api_kouku?.api_stage1?.api_disp_seiku ?: -1

                mEnemyList.clear()
                val enemies: MutableList<Int>? = event.api_data?.api_ship_ke
                enemies?.forEachIndexed { index, id ->
                    kotlin.run {
                        val rawShip = ApiCacheHelper.getShip(id)
                        val ship = Ship(rawShip)
                        ship.level = event.api_data?.api_ship_lv?.get(index) ?: 0
                        ship.nowHp = event.api_data?.api_e_nowhps?.get(index) ?: 0
                        ship.maxHp = event.api_data?.api_e_maxhps?.get(index) ?: 0
                        ship.items.addAll(event.api_data?.api_eSlot?.get(index) ?: emptyList())
                        mEnemyList.add(ship)
                    }
                }
            } catch (e: Exception) {
                Logger.e(e, e.message)
            }

            newTurn()

            calcOrdinalDamage(event.api_data?.api_kouku?.api_stage3?.api_edam)
            calcTargetDamage(event.api_data?.api_opening_taisen?.api_df_list,
                    event.api_data?.api_opening_taisen?.api_damage,
                    event.api_data?.api_opening_taisen?.api_at_eflag)
            calcOrdinalDamage(event.api_data?.api_opening_atack?.api_edam)
            calcTargetDamage(event.api_data?.api_hougeki1?.api_df_list,
                    event.api_data?.api_hougeki1?.api_damage,
                    event.api_data?.api_hougeki1?.api_at_eflag)
            calcTargetDamage(event.api_data?.api_hougeki2?.api_df_list,
                    event.api_data?.api_hougeki2?.api_damage,
                    event.api_data?.api_hougeki2?.api_at_eflag)
            calcTargetDamage(event.api_data?.api_hougeki3?.api_df_list,
                    event.api_data?.api_hougeki3?.api_damage,
                    event.api_data?.api_hougeki3?.api_at_eflag)
            calcOrdinalDamage(event.api_data?.api_raigeki?.api_edam)

            mRank = calcRank()

            notifyBattleRefresh()
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onPracticeNight(event: PracticeNight) {
        if (event.api_result == 1) {
//            setHps(event.api_data?.api_e_nowhps, event.api_data?.api_e_maxhps)
            newTurn()

            calcTargetDamage(event.api_data?.api_hougeki?.api_df_list,
                    event.api_data?.api_hougeki?.api_damage,
                    event.api_data?.api_hougeki?.api_at_eflag)

            mRank = calcRank()

            notifyBattleRefresh()
        }
    }

}
