package cn.cctech.kccommand

import android.app.Application
import com.orhanobut.logger.LogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class KccApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(object : LogAdapter {

            private val formatStrategy = PrettyFormatStrategy.newBuilder().tag("CC").build()

            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }

            override fun log(priority: Int, tag: String?, message: String?) {
                formatStrategy.log(priority, tag, message)
            }
        })
    }

}
