package cn.cctech.kccommand.entities

import android.databinding.ObservableField
import android.databinding.ObservableInt
import cn.cctech.kancolle.oyodo.Oyodo
import cn.cctech.kancolle.oyodo.managers.Resource
import cn.cctech.kancolle.oyodo.managers.User

class Info {

    var fuel: ObservableInt = ObservableInt(0) //油
    var ammo: ObservableInt = ObservableInt(0) //弹
    var metal: ObservableInt = ObservableInt(0) //钢
    var bauxite: ObservableInt = ObservableInt(0) //铝
    var bucket: ObservableInt = ObservableInt(0) //桶
    var burner: ObservableInt = ObservableInt(0) //喷火
    var research: ObservableInt = ObservableInt(0) //紫菜
    var improve: ObservableInt = ObservableInt(0) //螺丝

    var nickname: ObservableField<String> = ObservableField() //昵称
    var level: ObservableInt = ObservableInt(0) //等级
    var shipCount: ObservableInt = ObservableInt(0) //拥有舰娘
    var shipMax: ObservableInt = ObservableInt(0) //最大舰娘
    var slotCount: ObservableInt = ObservableInt(0) //拥有装备
    var slotMax: ObservableInt = ObservableInt(0) //最大装备
    var kDockCount: ObservableInt = ObservableInt(0) //开放建造池
    var nDockCount: ObservableInt = ObservableInt(0) //开放维修池
    var deckCount: ObservableInt = ObservableInt(0) //开放舰队

    constructor() {
        Oyodo.attention().watch(Resource.fuel, { fuel.set(it) })
        Oyodo.attention().watch(Resource.ammo, { ammo.set(it) })
        Oyodo.attention().watch(Resource.metal, { metal.set(it) })
        Oyodo.attention().watch(Resource.bauxite, { bauxite.set(it) })
        Oyodo.attention().watch(Resource.bucket, { bucket.set(it) })
        Oyodo.attention().watch(Resource.burner, { burner.set(it) })
        Oyodo.attention().watch(Resource.research, { research.set(it) })
        Oyodo.attention().watch(Resource.improve, { improve.set(it) })

        Oyodo.attention().watch(User.nickname, { nickname.set(it) })
        Oyodo.attention().watch(User.level, { level.set(it) })
        Oyodo.attention().watch(User.shipCount, { shipCount.set(it) })
        Oyodo.attention().watch(User.shipMax, { shipMax.set(it) })
        Oyodo.attention().watch(User.slotCount, { slotCount.set(it) })
        Oyodo.attention().watch(User.slotMax, { slotMax.set(it) })
        Oyodo.attention().watch(User.kDockCount, { kDockCount.set(it) })
        Oyodo.attention().watch(User.nDockCount, { nDockCount.set(it) })
        Oyodo.attention().watch(User.deckCount, { deckCount.set(it) })
    }

}
