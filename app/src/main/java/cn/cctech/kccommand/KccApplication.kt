package cn.cctech.kccommand

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.github.megatronking.svg.sample.drawables.SVGLoader
import com.orhanobut.logger.LogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.pgyersdk.crash.PgyCrashManager


class KccApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        PgyCrashManager.register(this)
        Logger.addLogAdapter(object : LogAdapter {

            private val formatStrategy = PrettyFormatStrategy.newBuilder().tag("CC").build()

            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }

            override fun log(priority: Int, tag: String?, message: String?) {
                formatStrategy.log(priority, tag, message)
            }
        })
        SVGLoader.load(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
