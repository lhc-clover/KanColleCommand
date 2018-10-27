package cn.cctech.kccommand.utils

import android.content.Context
import android.net.Uri
import cn.cctech.kccommand.cache.ACache
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream


fun getCachePath(context: Context): String {
    return (context.externalCacheDir?.absolutePath
            ?: context.cacheDir.absolutePath) + "/KanColleCache"
}

private fun getCacheFilePath(cacheDir: String, path: String): String = cacheDir + path

private fun getCacheConfig(cacheDir: String): ACache = ACache.get(File(cacheDir, "CacheConfig"))

fun shouldCache(uri: Uri): Boolean {
    val path = uri.path.orEmpty()
    return if (path.startsWith("/kcs/", true) || path.startsWith("/kcs2/", true)) {
        path.endsWith("js", true) ||
                path.endsWith("json", true) ||
                path.endsWith("mp3", true) ||
                path.endsWith("png", true)
    } else false
}

fun getCachedFile(cacheDir: String, uri: Uri): String? {
    val path = uri.path.orEmpty()
    val localVersion = getCacheConfig(cacheDir).getAsString(path)
    val remoteVersion = uri.getQueryParameter("version").orEmpty()
    return if (remoteVersion.equals(localVersion, true)) {
        getCacheFilePath(cacheDir, path)
    } else {
        File(cacheDir + path).delete()
        ""
    }
}

fun caching(client: OkHttpClient, cacheDir: String, webRequest: WebResourceRequest): String? {
    return try {
        val request = Request.Builder()
                .url(webRequest.url.toString())
                .headers(Headers.of(webRequest.requestHeaders))
                .get()
                .build()
        val response = client.newCall(request).execute()
        val cacheFilePath = getCacheFilePath(cacheDir, webRequest.url.path ?: "")
        val cacheFile = File(cacheFilePath)
        if (!cacheFile.exists()) {
            cacheFile.parentFile.mkdirs()
            cacheFile.createNewFile()
        }
        response.body()?.byteStream()?.let {
            val buffer = ByteArray(2048)
            var len = 0
            val fos = FileOutputStream(cacheFilePath)
            while (it.read(buffer).apply { len = this } > 0) {
                fos.write(buffer, 0, len)
            }
            it.close()
            fos.flush()
            fos.close()
        }
        val version = webRequest.url.getQueryParameter("version") ?: ""
        val path = webRequest.url.path ?: ""
        getCacheConfig(cacheDir).put(path, version)
        cacheFilePath
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}
