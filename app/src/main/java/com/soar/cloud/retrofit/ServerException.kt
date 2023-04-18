package com.soar.cloud.retrofit


/**
 * 服务器返回码__Android自定义异常对象
 */
class ServerException(//服务器错误码
    val code: Int, val msg: String?
) : RuntimeException()