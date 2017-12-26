package cn.cctech.kccommand.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews

/**
 * 通知栏消息-基于[NotificationCompat.Builder]
 * Created by JTech on 2017/1/11.
 */
@Suppress("MemberVisibilityCanPrivate")
object JNotify {

    val REQUEST_CODE_NOTIFY = 818
    private val DEFAULT_LIGHT_COLOR = -0x10000
    private val DEFAULT_LIGHT_ON = 350
    private val DEFAULT_LIGHT_OFF = 300
    private val DEFAULT_VIBRATE_ON = 200
    private val DEFAULT_VIBRATE_OFF = 100

    private val DEFAULT_CHANNEL_ID = "cctech.poi"

    /**
     * 开始构造
     *
     * @param context
     * @return
     */
    fun build(context: Context): NotifyBuilder {
        return NotifyBuilder(context)
    }

    /**
     * 构建通知栏消息
     */
    class NotifyBuilder(private val context: Context, private val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)) {
        private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        fun setAutoCancel(autoCancel: Boolean): NotifyBuilder {
            builder.setAutoCancel(autoCancel)
            return this
        }

        fun setOngoing(ongoing: Boolean): NotifyBuilder {
            builder.setOngoing(ongoing)
            return this
        }

        fun setOnlyAlertOnce(onlyAlertOnce: Boolean): NotifyBuilder {
            builder.setOnlyAlertOnce(onlyAlertOnce)
            return this
        }

        fun setNumber(number: Int): NotifyBuilder {
            builder.setNumber(number)
            return this
        }

        fun setTicker(tickerText: String): NotifyBuilder {
            builder.setTicker(tickerText)
            return this
        }

        fun setContentTitle(title: String): NotifyBuilder {
            builder.setContentTitle(title)
            return this
        }

        fun setContentText(text: String): NotifyBuilder {
            builder.setContentText(text)
            return this
        }

        fun setContentInfo(info: String): NotifyBuilder {
            builder.setContentInfo(info)
            return this
        }

        fun setContent(views: RemoteViews): NotifyBuilder {
            builder.setContent(views)
            return this
        }

        fun setCustomBigContentView(contentView: RemoteViews): NotifyBuilder {
            builder.setCustomBigContentView(contentView)
            return this
        }

        fun setCustomContentView(contentView: RemoteViews): NotifyBuilder {
            builder.setCustomContentView(contentView)
            return this
        }

        fun setCustomHeadsUpContentView(contentView: RemoteViews): NotifyBuilder {
            builder.setCustomHeadsUpContentView(contentView)
            return this
        }

        fun setSmallIcon(icon: Int): NotifyBuilder {
            builder.setSmallIcon(icon)
            return this
        }

        fun setLargeIcon(icon: Bitmap): NotifyBuilder {
            builder.setLargeIcon(icon)
            return this
        }

        fun setProgress(max: Int, progress: Int, indeterminate: Boolean): NotifyBuilder {
            builder.setProgress(max, progress, indeterminate)
            return this
        }

        fun setDefaultSound(): NotifyBuilder {
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            return this
        }

        fun setSound(ringUri: Uri): NotifyBuilder {
            builder.setSound(ringUri)
            return this
        }

        fun setDefaultLight(): NotifyBuilder {
            setLight(DEFAULT_LIGHT_COLOR, DEFAULT_LIGHT_ON, DEFAULT_LIGHT_OFF)
            return this
        }

        fun setLight(@ColorInt argb: Int, onMs: Int, offMs: Int): NotifyBuilder {
            builder.setLights(argb, onMs, offMs)
            return this
        }

        fun setDefaultVibrate(): NotifyBuilder {
            setVibrate(longArrayOf(DEFAULT_VIBRATE_ON.toLong(), DEFAULT_VIBRATE_OFF.toLong(), DEFAULT_VIBRATE_ON.toLong(), DEFAULT_VIBRATE_OFF.toLong()))
            return this
        }

        fun setVibrate(pattern: LongArray): NotifyBuilder {
            builder.setVibrate(pattern)
            return this
        }

        fun setContentIntent(intent: Intent, flags: Int = PendingIntent.FLAG_UPDATE_CURRENT): NotifyBuilder {
            return setContentIntent(REQUEST_CODE_NOTIFY, intent, flags, null)
        }

        fun setContentIntents(intents: Array<Intent>, flags: Int = PendingIntent.FLAG_UPDATE_CURRENT): NotifyBuilder {
            return setContentIntents(REQUEST_CODE_NOTIFY, intents, flags, null)
        }

        fun setContentIntent(requestCode: Int, intent: Intent, flags: Int, options: Bundle?): NotifyBuilder {
            return setContentIntent(PendingIntent.getActivity(context, requestCode, intent, flags, options))
        }

        fun setContentIntents(requestCode: Int, intents: Array<Intent>, flags: Int, options: Bundle?): NotifyBuilder {
            return setContentIntent(PendingIntent.getActivities(context, requestCode, intents, flags, options))
        }

        fun setContentIntent(pendingIntent: PendingIntent): NotifyBuilder {
            builder.setContentIntent(pendingIntent)
            return this
        }

        fun cancel(id: Int) {
            notificationManager.cancel(id)
        }

        fun cancel(tag: String?, id: Int) {
            notificationManager.cancel(tag, id)
        }

        fun cancelAll() {
            notificationManager.cancelAll()
        }

        fun notify(id: Int) {
            notificationManager.notify(id, builder.build())
        }

        fun notify(tag: String, id: Int) {
            notificationManager.notify(tag, id, builder.build())
        }
    }
}
