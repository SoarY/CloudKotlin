package com.soarsy.cloud.adapter

import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseAdapter
import com.soarsy.cloud.bean.GankIoDataBean
import com.soarsy.cloud.databinding.ItemWelfareBinding

/**
 * NAME：YONG_
 * Created at: 2023/4/3 17
 * Describe:
 */
class WelfareAdapter : BaseAdapter<GankIoDataBean.ResultBean, ItemWelfareBinding>(){

    override fun initLayoutId(): Int {
        return R.layout.item_welfare
    }

    override fun onBindView(holder: RecyclerHolder<ItemWelfareBinding>?, t: GankIoDataBean.ResultBean?, position: Int) {
        holder!!.binding.setVariable(BR.item, t)
    }
}