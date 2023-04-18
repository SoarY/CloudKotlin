package com.soar.cloud.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soar.cloud.R
import com.soar.cloud.adapter.MePagerAdapter
import com.soar.cloud.base.BaseLazyFragment
import com.soar.cloud.base.BaseViewModel
import com.soar.cloud.databinding.FragmentMusicBinding

/**
 * NAME：YONG_
 * Created at: 2023/3/25 11
 * Describe:
 */
class MusicFragment : BaseLazyFragment<FragmentMusicBinding, BaseViewModel>(){

    companion object{
        fun newInstance():MusicFragment{
            return MusicFragment()
        }
    }

    override fun initVariableId(): Int {
        return 0
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_music
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initView()
        return view
    }

    private fun initView() {
        val pagerAdapter = MePagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(getString(R.string.android),AndroidPlayFragment.newInstance())
        pagerAdapter.addFragment(getString(R.string.navi),NaviFragment.newInstance())

        mDinding.viewPager.setOffscreenPageLimit(2)
        mDinding.viewPager.setAdapter(pagerAdapter)
        mDinding.tabLayout.setupWithViewPager(mDinding.viewPager)
    }

    override fun lazyData() {
    }
}