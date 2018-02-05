package cn.cctech.kccommand.entities

class MapSpot {

    var meta: Any? = null
    var data: Map<String, MapData>? = null

    class MapData {
        var route: Map<String, List<String>>? = null
        var spots: Map<String, List<Any>>? = null
    }
}
