package com.soar.cloud.event

import com.soar.cloud.base.BaseSingleLiveEvent
import com.soar.cloud.event.DialogLiveData.DialogInfo

/**
 * NAME：YONG_
 * Created at: 2018/12/21 14
 * Describe:
 */
class DialogLiveData : BaseSingleLiveEvent<DialogInfo?>() {
    fun show(message: String?) {
        postValue(DialogInfo(true, message))
    }

    fun hide() {
        postValue(DialogInfo())
    }

    inner class DialogInfo {
        var isShow = false
        var message: String? = null

        constructor() {}
        constructor(isShow: Boolean, message: String?) {
            this.isShow = isShow
            this.message = message
        }
    }
}