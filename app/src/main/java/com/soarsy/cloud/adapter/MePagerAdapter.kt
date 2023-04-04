package com.soarsy.cloud.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * NAME：YONG_
 * Created at: 2023/3/25 14
 * Describe:
 */
class MePagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private val mTitleList: ArrayList<String> = ArrayList()

    fun addFragment(title: String?, fragment: Fragment?) {
        mTitleList.add(title!!)
        mFragmentList.add(fragment!!)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }
}