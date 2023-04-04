package com.soarsy.cloud.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.soarsy.cloud.event.FinishLiveEvent
import com.soarsy.cloud.util.ToastUtils
import com.trello.navi2.component.support.NaviFragment
import com.trello.rxlifecycle2.navi.NaviLifecycle
import java.lang.reflect.ParameterizedType

/**
 * NAME：YONG_
 * Created at: 2023/3/25 13
 * Describe:
 */
abstract class BaseFragment <V : ViewDataBinding, VM : BaseViewModel> : NaviFragment() {

    lateinit var mDinding:V
    lateinit var mViewModel: VM

    lateinit var context: Activity

    abstract fun initVariableId(): Int

    abstract fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mDinding = DataBindingUtil.inflate(inflater, initContentView(inflater, container, savedInstanceState), container, false)
        init()
        return mDinding.root
    }

    private fun init() {
        context = requireActivity()

        mViewModel=getViewModel()
        mDinding.setVariable(initVariableId(),mViewModel)
        mViewModel.injectLifecycleProvider(NaviLifecycle.createActivityLifecycleProvider(this))

        //注册常用liveData观察者
        registorUILiveData()
    }

    private fun getViewModel(): VM {
        val type = javaClass.genericSuperclass
        val modelClass: Class<BaseViewModel>
        modelClass =
            if (type is ParameterizedType) type.actualTypeArguments[1] as Class<BaseViewModel> else BaseViewModel::class.java //如果没有指定泛型参数，则默认使用BaseViewModel
        return ViewModelProvider(this).get(modelClass) as VM
    }

    private fun registorUILiveData() {
        mViewModel.uiLiveData.activityEvent.observe(this) { s ->
            ARouter.getInstance().build(s).navigation()
        }
        mViewModel.uiLiveData.toastEvent.observe(this) { s -> ToastUtils.showToast(s) }
        mViewModel.uiLiveData.finishEvent.observe(this) { result ->
            if (result != null && result.state === FinishLiveEvent.FINISH_RESULT)
                getActivity()?.setResult(
                result.resultCode,
                result.intent)
            getActivity()?.finish()
        }
        mViewModel.uiLiveData.dialogEvent.observe(this) { dialogInfo -> }
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.onDestroy()
        mDinding.unbind()
    }
}