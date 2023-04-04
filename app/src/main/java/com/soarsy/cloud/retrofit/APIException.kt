package com.soarsy.cloud.retrofit


/**
 * 统一分发回传ui Exception
 */
class APIException : Exception {
    var code = 0
        private set
    var displayMessage: String? = null

    constructor(throwable: Throwable?, code: Int) : super(throwable) {
        this.code = code
    }
}