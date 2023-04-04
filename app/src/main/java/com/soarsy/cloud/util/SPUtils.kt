package com.soarsy.cloud.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.soarsy.cloud.MyApplication

object SPUtils {

    /**
     * 应用名默认SP  context.getPackageName() + "_preferences"
     */
    private val sharedPreferences: SharedPreferences
        private get() = PreferenceManager.getDefaultSharedPreferences(MyApplication.context)

    /**
     * 用户自定义SP文件名
     */
    private fun getSharedPreferences(spName: String): SharedPreferences {
        return MyApplication.context.getSharedPreferences(spName, Context.MODE_PRIVATE)
    }

    /**
     * 清除SP
     */
    fun clearSP() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun clearSP(spName: String) {
        val editor = getSharedPreferences(spName).edit()
        editor.clear()
        editor.apply()
    }

    /**
     * putString
     */
    fun putString(key: String?, value: String?) {
        val sp = sharedPreferences
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putString(spName: String, key: String?, value: String?) {
        val sp = getSharedPreferences(spName)
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * getString
     */
    fun getString(key: String?): String? {
        val sp = sharedPreferences
        return sp.getString(key, null)
    }

    fun getString(spName: String, key: String?): String? {
        val sp = getSharedPreferences(spName)
        return sp.getString(key, null)
    }

    /**
     * putBoolean
     */
    fun putBoolean(key: String?, value: Boolean) {
        val sp = sharedPreferences
        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun putBoolean(spName: String, key: String?, value: Boolean) {
        val sp = getSharedPreferences(spName)
        val editor = sp.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * getBoolean
     */
    fun getBoolean(key: String?): Boolean {
        val sp = sharedPreferences
        return sp.getBoolean(key, false)
    }

    fun getBoolean(spName: String, key: String?): Boolean {
        val sp = getSharedPreferences(spName)
        return sp.getBoolean(key, false)
    }

    /**
     * SPConstant
     */
    object SPkey {
        const val TOKEN = "TOKEN"
        const val HOME_ONE = "home_one"
        const val HOME_TWO = "home_two"
        const val HOME_SIX = "home_six"
    }
}