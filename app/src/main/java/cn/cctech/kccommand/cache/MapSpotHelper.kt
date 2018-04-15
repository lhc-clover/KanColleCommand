package cn.cctech.kccommand.cache

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import cn.cctech.kccommand.R
import cn.cctech.kccommand.entities.MapSpot
import cn.cctech.kccommand.utils.*
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class MapSpotHelper private constructor(context: Context) {

    private val mapInfoFile = "map.json"
    private var mapSpot = MapSpot()

    init {
        val stringBuilder = StringBuilder()
        val assetManager = context.assets
        try {
            val bufferedReader = BufferedReader(InputStreamReader(
                    assetManager.open(mapInfoFile), "utf-8"))
            var line = bufferedReader.readLine()
            while (line != null) {
                stringBuilder.append(line)
                line = bufferedReader.readLine()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        mapSpot = parse(stringBuilder.toString())
    }

    private fun parse(data: String): MapSpot {
        return Gson().fromJson(data, MapSpot::class.java)
    }

    fun getSpotMarker(area: Int, map: Int, route: Int): List<String> {
        return try {
            val mapData = mapSpot.data?.get("$area-$map")
            mapData?.route?.get("$route")!!
        } catch (e: Exception) {
            listOf("null", "null")
        }
    }

    fun getSpotRotate(area: Int, map: Int, next: Int): Double {
        return try {
            val mapData = mapSpot.data?.get("$area-$map")
            val route = mapData?.route?.get("$next")
            val currentSpot = mapData?.spots?.get(route?.getOrElse(0, { -1 }))
            val xCurr = currentSpot?.getOrElse(0, { 0 })
            val yCurr = currentSpot?.getOrElse(1, { 0 })
            val nextSpot = mapData?.spots?.get(route?.getOrElse(1, { -1 }))
            val xNext = nextSpot?.getOrElse(0, { 0 })
            val yNext = nextSpot?.getOrElse(1, { 0 })
            ((Math.atan2(yNext as Double - yCurr as Double, xNext as Double - xCurr as Double) / Math.PI) * 180)
        } catch (e: Exception) {
            0.0
        }
    }

    companion object {

        @Volatile
        private var instance: MapSpotHelper? = null

        fun getInstance(context: Context): MapSpotHelper {
            val i = instance
            if (i != null) {
                return i
            }
            return synchronized(this) {
                val i2 = instance
                if (i2 != null) {
                    i2
                } else {
                    val created = MapSpotHelper(context)
                    instance = created
                    created
                }
            }
        }

    }

}

fun getSpotColor(context: Context, type: Int): Int {
    val color = when (type) {
        ObtainRes -> R.color.spotObtainRes
        LoseRes -> R.color.spotLoseRes
        BattleSpot -> R.color.spotBattle
        BossBattle -> R.color.spotBoss
        BattleAvoid -> R.color.spotBattleAvoid
        AirStrike -> R.color.spotAirStrike
        EscortSuccess -> R.color.spotEscortSuccess
        TransportMunitions -> R.color.spotTransportMunitions
        LongDistanceAerialBattle -> R.color.spotLongDistanceAerialBattle
        ManualSelection -> R.color.spotManualSelection
        NightBattle -> R.color.spotNightBattle
        EnemyCombinedFleet -> R.color.spotEnemyCombinedFleet
        else -> R.color.spotDefault
    }
    return ResourcesCompat.getColor(context.resources, color, context.theme)
}