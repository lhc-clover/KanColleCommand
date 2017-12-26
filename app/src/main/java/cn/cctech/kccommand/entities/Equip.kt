package cn.cctech.kccommand.entities

import cn.cctech.kccommand.events.api.RequireInfo
import cn.cctech.kccommand.events.api.Start
import cn.cctech.kccommand.utils.*

class Equip {

    var name: String? = null
    var type: Int = 0
    var aac: Int = 0 //对空
    var mastery: Int = 0 //熟练度
    var level: Int = 0 //改修
    var scout: Int = 0 //索敌

    constructor()

    constructor(rawEquip: Start.ApiDataEntity.ApiMstSlotitemEntity?, portEquip: RequireInfo.ApiDataEntity.ApiSlotItemEntity) {
        if (rawEquip != null) {
            name = rawEquip.api_name
            type = rawEquip.api_type[3]
            aac = rawEquip.api_tyku
            scout = rawEquip.api_saku
        }
        mastery = portEquip.api_alv
        level = portEquip.api_level
    }

    fun calcLevelAAC(): Double {
        return when (type) {
            FIGHTER -> aac + 0.2 * level
            BOMBER, JET_BOMBER -> if (aac > 0) {
                aac + 0.25 * level
            } else {
                0.0
            }
            else -> aac.toDouble()
        }
    }

    fun calcMasteryAAC(mode: Int): DoubleArray {
        var minMastery = mastery
        if (mode == 1) {
            minMastery = 0
        }
        val rangeAAC = doubleArrayOf(0.0, 0.0)
        when (type) {
            FIGHTER, SEA_FIGHTER -> {
                rangeAAC[0] += kFighterMasteryBonus[minMastery].toDouble()
                rangeAAC[1] += kFighterMasteryBonus[mastery].toDouble()
                rangeAAC[0] += Math.sqrt(kBasicMasteryMinBonus[minMastery] / 10.0)
                rangeAAC[1] += Math.sqrt(kBasicMasteryMaxBonus[mastery] / 10.0)
            }
            BOMBER, TORPEDO_BOMBER, JET_BOMBER -> {
                rangeAAC[0] += Math.sqrt(kBasicMasteryMinBonus[minMastery] / 10.0)
                rangeAAC[1] += Math.sqrt(kBasicMasteryMaxBonus[mastery] / 10.0)
            }
            SEA_BOMBER -> {
                rangeAAC[0] += kSeaBomberMasteryBonus[minMastery].toDouble()
                rangeAAC[1] += kSeaBomberMasteryBonus[mastery].toDouble()
                rangeAAC[0] += Math.sqrt(kBasicMasteryMinBonus[minMastery] / 10.0)
                rangeAAC[1] += Math.sqrt(kBasicMasteryMaxBonus[mastery] / 10.0)
            }
            SEA_SCOUT, SCOUT -> {
            }
            else -> {
            }
        }
        return rangeAAC
    }

    fun calcScout(): Double {
        return when (type) {
            TORPEDO_BOMBER -> 0.8 * scout
            SCOUT -> 1.0 * scout
            SCOUT_II -> 1.0 * scout
            SEA_SCOUT -> 1.2 * (scout + 1.2 * Math.sqrt(level.toDouble()))
            SEA_BOMBER -> 1.1 * scout
            RADAR_LARGE -> 0.6 * (scout + 1.4 * Math.sqrt(level.toDouble()))
            RADAR_SMALL -> 0.6 * (scout + 1.25 * Math.sqrt(level.toDouble()))
            else -> 0.6 * scout
        }
    }
}