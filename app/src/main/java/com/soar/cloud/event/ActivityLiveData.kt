package com.soar.cloud.event

import com.soar.cloud.base.BaseSingleLiveEvent

/**
 * NAME：YONG_
 * Created at: 2018/12/21 13
 * Describe:
 */
class ActivityLiveData : BaseSingleLiveEvent<String?>() {
    fun toActivity(act: String?) {
        postValue(act)
    }
}