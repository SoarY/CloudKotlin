package com.soar.cloud.adapter

import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseAdapter
import com.soar.cloud.bean.NaviBean
import com.soar.cloud.databinding.ItemNaviBinding

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