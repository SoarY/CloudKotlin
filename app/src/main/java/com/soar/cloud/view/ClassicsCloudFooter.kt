package com.soar.cloud.view

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshKernel
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.soar.cloud.R

/**
 * NAME：YONG_
 * Created at: 2019/1/15
 * Describe:
 */
class ClassicsCloudFooter : LinearLayout, RefreshHeader {
 private var tvFooter: TextView? = null
 private var ivProgress: ImageView? = null
 private var mProgressDrawable: AnimationDrawable? = null

 constructor(context: Context?) : super(context) {}
 constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}
 constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
  context,
  attrs,
  defStyleAttr
 ) {
 }

 protected override fun onFinishInflate() {
  super.onFinishInflate()
  tvFooter = findViewById<View>(R.id.tv_footer) as TextView?
  ivProgress = findViewById<View>(R.id.iv_progress) as ImageView?
  mProgressDrawable = ivProgress!!.drawable as AnimationDrawable
 }

 //真实的视图就是自己，不能返回null
 override fun getView(): View {
  return this
 }

 override fun getSpinnerStyle(): SpinnerStyle {
  return SpinnerStyle.Translate //指定为平移，不能null
 }

 override fun onStartAnimator(layout: RefreshLayout, headHeight: Int, maxDragHeight: Int) {
  mProgressDrawable?.start() //开始动画
 }

 override fun onFinish(layout: RefreshLayout, success: Boolean): Int {
  mProgressDrawable?.stop() //停止动画
  return 100 //延迟几毫秒之后再弹回
 }

 override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {}

 override fun isSupportHorizontalDrag(): Boolean {
  return false
 }
 override fun onStateChanged(
  refreshLayout: RefreshLayout,
  oldState: RefreshState,
  newState: RefreshState
 ) {
  when (newState) {
   RefreshState.None, RefreshState.PullUpToLoad -> {}
   RefreshState.Loading -> {}
   RefreshState.ReleaseToLoad -> {}
   else -> {}
  }
 }



 override fun setPrimaryColors(vararg colors: Int) {}
 override fun onInitialized(@NonNull kernel: RefreshKernel, height: Int, maxDragHeight: Int) {}
 override fun onMoving(
  isDragging: Boolean,
  percent: Float,
  offset: Int,
  height: Int,
  maxDragHeight: Int
 ) {
 }

 override fun onReleased(
  @NonNull refreshLayout: RefreshLayout,
  height: Int,
  maxDragHeight: Int
 ) {
 }
}