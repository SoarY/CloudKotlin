package com.soarsy.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseAdapter
import com.soarsy.cloud.base.BaseLazyFragment
import com.soarsy.cloud.databinding.FragmentAndroidPlayBinding
import com.soarsy.cloud.databinding.HeaderAndroidPalyBinding
import com.soarsy.cloud.util.ToastUtils
import com.soarsy.cloud.view.GlideImageLoader
import com.soarsy.cloud.view.LoadingView
import com.soarsy.cloud.vm.AndroidPlayViewModel
import com.youth.banner.BannerConfig

/**
 * NAME：YONG_
 * Created at: 2023/3/25 14
 * Describe:
 */
class AndroidPlayFragment : BaseLazyFragment<FragmentAndroidPlayBinding, AndroidPlayViewModel>(){

    private lateinit var mHeaderBinding :HeaderAndroidPalyBinding

    companion object{
        val DELAY_TIME: Int=3000

        fun newInstance():AndroidPlayFragment{
            return AndroidPlayFragment()
        }
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun initContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int {
        return R.layout.fragment_android_play
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater!!, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        mDinding.materialHeaderView.setColorSchemeResources(R.color.colorAccent)

        mHeaderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(getContext()),
            R.layout.header_android_paly,
            null,
            false
        )
        mHeaderBinding.setVariable(BR.vm, mViewModel)
        mHeaderBinding.banner.setImageLoader(GlideImageLoader())
            .setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
            .setDelayTime(DELAY_TIME)

        mHeaderBinding.banner.setOnBannerListener { ToastUtils.showToast(it.toString() + "") }
        mHeaderBinding.ivBannerOne.setOnClickListener {ToastUtils.showToast("BannerOne") }
        mHeaderBinding.ivBannerTwo.setOnClickListener {ToastUtils.showToast("BannerTwo") }

        mViewModel.headerAdapter.addHeaderView(mHeaderBinding.root)
        mViewModel.adapter.setItemClickListener(object :BaseAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                ToastUtils.showToast(position.toString() + "")
            }
        })
    }


    override fun lazyData() {
        mViewModel.viewState(1, LoadingView.State.ing)
        mViewModel.getBannerData()
        mViewModel.getHomeList(true)
    }
}