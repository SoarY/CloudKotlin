package com.soarsy.cloud.retrofit


import com.google.gson.JsonParseException
import com.soarsy.cloud.util.NetworkUtils
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 * 自定义异常处理
 */
object ExceptionEngine {
    fun handleException(e: Throwable?): APIException {
        val ex: APIException
        return if (!NetworkUtils.isNetworkConnected()) {
            ex = APIException(e, ERROR.ERROR_NET)
            ex.displayMessage = "当前网络不可用,请检查你的网络设置"
            ex
        } else if (e is HttpException) { //HTTP错误
            ex = APIException(e, ERROR.HTTP_ERROR)
            when (e.code()) {
                CODE.UNAUTHORIZED -> ex.displayMessage = "操作未授权"
                CODE.FORBIDDEN -> ex.displayMessage = "请求被拒绝"
                CODE.NOT_FOUND -> ex.displayMessage = "资源不存在"
                CODE.REQUEST_TIMEOUT -> ex.displayMessage = "服务器执行超时"
                CODE.INTERNAL_SERVER_ERROR -> ex.displayMessage = "服务器内部错误"
                CODE.SERVICE_UNAVAILABLE -> ex.displayMessage = "服务器不可用"
                else -> ex.displayMessage = "网络错误"
            }
            ex
        } else if (e is UnknownHostException) {
            ex = APIException(e, ERROR.NETWORD_ERROR)
            ex.displayMessage = "连接失败"
            ex
        } else if (e is JsonParseException
            || e is JSONException
            || e is ParseException
        ) {
            ex = APIException(e, ERROR.PARSE_ERROR)
            ex.displayMessage = "解析错误"
            ex
        } else if (e is ConnectException) {
            ex = APIException(e, ERROR.NETWORD_ERROR)
            ex.displayMessage = "连接失败" //均视为网络错误
            ex
        } else if (e is SocketTimeoutException) {
            ex = APIException(e, ERROR.TIMEOUT_ERROR)
            ex.displayMessage = "连接超时,请重试"
            ex
        } else if (e is ServerException) { //服务器返回的错误
            val resultException = e
            ex = APIException(resultException, resultException.code)
            ex.displayMessage = resultException.msg
            ex
        } else {
            ex = APIException(e, ERROR.UNKNOWN)
            ex.displayMessage = "服务器异常,请稍后再试试哦"
            ex //未知错误
        }
    }

    /**
     * 对应HTTP的状态码
     */
    object CODE {
        const val UNAUTHORIZED = 401
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val REQUEST_TIMEOUT = 408
        const val INTERNAL_SERVER_ERROR = 500
        const val SERVICE_UNAVAILABLE = 503
    }

    /**
     * 约定异常
     *
     *
     * 具体规则需要与服务端或者领导商讨定义
     */
    object ERROR {
        /**
         * 默认DEFAULT_ERROR
         */
        const val DEFAULT_ERROR = 1

        /**
         * 未知错误
         */
        const val UNKNOWN = 1000

        /**
         * 解析错误
         */
        const val PARSE_ERROR = 1001

        /**
         * 网络错误
         */
        const val NETWORD_ERROR = 1002

        /**
         * 协议出错
         */
        const val HTTP_ERROR = 1003

        /**
         * 证书出错
         */
        const val SSL_ERROR = 1005

        /**
         * 连接超时
         */
        const val TIMEOUT_ERROR = 1006

        /**
         * 无网络
         */
        const val ERROR_NET = 1007
    }
}