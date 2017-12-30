package cn.cctech.kccommand.utils

import android.text.TextUtils
import cn.cctech.kccommand.events.JsonEvent
import cn.cctech.kccommand.events.api.*
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import java.util.*

object Dispatcher {

    private val sPairMap = HashMap<String, Class<out JsonEvent>>()

    init {
        sPairMap.put("/kcsapi/api_start2", Start::class.java)
        sPairMap.put("/kcsapi/api_port/port", Port::class.java)
        sPairMap.put("/kcsapi/api_get_member/require_info", RequireInfo::class.java)

        sPairMap.put("/kcsapi/api_get_member/mapinfo", MapInfo::class.java)
        sPairMap.put("/kcsapi/api_get_member/deck", Deck::class.java)
        sPairMap.put("/kcsapi/api_req_hokyu/charge", Charge::class.java)
        sPairMap.put("/kcsapi/api_get_member/ship3", Ship3::class.java)
        sPairMap.put("/kcsapi/api_req_kaisou/slot_exchange_index", SlotExchangeIndex::class.java)
        sPairMap.put("/kcsapi/api_get_member/kdock", Kdock::class.java)
        sPairMap.put("/kcsapi/api_get_member/ndock", Ndock::class.java)
        sPairMap.put("/kcsapi/api_req_kousyou/getship", GetShip::class.java)
        sPairMap.put("/kcsapi/api_req_hensei/change", Change::class.java)
        sPairMap.put("/kcsapi/api_get_member/material", Material::class.java)
        sPairMap.put("/kcsapi/api_req_nyukyo/speedchange", SpeedChange::class.java)

        sPairMap.put("/kcsapi/api_req_map/start", BattleStart::class.java)
        sPairMap.put("/kcsapi/api_req_map/next", Next::class.java)
        sPairMap.put("/kcsapi/api_req_sortie/battle", Battle::class.java)
        sPairMap.put("/kcsapi/api_req_battle_midnight/battle", BattleNight::class.java)
        sPairMap.put("/kcsapi/api_req_sortie/battleresult", BattleResult::class.java)
        sPairMap.put("/kcsapi/api_req_practice/battle", Practice::class.java)
        sPairMap.put("/kcsapi/api_req_practice/midnight_battle", PracticeNight::class.java)
        sPairMap.put("/kcsapi/api_req_practice/battle_result", PracticeResult::class.java)
    }

    fun dispatch(url: String, requestBody: ByteArray, responseBody: ByteArray) {
        try {
            if (url.contains("kcsapi")) {
                val params = String(requestBody)
                Logger.d("Url:\n" + url)
                Logger.d("Params:\n" + params)
                Logger.d("Body:\n" + String(responseBody))
                val key = findMatchedKey(sPairMap, url)
                if (!TextUtils.isEmpty(key)) {
                    val value = sPairMap[key]
                    val jsonEvent = Gson().fromJson(parseContent(responseBody), value) as JsonEvent
                    jsonEvent.requestBody = params
                    jsonEvent.dispatch()
                }
            }
        } catch (e: Exception) {
            Logger.e(e, e.message)
        }

    }

    private fun findMatchedKey(map: HashMap<String, *>, url: String): String? {
        return map.keys.firstOrNull { url == it }
    }

    private fun parseContent(content: ByteArray): String {
        val result: String
        val tmp = String(content)
        result = tmp.replaceFirst("svdata=".toRegex(), "")
        return result
    }

}
