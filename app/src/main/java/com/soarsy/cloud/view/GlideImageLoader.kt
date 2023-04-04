package com.soarsy.cloud.view

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.soarsy.cloud.R
import com.youth.banner.loader.ImageLoader

/**
 * NAME：YONG_
 * Created at: 2023/3/29 10
 * Describe:
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        Glide.with(context).load(path)
            .apply(RequestOptions().placeholder(R.mipmap.ic_item_one).error(R.mipmap.ic_item_one))
            .into(imageView)
    }
}