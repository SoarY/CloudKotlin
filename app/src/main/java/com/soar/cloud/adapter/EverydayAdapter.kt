package com.soar.cloud.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.soar.cloud.R
import com.soar.cloud.bean.AndroidBean
import com.soar.cloud.databinding.ItemEverydayOneBinding
import com.soar.cloud.databinding.ItemEverydayThreeBinding
import com.soar.cloud.databinding.ItemEverydayTitleBinding
import com.soar.cloud.databinding.ItemEverydayTwoBinding

/**
 * NAME：YONG_
 * Created at: 2019/1/7
 * Describe:
 */
class EverydayAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas: List<List<AndroidBean>>? = null

    private var itemClickListener: ItemClickListener? = null

    fun setData(datas: List<List<AndroidBean>>?) {
        this.datas = datas
        notifyDataSetChanged()
    }

    fun getItem(position: Int): List<AndroidBean>? {
        return if (datas == null) null else datas!![position]
    }

    override fun getItemCount(): Int {
        return if (datas == null) 0 else datas!!.size
    }

    override fun getItemViewType(position: Int): Int {
        if (!TextUtils.isEmpty(datas!![position][0].type_title))
            return TYPE_TITLE
        else if (datas!![position].size == 1)
            return TYPE_ONE
        else if (datas!![position].size == 2)
            return TYPE_TWO
        else if (datas!![position].size == 3)
            return TYPE_THREE
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TITLE -> TitleHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_everyday_title,
                    parent,
                    false
                )
            )
            TYPE_ONE -> OneHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_everyday_one,
                    parent,
                    false
                )
            )
            TYPE_TWO -> TwoHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_everyday_two,
                    parent,
                    false
                )
            )
            else -> ThreeHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_everyday_three,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when (viewType) {
            TYPE_TITLE -> bindTitleHolder(holder as TitleHolder, position)
            TYPE_ONE -> bindOneHolder(holder as OneHolder, position)
            TYPE_TWO -> bindTwoHolder(holder as TwoHolder, position)
            else -> bindThreeHolder(holder as ThreeHolder, position)
        }
        if (itemClickListener != null)
            holder.itemView.setOnClickListener {itemClickListener!!.onItemClick(position) }
    }

    private fun bindTitleHolder(holder: TitleHolder, position: Int) {
        val title = getItem(position)!![0].type_title
        holder.binding.tvTitleType.text = title
        holder.binding.viewLine.visibility = if (position != 0) View.VISIBLE else View.GONE
        holder.binding.executePendingBindings()
    }

    private fun bindOneHolder(holder: OneHolder, position: Int) {
        val item = getItem(position)
        val options = RequestOptions()
            .placeholder(R.mipmap.ic_item_one)
            .error(R.mipmap.ic_item_one)
        Glide.with(holder.binding.ivOnePhoto.context)
            .load(item!![0].image_url)
            .apply(options)
            .into(holder.binding.ivOnePhoto)
        holder.binding.tvOnePhotoTitle.text = item[0].desc
        holder.binding.executePendingBindings()
    }

    private fun bindTwoHolder(holder: TwoHolder, position: Int) {
        val item = getItem(position)
        val options = RequestOptions()
            .placeholder(R.mipmap.ic_item_one)
            .error(R.mipmap.ic_item_one)
        Glide.with(holder.binding.ivTwoOneOne.context)
            .load(item!![0].image_url)
            .apply(options)
            .into(holder.binding.ivTwoOneOne)
        Glide.with(holder.binding.ivTwoOneTwo.context)
            .load(item[1].image_url)
            .apply(options)
            .into(holder.binding.ivTwoOneTwo)
        holder.binding.tvTwoOneOneTitle.text = item[0].desc
        holder.binding.tvTwoOneTwoTitle.text = item[1].desc
        holder.binding.executePendingBindings()
    }

    private fun bindThreeHolder(holder: ThreeHolder, position: Int) {
        val item = getItem(position)
        val options = RequestOptions()
            .placeholder(R.mipmap.ic_item_one)
            .error(R.mipmap.ic_item_one)
        Glide.with(holder.binding.ivThreeOneOne.context)
            .load(item!![0].image_url)
            .apply(options)
            .into(holder.binding.ivThreeOneOne)
        Glide.with(holder.binding.ivThreeOneTwo.context)
            .load(item[1].image_url)
            .apply(options)
            .into(holder.binding.ivThreeOneTwo)
        Glide.with(holder.binding.ivThreeOneThree.context)
            .load(item[2].image_url)
            .apply(options)
            .into(holder.binding.ivThreeOneThree)
        holder.binding.tvThreeOneOneTitle.text = item[0].desc
        holder.binding.tvThreeOneTwoTitle.text = item[1].desc
        holder.binding.tvThreeOneThreeTitle.text = item[2].desc
        holder.binding.executePendingBindings()
    }

    fun interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener?) {
        this.itemClickListener = itemClickListener
    }

    inner class TitleHolder(var binding: ItemEverydayTitleBinding) : RecyclerView.ViewHolder(binding.root)

    inner class OneHolder(var binding: ItemEverydayOneBinding) : RecyclerView.ViewHolder(binding.root)

    inner class TwoHolder(var binding: ItemEverydayTwoBinding) : RecyclerView.ViewHolder(binding.root)

    inner class ThreeHolder(var binding: ItemEverydayThreeBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        //Type
        private const val TYPE_TITLE = 1 // Title
        private const val TYPE_ONE = 2 // 一张图
        private const val TYPE_TWO = 3 // 二张图
        private const val TYPE_THREE = 4 // 三张图
    }
}