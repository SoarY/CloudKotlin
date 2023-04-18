package com.soar.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.activity.ImageActivity
import com.soar.cloud.base.BaseLazyFragment
import com.soar.cloud.constants.RouteConstants
import com.soar.cloud.databinding.FragmentWelfareBinding
import com.soar.cloud.util.CommonUtils
import com.soar.cloud.view.GridSpacingItemDecoration
import com.soar.cloud.view.LoadingView
import com.soar.cloud.vm.WelfareViewModel
import kotlin.streams.toList

/**
 * NAME：YONG_
 * Created at: 2023/4/3 17
 * Describe:
 */
class WelfareFragment : BaseLazyFragment<FragmentWelfareBinding, WelfareViewModel>(){

    companion object{
        fun newInstance():WelfareFragment{
            return WelfareFragment()
        }
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_welfare
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        mDinding.recyclerView.setLayoutManager(GridLayoutManager(context,2))

        /**
         * 下拉刷新成功后显示会闪一下
         * CommonUtils.takeEven
         * 取偶设置上下左右边距是一样的话，系统就会复用，就消除了图片不能复用 闪跳的情况
         */
        mDinding.recyclerView.addItemDecoration(GridSpacingItemDecoration(2, CommonUtils.takeEven(CommonUtils.dip2px(4f))))

        mViewModel.adapter.setItemClickListener{
            ARouter.getInstance()
                .build(RouteConstants.Discover.WELFARE_IMG)
                .withInt(ImageActivity.POSITION, it)
                .withStringArrayList(ImageActivity.IMAGE_URLS,mViewModel.datas.stream().map { it.url }.toList() as ArrayList<String>)
                .navigation()
        }
    }

    override fun lazyData() {
        mViewModel.viewState(1, LoadingView.State.ing)
        mViewModel.getGankIoData(true)
    }
}