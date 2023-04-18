package com.soar.cloud.util


import android.content.Context
import android.net.ConnectivityManager
import com.soar.cloud.MyApplication

/**
 * NAME：YONG_
 * Created at: 2023/3/29 15
 * Describe:
 */
object NetworkUtils {
    /**
     * 判断网络是否连通
     */
    fun isNetworkConnected(): Boolean {
        try {
            val cm = MyApplication.context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = cm.activeNetworkInfo
            return info != null && info.isConnected
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}