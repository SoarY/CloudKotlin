package com.soar.cloud.adapter

import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseAdapter
import com.soar.cloud.bean.GankIoDataBean
import com.soar.cloud.databinding.ItemWelfareBinding

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