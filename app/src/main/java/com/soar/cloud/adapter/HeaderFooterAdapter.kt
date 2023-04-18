package com.soar.cloud.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import androidx.recyclerview.widget.StaggeredGridLayoutManager


/**
 * NAME：YONG_
 * Created at: 2023/3/29 10
 * Describe: 装饰者模式的头尾Adapter
 */
class HeaderFooterAdapter : Adapter<ViewHolder> {

    var mHeaderView:View? = null
    var mFooterView:View? = null
    var adapter: Adapter<ViewHolder>

    companion object{
        val TYPE_HEADER=1000
        val TYPE_FOOTER=1002
    }

    constructor(adapter: Adapter<ViewHolder>) {
        this.adapter = adapter
        adapter.registerAdapterDataObserver(mObserver)
    }

    fun addHeaderView(headerView: View) {
        mHeaderView = headerView
        notifyItemInserted(0)
    }

    fun addFooterView(footerView: View) {
        mFooterView = footerView
        notifyItemInserted(itemCount - 1)
    }

    private fun isHeaderView(position: Int): Boolean {
        return mHeaderView != null && position == 0
    }

    private fun isFooterView(position: Int): Boolean {
        return mFooterView != null && position == itemCount - 1
    }

    fun getRealPosition(position: Int): Int {
        var mPosition = position
        if (mHeaderView != null) mPosition--
        return mPosition
    }

    override fun getItemCount(): Int {
        var count = adapter.itemCount
        if (mHeaderView != null) count++
        if (mFooterView != null) count++
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHeaderView(position)) TYPE_HEADER else if (isFooterView(position)) TYPE_FOOTER else adapter.getItemViewType(
            getRealPosition(position)
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == TYPE_FOOTER) HeadFootHolder(mFooterView)
        else if (viewType == TYPE_HEADER) HeadFootHolder(mHeaderView)
        else adapter.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewType = getItemViewType(position)

        if (viewType == TYPE_HEADER) {
            //TEXT
        } else if (viewType == TYPE_FOOTER) {
            //TEXT
        } else {
            adapter.onBindViewHolder(holder, getRealPosition(position))
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is GridLayoutManager) (layoutManager as GridLayoutManager?)?.setSpanSizeLookup(
            object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (isHeaderView(position) || isFooterView(position)) (layoutManager as GridLayoutManager?)!!.getSpanCount() else 1
                }
            })
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)
        val lp = holder.itemView.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams
            && (isHeaderView(holder.layoutPosition) || isFooterView(holder.layoutPosition))
        ) (lp as StaggeredGridLayoutManager.LayoutParams).setFullSpan(true)
    }

    private val mObserver=object: AdapterDataObserver() {
        override fun onChanged() {
            notifyDataSetChanged()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            notifyItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            notifyItemRangeChanged(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            notifyItemRangeChanged(positionStart, itemCount, payload)
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            notifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            notifyItemMoved(fromPosition, toPosition)
        }
    }

    class HeadFootHolder(view: View?) : RecyclerView.ViewHolder(view!!)
}