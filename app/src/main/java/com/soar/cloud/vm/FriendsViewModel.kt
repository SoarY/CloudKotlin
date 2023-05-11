package com.soar.cloud.vm

import android.app.Application
import com.soar.cloud.adapter.FriendsAdapter
import com.soar.cloud.adapter.HeaderFooterAdapter
import com.soar.cloud.base.BaseViewModel
import com.soar.cloud.bean.HotMovieBean
import com.soar.cloud.bean.ImagesBean
import com.soar.cloud.bean.SubjectsBean
import com.soar.cloud.retrofit.*
import com.soar.cloud.view.LoadingView
import io.reactivex.Observable

/**
 * NAME：YONG_
 * Created at: 2023/4/6 13
 * Describe:
 */
class FriendsViewModel(application : Application) : BaseViewModel(application){

    val adapter= FriendsAdapter()
    val headerAdapter= HeaderFooterAdapter(adapter)

    fun getHotMovie(){
//        val observable = RetrofitClient.getApi(APIMain.API_DOUBAN)!!.getHotMovie()
//            .onErrorResumeNext(HttpResultFunc())

        val observable = Observable.create<HotMovieBean> {
            val imagesBean = ImagesBean()
            imagesBean.large="https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2378133884.jpg"

            val subjectsBean = SubjectsBean()
            subjectsBean.title="I'm not Pan Jinlian"
            subjectsBean.images=imagesBean

            val arrayList = ArrayList<SubjectsBean>()
            for (i in 0 until 5){
                arrayList.add(subjectsBean)
            }

            val hotMovieBean = HotMovieBean()
            hotMovieBean.subjects=arrayList

            it.onNext(hotMovieBean)
        }
        RetrofitClient.toSubscribe(getLifecycleProvider(),observable,object :MyObserver<HotMovieBean>(){
            override fun onError(ex: APIException) {
                if (ex.code === ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.displayMessage)
                viewState(1,LoadingView.State.error)
            }

            override fun onNext(t: HotMovieBean) {
                if (t.subjects!=null)
                    adapter.setData(t.subjects)
                viewState(0,LoadingView.State.done)
            }

        })
    }
}