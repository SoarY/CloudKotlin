package com.soar.cloud.bean


import java.io.Serializable
import java.util.ArrayList

/**
 * Created by jingbin on 2016/11/24.
 */
class GankIoDayBean : Serializable {
    val isError = false
    val results: ResultsBean? = null
    val category: List<String>? = null

    class ResultsBean {
        /**
         * _id : 56cc6d23421aa95caa707a69
         * createdAt : 2015-08-06T07:15:52.65Z
         * desc : 类似Link Bubble的悬浮式操作设计
         * images : ["http://img.gank.io/2f0b6c5f-6de7-4ba3-94ad-98bf721ee447"]
         * source : web
         * publishedAt : 2015-08-07T03:57:48.45Z
         * type : Android
         * url : https://github.com/recruit-lifestyle/FloatingView
         * used : true
         * who : mthli
         */
        var android: ArrayList<AndroidBean>? = null
        var iOS: ArrayList<AndroidBean>? = null
        var front: ArrayList<AndroidBean>? = null
        var app: ArrayList<AndroidBean>? = null
        var restMovie: ArrayList<AndroidBean>? = null
        var resource: ArrayList<AndroidBean>? = null
        var recommend: ArrayList<AndroidBean>? = null
        var welfare: ArrayList<AndroidBean>? = null
    }
}