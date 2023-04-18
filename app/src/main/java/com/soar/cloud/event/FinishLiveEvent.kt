package com.soar.cloud.event

import android.content.Intent
import com.soar.cloud.base.BaseSingleLiveEvent

/**
 * NAME：YONG_
 * Created at: 2018/12/21 13
 * Describe:
 */
class FinishLiveEvent : BaseSingleLiveEvent<FinishLiveEvent.Result?>() {
    fun finish() {
        postValue(Result(FINISH))
    }

    fun finishResult(resultCode: Int, intent: Intent?) {
        postValue(Result(FINISH_RESULT, resultCode, intent))
    }

    inner class Result {
        var state: Int
        var resultCode = 0
        var intent: Intent? = null

        constructor(state: Int) {
            this.state = state
        }

        constructor(state: Int, resultCode: Int, intent: Intent?) {
            this.state = state
            this.resultCode = resultCode
            this.intent = intent
        }
    }

    companion object {
        const val FINISH = 1
        const val FINISH_RESULT = 2
    }
}