package com.soarsy.cloud.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.soarsy.cloud.MyApplication
import com.soarsy.cloud.R
import com.soarsy.cloud.adapter.AndroidPlayAdapter
import com.soarsy.cloud.adapter.HeaderFooterAdapter
import com.soarsy.cloud.base.BaseViewModel
import com.soarsy.cloud.bean.AndroidPlayBannerBean
import com.soarsy.cloud.bean.ArticlesBean
import com.soarsy.cloud.bean.DataBean
import com.soarsy.cloud.constants.APPConstant
import com.soarsy.cloud.retrofit.*
import com.soarsy.cloud.view.LoadingView
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.stream.Collectors

/**
 * NAME：YONG_
 * Created at: 2023/3/28 11
 * Describe:
 */
class AndroidPlayViewModel(application: Application) : BaseViewModel(application) {

    private var page: Int = APPConstant.page

    private var cid: Int? = null

    private var totalCount = 0

    var datas: ArrayList<ArticlesBean> = ArrayList()

    var adapter: AndroidPlayAdapter = AndroidPlayAdapter()
    var headerAdapter: HeaderFooterAdapter = HeaderFooterAdapter(adapter)

    var stopRefresh: ObservableBoolean = ObservableBoolean()

    var bannerUrlDatas: ObservableField<List<String>> = ObservableField()
    var bannerTitleDatas: ObservableField<List<String>> = ObservableField()

    fun setCID(cid: Int?) {
        this.cid = cid
    }

    fun getBannerData() {
        val observable: Observable<List<AndroidPlayBannerBean>> =
            RetrofitClient.getApi(APIMain.API_PLAY_ANDROID)!!.getAndroidPlayBanner()
                .map(ServerResultFunc())
                .onErrorResumeNext(HttpResultFunc())
        RetrofitClient.toSubscribe(getLifecycleProvider(), observable,object :MyObserver<List<AndroidPlayBannerBean>>(){

            override fun onSubscribe(d: Disposable) {
                super.onSubscribe(d)
            }

            override fun onError(ex: APIException) {
            }

            override fun onNext(data: List<AndroidPlayBannerBean>) {
                val titles = data.stream().map(AndroidPlayBannerBean::title).collect(Collectors.toList()) as List<String>
                val urls = data.stream().map(AndroidPlayBannerBean::imagePath).collect(Collectors.toList()) as List<String>
                bannerTitleDatas.set(titles)
                bannerUrlDatas.set(urls)
            }

            override fun onComplete() {
                super.onComplete()
            }
        })
    }

    fun getHomeList(isRefreshOrLoad:Boolean){
        val observable = RetrofitClient.getApi(APIMain.API_PLAY_ANDROID)!!.getHomeList(page, cid)
                .map(ServerResultFunc())
                .onErrorResumeNext(HttpResultFunc())
        RetrofitClient.toSubscribe(getLifecycleProvider(), observable,object :MyObserver<DataBean>(){
            override fun onError(ex: APIException) {
                if (ex.code == ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.displayMessage)
                viewState(1, LoadingView.State.error)
            }

            override fun onNext(t: DataBean) {
                if (pretreatment(t, isRefreshOrLoad)) return
                //数据操作
                totalCount = t.total
                if (t.datas!=null)
                    datas.addAll(t.datas!!)
                adapter.setData(datas)
            }
        })
    }

    /**
     * 界面预处理
     */
    private fun pretreatment(data: DataBean, isRefreshOrLoad: Boolean): Boolean {
        stopRefresh.set(!stopRefresh.get())
        viewState(0, LoadingView.State.done)
        if (isRefreshOrLoad) {
            datas.clear()
            adapter.setData(datas)
        }
        return if (data.datas == null || data.datas!!.size == 0) true else false
    }

    /**
     * 下拉刷新
     */
    var onRefresh = OnRefreshListener { refreshLayout: RefreshLayout? ->
        page = APPConstant.page
        getHomeList(true)
        getBannerData()
    }

    /**
     * 上拉加载
     */
    var onLoadMore = OnLoadMoreListener { refreshLayout: RefreshLayout? ->
        if (datas.size >= totalCount) {
            uiLiveData.toastEvent.show(MyApplication.context.getResources().getString(R.string.to_loaded))
            stopRefresh.set(!stopRefresh.get())
            return@OnLoadMoreListener
        }
        page++
        getHomeList(false)
    }
}