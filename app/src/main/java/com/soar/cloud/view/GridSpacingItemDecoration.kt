package com.soar.cloud.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * NAME：YONG_
 * Created at: 2023/4/3 17
 * Describe:
 */
class GridSpacingItemDecoration constructor(
 spanCount: Int,
 spacing: Int,
 includeEdge: Boolean = true
) :
 RecyclerView.ItemDecoration() {
 private val spanCount: Int
 private val spacing: Int
 private val includeEdge: Boolean

 init {
  this.spanCount = spanCount
  this.spacing = spacing
  this.includeEdge = includeEdge
 }

 override fun getItemOffsets(
  outRect: Rect,
  view: View,
  parent: RecyclerView,
  state: RecyclerView.State
 ) {
    val position: Int = parent.getChildAdapterPosition(view!!) // item position
    val column = position % spanCount // item column
    if (includeEdge) {
     outRect.left =
      spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
     outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)
     if (position < spanCount) { // top edge
      outRect.top = spacing
     }
     outRect.bottom = spacing // item bottom
    } else {
     outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
     outRect.right =
      spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
     if (position >= spanCount) {
      outRect.top = spacing // item top
     }
    }
 }
}