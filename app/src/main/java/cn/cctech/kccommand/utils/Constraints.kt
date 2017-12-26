package cn.cctech.kccommand.utils

import cn.cctech.kccommand.R

const val MAX_SHIP_COUNT = 7
const val MAX_FLEET_COUNT = 4

const val COMBINED_FLEET_INDEX = 11

val kBasicMasteryMinBonus = intArrayOf(0, 10, 25, 40, 55, 70, 85, 100)
val kBasicMasteryMaxBonus = intArrayOf(9, 24, 39, 54, 69, 84, 99, 120)

val kFighterMasteryBonus = intArrayOf(0, 0, 2, 5, 9, 14, 14, 22, 0, 0, 0)
val kSeaBomberMasteryBonus = intArrayOf(0, 0, 1, 1, 1, 3, 3, 6, 0, 0, 0)

enum class Speed { SLOW, FAST }

/** 小破(75%)  */
const val SLIGHT_DAMAGE = 0.75
/** 中破(50%)  */
const val HALF_DAMAGE = 0.5
/** 大破(25%)  */
const val BADLY_DAMAGE = 0.25

/** 低速  */
const val SPEED_SLOW = 5
/** 高速  */
const val SPEED_FAST = 10
/** 高速+  */
const val SPEED_FASTPLUS = 15
/** 最速  */
const val SPEED_SUPERFAST = 20

val kFormationMap = mapOf(1 to R.string.formation_1, 2 to R.string.formation_2, 3 to R.string.formation_3,
        4 to R.string.formation_4, 5 to R.string.formation_5, 6 to R.string.formation_6, 11 to R.string.formation_11,
        12 to R.string.formation_12, 13 to R.string.formation_13, 14 to R.string.formation_14)
val kHeadingMap = mapOf(1 to R.string.heading_1, 2 to R.string.heading_2, 3 to R.string.heading_3, 4 to R.string.heading_4)
val kAirCommandMap = mapOf(0 to R.string.air_command_0, 1 to R.string.air_command_1,
        2 to R.string.air_command_2, 3 to R.string.air_command_3, 4 to R.string.air_command_4)

val kExpeditionMap: Map<Int, String> = mapOf(
        1 to "練習航海",
        2 to "長距離練習航海",
        3 to "警備任務",
        4 to "対潜警戒任務",
        5 to "海上護衛任務",
        6 to "防空射撃演習",
        7 to "観艦式予行",
        8 to "観艦式",
        9 to "タンカー護衛任務",
        10 to "強行偵察任務",
        11 to "ボーキサイト輸送任務",
        12 to "資源輸送任務",
        13 to "鼠輸送作戦",
        14 to "包囲陸戦隊撤収作戦",
        15 to "囮機動部隊支援作戦",
        16 to "艦隊決戦援護作戦",
        17 to "敵地偵察作戦",
        18 to "航空機輸送作戦",
        19 to "北号作戦",
        20 to "潜水艦哨戒任務",
        21 to "北方鼠輸送作戦",
        22 to "艦隊演習",
        23 to "航空戦艦運用演習",
        24 to "北方航路海上護衛",
        25 to "通商破壊作戦",
        26 to "敵母港空襲作戦",
        27 to "潜水艦通商破壊作戦",
        28 to "西方海域封鎖作戦",
        29 to "潜水艦派遣演習",
        30 to "潜水艦派遣作戦",
        31 to "海外艦との接触",
        32 to "遠洋練習航海",
        33 to "前衛支援任務",
        34 to "艦隊決戦支援任務",
        35 to "MO作戦",
        36 to "水上機基地建設",
        37 to "東京急行",
        38 to "東京急行(弐)",
        39 to "遠洋潜水艦作戦",
        40 to "水上機前線輸送",
        100 to "兵站強化任務",
        101 to "海峡警備行動",
        102 to "長時間対潜警戒",
        110 to "南西方面航空偵察作戦",
        133 to "[E] 前衛支援任務",
        134 to "[E] 艦隊決戦支援任務")