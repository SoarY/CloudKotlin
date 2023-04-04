package com.soarsy.cloud.util

import com.soarsy.cloud.MyApplication
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * NAME：YONG_
 * Created at: 2019/1/7
 * Describe:
 */
object CommonUtils {

    /**
     * MD5加密
     */
    fun MD5(key: String): String {
        val cacheKey: String
        cacheKey = try {
            val mDigest = MessageDigest.getInstance("MD5")
            mDigest.update(key.toByteArray())
            bytesToHexString(mDigest.digest())
        } catch (e: NoSuchAlgorithmException) {
            key.hashCode().toString()
        }
        return cacheKey
    }

    /**
     * http://stackoverflow.com/questions/332079
     */
    fun bytesToHexString(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (i in bytes.indices) {
            val hex = Integer.toHexString(0xFF and bytes[i].toInt())
            if (hex.length == 1) {
                sb.append('0')
            }
            sb.append(hex)
        }
        return sb.toString()
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(dpValue: Float): Int {
        val scale: Float = MyApplication.context.getResources().getDisplayMetrics().density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 向上取偶
     */
    fun takeEven(value: Int): Int {
        return if (value % 2 != 0) value + 1 else value
    }
}