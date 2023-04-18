package com.soar.cloud.adapter

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.soar.cloud.R
import com.soar.cloud.databinding.ItemPageImageBinding
import com.soar.cloud.util.ToastUtils

/**
 * NAME：YONG_
 * Created at: 2023/4/6 15
 * Describe:
 */
class ImageAdapter :PagerAdapter(){

    var mContext:Activity?=null
    var imageUrls:List<String>?=null

    fun setData(imageUrls: List<String>?) {
        this.imageUrls = imageUrls
        notifyDataSetChanged()
    }

    fun setContext(context: Activity) {
        this.mContext = context
    }

    override fun getCount(): Int {
        return if (imageUrls == null) 0 else imageUrls!!.size
    }

    fun getItem(position: Int): String? {
        return if (imageUrls == null) null else imageUrls!![position]
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = getItem(position)
        val binding: ItemPageImageBinding = DataBindingUtil.inflate(LayoutInflater.from(container.context), R.layout.item_page_image, container, true)
        Glide.with(container.context).load(item).listener(object : RequestListener<Drawable>{
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                binding.loading.visibility = View.GONE
                ToastUtils.showToast("资源加载异常")
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                binding.loading.visibility = View.GONE
                return false
            }
        }).into(binding.ivImage)
        binding.ivImage.setOnPhotoTapListener { view, x, y -> mContext!!.finish() }
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


}