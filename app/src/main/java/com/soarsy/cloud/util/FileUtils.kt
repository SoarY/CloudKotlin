package com.soarsy.cloud.util

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * NAME：YONG_
 * Created at: 2023/4/6 16
 * Describe:
 */
object FileUtils {
    /**
     * 复制文件
     *
     * @param source 输入文件
     * @param target 输出文件
     */
    fun copy(source: File?, target: File?) {
        var fileInputStream: FileInputStream? = null
        var fileOutputStream: FileOutputStream? = null
        try {
            fileInputStream = FileInputStream(source)
            fileOutputStream = FileOutputStream(target)
            val buffer = ByteArray(1024)
            while (fileInputStream.read(buffer) > 0) fileOutputStream.write(buffer)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                fileInputStream!!.close()
                fileOutputStream!!.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}