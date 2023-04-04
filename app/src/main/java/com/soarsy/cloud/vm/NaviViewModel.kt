package com.soarsy.cloud.vm

import android.app.Application
import com.soarsy.cloud.adapter.NaviAdapter
import com.soarsy.cloud.adapter.NaviContentAdapter
import com.soarsy.cloud.base.BaseViewModel
import com.soarsy.cloud.bean.NaviBean
import com.soarsy.cloud.retrofit.*
import com.soarsy.cloud.view.LoadingView
import io.reactivex.Observable

/**
 * NAME：YONG_
 * Created at: 2023/3/31 11
 * Describe:
 */
class NaviViewModel(application: Application) : BaseViewModel(application) {

    var adapter = NaviAdapter()

    var naviContentAdapter: NaviContentAdapter = NaviContentAdapter()

    fun getNaviJson(){
        val observable: Observable<List<NaviBean>> =
            RetrofitClient.getApi(APIMain.API_PLAY_ANDROID)!!.getNaviJson()!!
                .map(ServerResultFunc())
                .onErrorResumeNext(HttpResultFunc())
        RetrofitClient.toSubscribe(getLifecycleProvider(),observable,object : MyObserver<List<NaviBean>>(){
            override fun onError(ex: APIException) {
                if (ex.code === ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.displayMessage)
            }

            override fun onNext(t: List<NaviBean>) {
                adapter.setData(t)
                naviContentAdapter.setData(t)
                viewState(0, LoadingView.State.done)
            }

        })
    }

}