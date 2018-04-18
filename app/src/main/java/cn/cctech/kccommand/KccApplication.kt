package cn.cctech.kccommand

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.github.megatronking.svg.sample.drawables.SVGLoader
import com.orhanobut.logger.LogAdapter
import com.orhanobut.logger.LogStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.pgyersdk.crash.PgyCrashManager

class KccApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        PgyCrashManager.register(this)
        Logger.addLogAdapter(object : LogAdapter {

            private val formatStrategy = PrettyFormatStrategy.newBuilder()
                    .tag("CC")
                    .logStrategy(LogCatStrategy())
                    .build()

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

private class LogCatStrategy : LogStrategy {

    private var last: Int = 0

    override fun log(priority: Int, tag: String, message: String) {
        Log.println(priority, randomKey() + tag, message)
    }

    private fun randomKey(): String {
        var random = (10 * Math.random()).toInt()
        if (random == last) {
            random = (random + 1) % 10
        }
        last = random
        return random.toString()
    }
}
