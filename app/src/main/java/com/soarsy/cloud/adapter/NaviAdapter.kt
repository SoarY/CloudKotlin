package com.soarsy.cloud.adapter

import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseAdapter
import com.soarsy.cloud.bean.NaviBean
import com.soarsy.cloud.databinding.ItemNaviBinding

/**
 * NAME：YONG_
 * Created at: 2023/3/31 11
 * Describe:
 */
class NaviAdapter :BaseAdapter<NaviBean, ItemNaviBinding>(){

    override fun initLayoutId(): Int {
        return R.layout.item_navi
    }

    override fun onBindView(holder: RecyclerHolder<ItemNaviBinding>?, t: NaviBean?, position: Int) {
        holder!!.binding.setVariable(BR.item, t)
        holder!!.binding.tvTitle.isSelected = t!!.selected
        holder!!.binding.tvTitle.setOnClickListener { v ->
            setSelected(position)
            if (listener != null)
                listener!!.onSelected(position)
        }
    }

    fun setSelected(position: Int) {
        for (i in 0 until datas!!.size)
            datas!![i].selected = i == position
        notifyDataSetChanged()
    }

    private var listener: OnSelectListener? = null

    fun setOnSelectListener(listener: OnSelectListener?) {
        this.listener = listener
    }

    fun interface OnSelectListener {
        fun onSelected(position: Int)
    }
}