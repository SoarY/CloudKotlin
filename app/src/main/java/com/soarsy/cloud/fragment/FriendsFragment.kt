package com.soarsy.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseLazyFragment
import com.soarsy.cloud.databinding.FragmentFriendsBinding
import com.soarsy.cloud.databinding.HeaderItemDouBinding
import com.soarsy.cloud.util.ToastUtils
import com.soarsy.cloud.view.LoadingView
import com.soarsy.cloud.vm.FriendsViewModel

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