package cn.cctech.kccommand.entities

import cn.cctech.kccommand.events.api.Port
import cn.cctech.kccommand.managers.EquipManager

class Basic {

    var fuel: Int = 0 //油
    var ammo: Int = 0 //弹
    var metal: Int = 0 //钢
    var bauxite: Int = 0 //铝
    var bucket: Int = 0 //桶
    var burner: Int = 0 //喷火
    var research: Int = 0 //紫菜
    var improve: Int = 0 //螺丝

    var nickname: String = "" //昵称
    var level: Int = 0 //等级
    var shipCount: Int = 0 //拥有舰娘
    var shipMax: Int = 0 //最大舰娘
    var slotCount: Int = 0 //拥有装备
    var slotMax: Int = 0 //最大装备
    var kDockCount: Int = 0 //开放建造池
    var nDockCount: Int = 0 //开放维修池
    var deckCount: Int = 0 //开放舰队

    constructor()

    constructor(entity: Port?) {
        fuel = entity?.api_data?.api_material?.get(0)?.api_value ?: 0
        ammo = entity?.api_data?.api_material?.get(1)?.api_value ?: 0
        metal = entity?.api_data?.api_material?.get(2)?.api_value ?: 0
        bauxite = entity?.api_data?.api_material?.get(3)?.api_value ?: 0
        burner = entity?.api_data?.api_material?.get(4)?.api_value ?: 0
        bucket = entity?.api_data?.api_material?.get(5)?.api_value ?: 0
        research = entity?.api_data?.api_material?.get(6)?.api_value ?: 0
        improve = entity?.api_data?.api_material?.get(7)?.api_value ?: 0

        nickname = entity?.api_data?.api_basic?.api_nickname ?: ""
        level = entity?.api_data?.api_basic?.api_level ?: 0
        shipCount = entity?.api_data?.api_ship?.size ?: 0
        shipMax = entity?.api_data?.api_basic?.api_max_chara ?: 0
        slotCount = EquipManager.getEquipCount()
        slotMax = entity?.api_data?.api_basic?.api_max_slotitem ?: 0
        kDockCount = entity?.api_data?.api_basic?.api_count_kdock ?: 0
        nDockCount = entity?.api_data?.api_basic?.api_count_ndock ?: 0
        deckCount = entity?.api_data?.api_basic?.api_count_deck ?: 0
    }
}