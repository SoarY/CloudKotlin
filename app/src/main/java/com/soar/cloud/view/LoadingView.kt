package com.soar.cloud.view

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.soar.cloud.R

/**
 * LoadingView解决了请求网络数据时ui显示的三种状态
 * 分别为加载中，加载失败，无数据
 */
class LoadingView : FrameLayout, View.OnClickListener {
    private lateinit var empty: LinearLayout
    private lateinit var error: LinearLayout
    private lateinit var loading: LinearLayout
    private var state: State?=null
    private var listener: OnRetryListener?=null

    fun interface OnRetryListener {
        fun onRetry()
    }

    enum class State {
        ing, error, done, empty
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initializeView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeView(context)
    }

    constructor(context: Context) : super(context) {
        initializeView(context)
    }

    private fun initializeView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.lay_loading, this)
        empty = findViewById(R.id.empty)
        error = findViewById(R.id.error)
        loading = findViewById(R.id.loading)
        ((findViewById<View>(R.id.img_progress) as ImageView).drawable as AnimationDrawable).start()
        setOnClickListener(this)
        notifyDataChanged(State.ing)
    }

    fun notifyDataChanged(state: State?) {
        this.state = state
        when (state) {
            State.ing -> {
                setVisibility(View.VISIBLE)
                loading.setVisibility(View.VISIBLE)
                empty.setVisibility(View.GONE)
                error.setVisibility(View.GONE)
            }
            State.empty -> {
                setVisibility(View.VISIBLE)
                loading.setVisibility(View.GONE)
                empty.setVisibility(View.VISIBLE)
                error.setVisibility(View.GONE)
            }
            State.error -> {
                setVisibility(View.VISIBLE)
                loading.setVisibility(View.GONE)
                empty.setVisibility(View.GONE)
                error.setVisibility(View.VISIBLE)
            }
            State.done -> setVisibility(View.GONE)
            else -> setVisibility(View.GONE)
        }
    }

    fun setEmptyView(view: View?) {
        empty.removeAllViews()
        empty.addView(view)
    }

    fun setLoadingView(view: View?) {
        loading.removeAllViews()
        loading.addView(view)
    }

    fun setOnRetryListener(listener: OnRetryListener) {
        this.listener = listener
    }

    override fun onClick(v: View) {
        if (listener != null) listener!!.onRetry()
        if (listener != null && (state == State.error || state == State.empty)) listener!!.onRetry()
    }
}