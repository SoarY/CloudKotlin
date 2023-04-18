package com.soar.cloud.retrofit


import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * NAME：YONG_
 * Created at: 2017/8/7 19
 * Describe: 异常分发
 */
class HttpResultFunc<T> : Function<Throwable, Observable<T>> {
    @Throws(Exception::class)
    override fun apply(throwable: Throwable): Observable<T> {
        return Observable.error(ExceptionEngine.handleException(throwable))
    }
}