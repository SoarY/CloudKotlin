package com.soarsy.cloud.activity

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.soarsy.cloud.R
import com.soarsy.cloud.adapter.BottomPagerAdapter
import com.soarsy.cloud.base.BaseActivity
import com.soarsy.cloud.base.BaseViewModel
import com.soarsy.cloud.constants.RouteConstants
import com.soarsy.cloud.databinding.ActivityMainBinding
import com.soarsy.cloud.databinding.LayoutNavigationHeaderBinding
import com.soarsy.cloud.fragment.DiscoverFragment
import com.soarsy.cloud.fragment.MusicFragment
import com.soarsy.cloud.util.ToastUtils


@Route(path = RouteConstants.Rule.MAIN_ACTIVITY)
class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView(){
        mDinding.layToolbarMain.flTitleMenu.setOnClickListener {mDinding.drawerLayout.openDrawer(GravityCompat.START)}
        mDinding.layToolbarMain.ivTitleSearch.setOnClickListener { ToastUtils.showToast("Search") }

        val headerView: View = mDinding.navigationView.getHeaderView(0)
        val headBind: LayoutNavigationHeaderBinding? = DataBindingUtil.bind(headerView)

        headBind!!.llNavHomepage.setOnClickListener(listener)
        headBind!!.llNavScanDownload.setOnClickListener(listener)
        headBind!!.llNavDeedback.setOnClickListener(listener)
        headBind!!.llNavAbout.setOnClickListener(listener)
        headBind!!.llNavLogin.setOnClickListener(listener)
        headBind!!.llNavCollect.setOnClickListener(listener)
        headBind!!.llNavExit.setOnClickListener(listener)

        val bottomPagerAdapter = BottomPagerAdapter(supportFragmentManager)
        bottomPagerAdapter.addFragment(MusicFragment.newInstance())
        bottomPagerAdapter.addFragment(DiscoverFragment.newInstance())
        bottomPagerAdapter.addFragment(MusicFragment.newInstance())
        mDinding.viewPager.setOffscreenPageLimit(3)
        mDinding.viewPager.setAdapter(bottomPagerAdapter)

        mDinding.viewPager.addOnPageChangeListener(onPageChangeListener)
        mDinding.layToolbarMain.navigationTool.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)
    }

    private val listener = View.OnClickListener { v: View ->
        mDinding.drawerLayout.closeDrawer(GravityCompat.START)
        when (v.id) {
            R.id.ll_nav_homepage -> ToastUtils.showToast("主页")
            R.id.ll_nav_scan_download -> ToastUtils.showToast("扫码下载")
            R.id.ll_nav_deedback -> ToastUtils.showToast("问题反馈")
            R.id.ll_nav_about -> ToastUtils.showToast("关于云阅")
            R.id.ll_nav_collect -> ToastUtils.showToast("玩安卓收藏")
            R.id.ll_nav_login -> ToastUtils.showToast("玩安卓登录")
            R.id.ll_nav_exit -> ToastUtils.showToast("退出应用")
        }
    }

    private val onPageChangeListener= object : OnPageChangeListener{
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            mDinding.layToolbarMain.navigationTool.menu.getItem(position).isChecked = true
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.getItemId()) {
            R.id.item_music -> {
                mDinding.viewPager.setCurrentItem(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.item_discover -> {
                mDinding.viewPager.setCurrentItem(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.item_friends -> {
                mDinding.viewPager.setCurrentItem(2)
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                return@OnNavigationItemSelectedListener false
            }
        }
    }
}