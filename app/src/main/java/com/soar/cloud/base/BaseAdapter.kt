package com.soar.cloud.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * NAME：YONG_
 * Created at: 2023/3/29 11
 * Describe:
 */
abstract class BaseAdapter<T, B : ViewDataBinding>: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

 var datas:List<T>?=null
 var mItemClickListener:ItemClickListener?=null

 protected abstract fun initLayoutId(): Int

 protected abstract fun onBindView(holder: RecyclerHolder<B>?, t: T?, position: Int)

 fun setData(datas: List<T>?) {
  this.datas = datas
  notifyDataSetChanged()
 }

 fun getItem(position: Int): T? {
  return if (datas == null) null else datas!![position]
 }

 override fun getItemCount(): Int {
  return if (datas == null) 0 else datas!!.size
 }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
  val binding: B =
   DataBindingUtil.inflate(LayoutInflater.from(parent.context), initLayoutId(), parent, false)
    ?: throw java.lang.RuntimeException("DataBinding Root layout must by <layout/>")
  return RecyclerHolder(binding)
 }

 override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
  val bindHolder = holder as RecyclerHolder<B>
  onBindView(bindHolder, getItem(position), position)
  if (mItemClickListener != null)
   holder.itemView.setOnClickListener {mItemClickListener!!.onItemClick(position) }
  bindHolder.binding.executePendingBindings()
 }

 fun interface ItemClickListener {
  fun onItemClick(position: Int)
 }

 fun setItemClickListener(itemClickListener: ItemClickListener) {
  this.mItemClickListener = itemClickListener
 }

 class RecyclerHolder<BD : ViewDataBinding?>(var binding: BD) : RecyclerView.ViewHolder(binding!!.root)

}