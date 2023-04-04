package com.soarsy.cloud.activity

import android.os.Bundle
import android.os.Handler
import com.alibaba.android.arouter.launcher.ARouter
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseActivity
import com.soarsy.cloud.base.BaseViewModel
import com.soarsy.cloud.constants.RouteConstants
import com.soarsy.cloud.databinding.ActivitySplashBinding

/**
 * NAME：YONG_
 * Created at: 2023/3/23 14
 * Describe:
 */
class SplashActivity : BaseActivity<ActivitySplashBinding, BaseViewModel>(){

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_splash
    }

    override fun initVariableId(): Int {
        return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
    }

    private fun initView() {
        Handler().postDelayed({
            ARouter.getInstance()
                .build(RouteConstants.Rule.MAIN_ACTIVITY)
                .withTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out)
                .navigation(this)
            finish()
        }, DELAY_MILLIS)
    }

    companion object {
        val DELAY_MILLIS=3000L
    }
}