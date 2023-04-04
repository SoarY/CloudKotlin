package com.soarsy.cloud.retrofit

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * NAME：YONG_
 * Created at: 2023/3/29 14
 * Describe:
 */
object RetrofitClient {

    private val apis: HashMap<String, API> = HashMap<String, API>()


    fun getApi(): API? {
        return getApi(APIMain.API_GANKIO)
    }

    fun getApi(urlMain: String?): API? {
        if (!apis.containsKey(urlMain)) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(urlMain)
                .build()
            val api = retrofit.create(API::class.java)
            apis[urlMain!!] = api
        }
        return apis[urlMain]
    }

    /**
     * 订阅
     */
    fun <T> toSubscribe(
        lifecycle: LifecycleProvider<ActivityEvent>?,
        o: Observable<T>,
        s: Observer<T>?
    ) {
        o.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycle!!.bindUntilEvent(ActivityEvent.DESTROY))
            .subscribe(s!!)
    }
}