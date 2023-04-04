package com.soarsy.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseLazyFragment
import com.soarsy.cloud.databinding.FooterItemEverydayBinding
import com.soarsy.cloud.databinding.FragmentEverydayBinding
import com.soarsy.cloud.databinding.HeaderItemEverydayBinding
import com.soarsy.cloud.util.ToastUtils
import com.soarsy.cloud.view.GlideImageLoader
import com.soarsy.cloud.view.LoadingView
import com.soarsy.cloud.vm.EverydayViewModel

/**
 * NAME：YONG_
 * Created at: 2023/3/31 15
 * Describe:
 */
class EverydayFragment : BaseLazyFragment<FragmentEverydayBinding, EverydayViewModel>(){

    private lateinit var mHeaderBinding : HeaderItemEverydayBinding

    companion object{
        val DELAY_TIME: Int=3000

        fun newInstance():EverydayFragment{
            return EverydayFragment()
        }
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_everyday
    }

    override fun onStart() {
        super.onStart()
        mHeaderBinding.banner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        mHeaderBinding.banner.stopAutoPlay()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        mHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.header_item_everyday, null, false)
        mHeaderBinding.setVariable(BR.vm, mViewModel)
        mHeaderBinding.banner.setImageLoader(GlideImageLoader())
            .setDelayTime(DELAY_TIME)

        mHeaderBinding.banner.setOnBannerListener { ToastUtils.showToast(it.toString() + "")}
        mHeaderBinding.includeEveryday.ibDried.setOnClickListener{ToastUtils.showToast("干货")}
        mHeaderBinding.includeEveryday.ibDailyDay.setOnClickListener{ToastUtils.showToast("推荐")}
        mHeaderBinding.includeEveryday.ibAndroidPlay.setOnClickListener{ToastUtils.showToast("玩安卓")}
        mHeaderBinding.includeEveryday.ibMovieHot.setOnClickListener{ToastUtils.showToast("热映")}

        val mFooterBinding: FooterItemEverydayBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.footer_item_everyday, null, false)

        mViewModel.headerAdapter.addHeaderView(mHeaderBinding.root)
        mViewModel.headerAdapter.addFooterView(mFooterBinding.root)

        mViewModel.adapter.setItemClickListener{ ToastUtils.showToast(it.toString() + "")}
    }

    override fun lazyData() {
        mViewModel.viewState(1, LoadingView.State.ing)
        mViewModel.getBannerData()
        mViewModel.getGankIoDay()
    }
}