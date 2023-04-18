package com.soar.cloud.base

import android.app.Application
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import com.soar.cloud.event.ActivityLiveData
import com.soar.cloud.event.DialogLiveData
import com.soar.cloud.event.FinishLiveEvent
import com.soar.cloud.event.ToastLiveData
import com.soar.cloud.view.LoadingView
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent

/**
 * NAME：YONG_
 * Created at: 2023/3/23 16
 * Describe:
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private var lifecycle: LifecycleProvider<ActivityEvent>? = null

    var whichChild: ObservableInt = ObservableInt()
    var loadState: ObservableField<LoadingView.State> = ObservableField(LoadingView.State.done)

    var uiLiveData: UIChangeLiveData =UIChangeLiveData()

    open fun viewState(i: Int, state: LoadingView.State?) {
        whichChild.set(i)
        loadState.set(state)
    }

    /**
     * 注入RxLifecycle生命周期
     */
    open fun injectLifecycleProvider(lifecycle: LifecycleProvider<ActivityEvent>) {
        this.lifecycle = lifecycle
    }

    open fun getLifecycleProvider(): LifecycleProvider<ActivityEvent>? {
        return lifecycle
    }

    class UIChangeLiveData {
        var activityEvent: ActivityLiveData = ActivityLiveData()
        var finishEvent: FinishLiveEvent = FinishLiveEvent()
        var toastEvent: ToastLiveData = ToastLiveData()
        var dialogEvent: DialogLiveData = DialogLiveData()
    }

    /**
     * 若有引用到Activity,比如Context等
     *
     * 在Activity销毁时,ViewModel重写此方法释放引用
     */
    open fun onDestroy(){

    }
}