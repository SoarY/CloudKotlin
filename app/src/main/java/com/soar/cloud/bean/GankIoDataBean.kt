package com.soar.cloud.bean


import java.io.Serializable

/**
 * Created by jingbin on 2016/11/24.
 */
class GankIoDataBean : Serializable {
    var isError :Int=0

    /**
     * _id : 5832662b421aa929b0f34e99
     * createdAt : 2016-11-21T11:12:43.567Z
     * desc :  深入Android渲染机制
     * publishedAt : 2016-11-24T11:40:53.615Z
     * source : web
     * type : Android
     * url : http://blog.csdn.net/ccj659/article/details/53219288
     * used : true
     * who : Chauncey
     */
    var results: ArrayList<ResultBean>? = null

    class ResultBean : Serializable {
        private val _id: String? = null
        val createdAt: String? = null
        val desc: String? = null
        val publishedAt: String? = null
        val source: String? = null
        val type: String? = null
        var url: String? = null
        val isUsed = false
        val who: String? = null
        val images: List<String>? = null
        fun get_id(): String? {
            return _id
        }

        override fun toString(): String {
            return "ResultsBean{" +
                    "who='" + who + '\'' +
                    ", used=" + isUsed +
                    ", url='" + url + '\'' +
                    ", type='" + type + '\'' +
                    ", source='" + source + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", _id='" + _id + '\'' +
                    '}'
        }
    }

    override fun toString(): String {
        return "GankIoDataBean{" +
                "error=" + isError +
                ", results=" + results +
                '}'
    }
}