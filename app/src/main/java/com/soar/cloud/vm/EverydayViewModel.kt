package com.soar.cloud.vm

import android.app.Application
import android.os.Handler
import android.text.TextUtils
import androidx.databinding.ObservableField
import com.soar.cloud.adapter.EverydayAdapter
import com.soar.cloud.adapter.HeaderFooterAdapter
import com.soar.cloud.base.BaseViewModel
import com.soar.cloud.bean.AndroidBean
import com.soar.cloud.bean.GankIoDayBean
import com.soar.cloud.constants.ConstantsImageUrl
import com.soar.cloud.retrofit.APIException
import com.soar.cloud.retrofit.ExceptionEngine
import com.soar.cloud.retrofit.MyObserver
import com.soar.cloud.retrofit.RetrofitClient
import com.soar.cloud.util.SPUtils
import com.soar.cloud.view.LoadingView
import io.reactivex.Observable
import java.util.*

/**
 * NAME：YONG_
 * Created at: 2023/3/31 1
 * Describe:
 */
class EverydayViewModel (application: Application) : BaseViewModel(application) {

    var bannerDatas: ObservableField<List<Any>> = ObservableField()

    var adapter: EverydayAdapter = EverydayAdapter()
    var headerAdapter: HeaderFooterAdapter = HeaderFooterAdapter(adapter)

    fun getBannerData() {
        val bannerUrls = ConstantsImageUrl.HOME_BANNER_URLS
        Handler().postDelayed({
            bannerDatas.set(
                Arrays.asList(
                    bannerUrls[0],
                    bannerUrls[1],
                    bannerUrls[2],
                    bannerUrls[3]
                )
            )
        }, 3000)
    }

    fun getGankIoDay() {
//        val observable: Observable<ArrayList<List<AndroidBean>>> =
//            RetrofitClient.getApi()!!.getGankIoDay("2016", "11", "24")!!
//                .map { datas ->
//                    if (datas.isError)
//                        throw ServerException(ExceptionEngine.ERROR.DEFAULT_ERROR, "isError")
//                    val dataResult: GankIoDayBean.ResultsBean? = datas.results
//                    val lists: ArrayList<List<AndroidBean>> = ArrayList<List<AndroidBean>>()
//                    analogData(lists, dataResult!!)
//                    lists
//                }
//                .onErrorResumeNext(HttpResultFunc())

        val observable: Observable<ArrayList<List<AndroidBean>>> = Observable.create<ArrayList<List<AndroidBean>>> {
            val resultsBean = GankIoDayBean.ResultsBean()

            val android: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val iOS: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val front: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val app: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val restMovie: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val resource: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val recommend: ArrayList<AndroidBean> = ArrayList<AndroidBean>()
            val welfare: ArrayList<AndroidBean> = ArrayList<AndroidBean>()

            val androidBean = AndroidBean()
            for (i in 0 until 2) {
                welfare.add(androidBean)
            }
            for (i in 0 until 3) {
                android.add(androidBean)
            }
            for (i in 0 until 3) {
                iOS.add(androidBean)
            }
            for (i in 0 until 4) {
                front.add(androidBean)
            }
            for (i in 0 until 5) {
                app.add(androidBean)
            }
            for (i in 0 until 6) {
                restMovie.add(androidBean)
            }
            for (i in 0 until 7) {
                resource.add(androidBean)
            }
            for (i in 0 until 1) {
                recommend.add(androidBean)
            }



            resultsBean.android=android
            resultsBean.iOS=iOS
            resultsBean.front=front
            resultsBean.app=app
            resultsBean.restMovie=restMovie
            resultsBean.resource=resource
            resultsBean.recommend=recommend
            resultsBean.welfare=welfare

            val lists: ArrayList<List<AndroidBean>> = ArrayList<List<AndroidBean>>()
            analogData(lists, resultsBean)
            it.onNext(lists)
        }

        RetrofitClient.toSubscribe(getLifecycleProvider(),observable,object :MyObserver<ArrayList<List<AndroidBean>>>(){
            override fun onError(ex: APIException) {
                if (ex.code === ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.displayMessage)
                viewState(1, LoadingView.State.error)
            }

            override fun onNext(t: ArrayList<List<AndroidBean>>) {
                adapter.setData(t)
                viewState(0, LoadingView.State.done)
            }

        })
    }

    /**
     * 以下都是模拟数据,不用细看。
     */
    private fun analogData(lists: ArrayList<List<AndroidBean>>, results: GankIoDayBean.ResultsBean) {
        if (results.android != null && results.android!!.size > 0) {
            addUrlList(lists, results.android!!, "Android")
        }
        if (results.welfare != null && results.welfare!!.size > 0) {
            addUrlList(lists, results.welfare!!, "福利")
        }
        if (results.iOS != null && results.iOS!!.size > 0) {
            addUrlList(lists, results.iOS!!, "IOS")
        }
        if (results.restMovie != null && results.restMovie!!.size > 0) {
            addUrlList(lists, results.restMovie!!, "休息视频")
        }
        if (results.resource != null && results.resource!!.size > 0) {
            addUrlList(lists, results.resource!!, "拓展资源")
        }
        if (results.recommend != null && results.recommend!!.size > 0) {
            addUrlList(lists, results.recommend!!, "瞎推荐")
        }
        if (results.front != null && results.front!!.size > 0) {
            addUrlList(lists, results.front!!, "前端")
        }
        if (results.app != null && results.app!!.size > 0) {
            addUrlList(lists, results.app!!, "App")
        }
    }

    // subList没有实现序列化！缓存时会出错！
    private fun addUrlList(
        lists: ArrayList<List<AndroidBean>>,
        arrayList: List<AndroidBean>,
        typeTitle: String
    ) {
        // title
        val bean = AndroidBean()
        bean.type_title=typeTitle
        val androidBeen = java.util.ArrayList<AndroidBean>()
        androidBeen.add(bean)
        lists.add(androidBeen)
        val androidSize = arrayList.size
        if (androidSize > 0 && androidSize < 4) {
            lists.add(addUrlList(arrayList, androidSize))
        } else if (androidSize >= 4) {
            val list1 = java.util.ArrayList<AndroidBean>()
            val list2 = java.util.ArrayList<AndroidBean>()
            for (i in 0 until androidSize) {
                if (i < 3) {
                    list1.add(getAndroidBean(arrayList, i, androidSize))
                } else if (i < 6) {
                    list2.add(getAndroidBean(arrayList, i, androidSize))
                }
            }
            lists.add(list1)
            lists.add(list2)
        }
    }

    private fun addUrlList(arrayList: List<AndroidBean>, androidSize: Int): List<AndroidBean> {
        val tempList: MutableList<AndroidBean> = java.util.ArrayList()
        for (i in 0 until androidSize) {
            val androidBean = AndroidBean()
            // 标题
            androidBean.desc=arrayList[i].desc
            // 类型
            androidBean.type=arrayList[i].type
            // 跳转链接
            androidBean.url=arrayList[i].url
            //            DebugUtil.error("---androidSize:  " + androidSize);
            // 随机图的url
            if (androidSize == 1) {
                androidBean.image_url=ConstantsImageUrl.HOME_ONE_URLS.get(getRandom(1)) //一图
            } else if (androidSize == 2) {
                androidBean.image_url=ConstantsImageUrl.HOME_TWO_URLS.get(getRandom(2)) //两图
            } else if (androidSize == 3) {
                androidBean.image_url=ConstantsImageUrl.HOME_SIX_URLS.get(getRandom(3)) //三图
            }
            tempList.add(androidBean)
        }
        return tempList
    }

    private fun getAndroidBean(
        arrayList: List<AndroidBean>,
        i: Int,
        androidSize: Int
    ): AndroidBean {
        val androidBean = AndroidBean()
        // 标题
        androidBean.desc=arrayList[i].desc
        // 类型
        androidBean.type=arrayList[i].type
        // 跳转链接
        androidBean.url=arrayList[i].url
        // 随机图的url
        if (i < 3) {
            androidBean.image_url=ConstantsImageUrl.HOME_SIX_URLS.get(getRandom(3)) //三小图
        } else if (androidSize == 4) {
            androidBean.image_url=ConstantsImageUrl.HOME_ONE_URLS.get(getRandom(1)) //一图
        } else if (androidSize == 5 ) {
            androidBean.image_url=ConstantsImageUrl.HOME_TWO_URLS.get(getRandom(2)) //两图
        } else if (androidSize >= 6) {
            androidBean.image_url=ConstantsImageUrl.HOME_SIX_URLS.get(getRandom(3)) //三小图
        }
        return androidBean
    }

    /**
     * 取不同的随机图，在每次网络请求时重置
     */
    private fun getRandom(type: Int): Int {
        var saveWhere: String? = null
        var urlLength = 0
        if (type == 1) {
            saveWhere = SPUtils.SPkey.HOME_ONE
            urlLength = ConstantsImageUrl.HOME_ONE_URLS.size
        } else if (type == 2) {
            saveWhere = SPUtils.SPkey.HOME_TWO
            urlLength = ConstantsImageUrl.HOME_TWO_URLS.size
        } else if (type == 3) {
            saveWhere = SPUtils.SPkey.HOME_SIX
            urlLength = ConstantsImageUrl.HOME_SIX_URLS.size
        }
        val homeSix: String? = SPUtils.getString(saveWhere?:"", "")
        if (!TextUtils.isEmpty(homeSix)) {
            // 已取到的值
            val split = homeSix?.split(",".toRegex())?.dropLastWhile { it.isEmpty() }
                ?.toTypedArray()
            val random = Random()
            for (j in 0 until urlLength) {
                val randomInt = random.nextInt(urlLength)
                var isUse = false
                if (split != null) {
                    for (aSplit in split) {
                        if (!TextUtils.isEmpty(aSplit) && randomInt.toString() == aSplit) {
                            isUse = true
                            break
                        }
                    }
                }
                if (!isUse) {
                    val sb = StringBuilder(homeSix)
                    sb.insert(0, "$randomInt,")
                    SPUtils.putString(saveWhere, sb.toString())
                    return randomInt
                }
            }
        } else {
            val random = Random()
            val randomInt = random.nextInt(urlLength)
            SPUtils.putString(saveWhere, "$randomInt,")
            return randomInt
        }
        return 0
    }
}