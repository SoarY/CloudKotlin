package com.soar.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseLazyFragment
import com.soar.cloud.databinding.FragmentFriendsBinding
import com.soar.cloud.databinding.HeaderItemDouBinding
import com.soar.cloud.util.ToastUtils
import com.soar.cloud.view.LoadingView
import com.soar.cloud.vm.FriendsViewModel

/**
 * NAME：YONG_
 * Created at: 2023/4/6 13
 * Describe:
 */
class FriendsFragment :BaseLazyFragment<FragmentFriendsBinding, FriendsViewModel>(){

    companion object{
        fun newInstance() : FriendsFragment{
            return FriendsFragment()
        }
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_friends
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        val mHeaderBinding = DataBindingUtil.inflate<HeaderItemDouBinding>(LayoutInflater.from(context), R.layout.header_item_dou, null, false)
        mViewModel.headerAdapter.addHeaderView(mHeaderBinding.root)

        mHeaderBinding.llMovieTop.setOnClickListener { ToastUtils.showToast("TOP")}
        mViewModel.adapter.setItemClickListener{ ToastUtils.showToast(it.toString() + "")}
    }

    override fun lazyData() {
        mViewModel.viewState(1,LoadingView.State.ing)
        mViewModel.getHotMovie()
    }
}