package com.soar.cloud

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

/**
 * NAME：YONG_
 * Created at: 2023/3/22 15
 * Describe:
 */
class MyApplication : Application(){

    private lateinit var instance:Application

    companion object{
        lateinit var context: Context
        lateinit var instance:Application
    }


    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        instance = this
        context = getApplicationContext()

        //if (BuildConfig.DEBUG)
            //ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openLog()     // 打印日志
        ARouter.init(instance) // 尽可能早，推荐在Application中初始化
    }


}