package com.soarsy.cloud.retrofit


import io.reactivex.functions.Function

/**
 * 拦截服务器返回的错误状态码，剥离ui真正需要的resultData
 */
class ServerResultFunc<T> : Function<BaseResultBean<T>, T> {
    @Throws(Exception::class)
    override fun apply(baseResult: BaseResultBean<T>): T {
        if (baseResult.errorCode != 0) throw ServerException(
            baseResult.errorCode,
            baseResult.errorMsg
        )
        //rxjava2  map操作符不在支持null,服务器返回数据为null时候，统一用Object接受.  也可参考https://www.jianshu.com/p/f1957c9c2240
        return if (baseResult.data == null) Any() as T else baseResult.data!!
    }
}