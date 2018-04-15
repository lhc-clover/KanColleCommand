package cn.cctech.kccommand.utils

import cn.cctech.kancolle.oyodo.Oyodo
import com.orhanobut.logger.Logger

object Dispatcher {

    fun dispatch(url: String, requestBody: ByteArray, responseBody: ByteArray) {
        try {
            if (url.contains("kcsapi")) {
                Oyodo.attention().api(url, requestBody, responseBody)
            }
        } catch (e: Exception) {
            Logger.e(e, e.message)
        }

    }

}
