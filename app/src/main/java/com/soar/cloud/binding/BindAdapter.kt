package com.soar.cloud.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ViewSwitcher
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.soar.cloud.view.LoadingView
import com.youth.banner.Banner

/**
 * NAME：YONG_
 * Created at: 2023/3/28 10
 * Describe:
 */
@BindingAdapter("onPageChangeListener")
fun addOnPageChangeListener(view: ViewPager, listener: ViewPager.OnPageChangeListener?) {
    view.addOnPageChangeListener(listener!!)
}

@BindingAdapter("onRefreshListener")
fun setOnRefreshListener(view: SmartRefreshLayout, listener: OnRefreshListener?) {
    view.setOnRefreshListener(listener)
}

@BindingAdapter("onLoadMoreListener")
fun setOnLoadMoreListener(view: SmartRefreshLayout, listener: OnLoadMoreListener?) {
    view.setOnLoadMoreListener(listener)
}

@BindingAdapter("stopRefresh")
fun setStopRefresh(view: SmartRefreshLayout, stopRefresh: Boolean) {
    view.finishRefresh()
    view.finishLoadMore()
}

@BindingAdapter("viewSwitcher")
fun setViewSwitcher(view: ViewSwitcher, whichChild: Int) {
    view.displayedChild = whichChild
}

@BindingAdapter("loadState")
fun setLoadState(view: LoadingView, state: LoadingView.State?) {
    view.notifyDataChanged(state)
}

@BindingAdapter(value = ["bannerData", "bannerTitle"], requireAll = false)
fun setBannerData(view: Banner, datas: List<*>?, titles: List<String?>?) {
    if (titles != null) view.setBannerTitles(titles)
    if (datas != null && datas.size > 0) view.setImages(datas).start()
}

@BindingAdapter(value = ["imgSource", "placeholder", "errorholder"], requireAll = false)
fun setImgSource(
    view: ImageView,
    imgSource: String?,
    placeholder: Drawable?,
    errorholder: Drawable?
) {
    val options = RequestOptions()
        .placeholder(placeholder)
        .error(errorholder)
    Glide.with(view.context)
        .load(imgSource)
        .apply(options)
        .into(view)
}