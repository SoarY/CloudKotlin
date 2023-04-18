package com.soar.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseLazyFragment
import com.soar.cloud.databinding.FragmentNaviBinding
import com.soar.cloud.view.LoadingView
import com.soar.cloud.vm.NaviViewModel

/**
 * NAME：YONG_
 * Created at: 2023/3/31 11
 * Describe:
 */
class NaviFragment : BaseLazyFragment<FragmentNaviBinding, NaviViewModel>(){

    companion object{
        fun newInstance():NaviFragment{
            return NaviFragment()
        }
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_navi
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        mViewModel.adapter.setOnSelectListener{
            (mDinding.xrvNaviDetail.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(it, 0)
        }
        mDinding.loadingView.setOnRetryListener{lazyData()}
    }

    override fun lazyData() {
        mViewModel.viewState(1, LoadingView.State.ing)
        mViewModel.getNaviJson()
    }
}