package com.soar.cloud.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.soar.cloud.MyApplication
import com.soar.cloud.R
import com.soar.cloud.adapter.WelfareAdapter
import com.soar.cloud.base.BaseViewModel
import com.soar.cloud.bean.GankIoDataBean
import com.soar.cloud.constants.APPConstant
import com.soar.cloud.constants.ConstantsImageUrl
import com.soar.cloud.retrofit.*
import com.soar.cloud.view.LoadingView
import io.reactivex.Observable

/**
 * NAME：YONG_
 * Created at: 2023/4/3 17
 * Describe:
 */
class WelfareViewModel(application:Application):BaseViewModel(application){

    private var pageIndex = APPConstant.pageIndex
    private val pageSize = APPConstant.pageSize

    var stopRefresh: ObservableBoolean = ObservableBoolean()

    var adapter = WelfareAdapter()

    var datas: ArrayList<GankIoDataBean.ResultBean> = ArrayList()

    fun getGankIoData(isRefreshOrLoad: Boolean) {
//        val observable = RetrofitClient.getApi()!!.getGankIoData("Girl","Girl", pageIndex, pageSize)
//            .map {
//                if (it.isError!=0)
//                    throw ServerException(ExceptionEngine.ERROR.DEFAULT_ERROR, "isError")
//                it
//            }
//            .onErrorResumeNext(HttpResultFunc())

        val observable = Observable.create<GankIoDataBean> {
            val gankIoDataBean = GankIoDataBean()

            val arrayList = ArrayList<GankIoDataBean.ResultBean>()
            for (i in 0 until 20) {
                val resultBean = GankIoDataBean.ResultBean()
                resultBean.url = ConstantsImageUrl.HOME_SIX_18
                arrayList.add(resultBean)
            }

            gankIoDataBean.results = arrayList

            it.onNext(gankIoDataBean)
        }
        RetrofitClient.toSubscribe(getLifecycleProvider(),observable,object :MyObserver<GankIoDataBean>(){
            override fun onError(ex: APIException) {
                viewState(1,LoadingView.State.error)
            }

            override fun onNext(t: GankIoDataBean) {
                if (pretreatment(t, isRefreshOrLoad)) return
                val results: ArrayList<GankIoDataBean.ResultBean>? = t.results
                if (results!=null)
                    datas.addAll(results)
                adapter.setData(datas)
            }

        })
    }

    /**
     * 界面预处理
     */
    private fun pretreatment(data: GankIoDataBean?, isRefreshOrLoad: Boolean): Boolean {
        stopRefresh.set(!stopRefresh.get())
        viewState(0, LoadingView.State.done)
        if (isRefreshOrLoad) {
            datas.clear()
            adapter.setData(datas)
        }
        if (data == null || data.results == null || data.results!!.isEmpty()) {
            uiLiveData.toastEvent.show(MyApplication.context.getResources().getString(R.string.to_loaded))
            return true
        }
        return false
    }

    /**
     * 上拉加载
     */
    var onLoadMore = OnLoadMoreListener { refreshLayout: RefreshLayout? ->
        pageIndex++
        getGankIoData(false)
    }

}