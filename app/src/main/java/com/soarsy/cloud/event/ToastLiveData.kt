package com.soarsy.cloud.event

import com.soarsy.cloud.base.BaseSingleLiveEvent

/**
 * NAME：YONG_
 * Created at: 2018/12/21 11
 * Describe:
 */
class ToastLiveData : BaseSingleLiveEvent<String?>() {
    fun show(message: String?) {
        postValue(message)
    }
}