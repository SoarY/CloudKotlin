package com.soar.cloud.adapter

import android.content.Context
import android.text.Html
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseAdapter
import com.soar.cloud.bean.ArticlesBean
import com.soar.cloud.bean.NaviBean
import com.soar.cloud.databinding.ItemNaviContentBinding
import com.soar.cloud.util.CommonUtils
import com.soar.cloud.util.ToastUtils
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 * NAME：YONG_
 * Created at: 2023/3/31 14
 * Describe:
 */
class NaviContentAdapter : BaseAdapter<NaviBean, ItemNaviContentBinding>(){

    lateinit var context:Context

    override fun initLayoutId(): Int {
        return R.layout.item_navi_content
    }

    override fun onBindView(holder: RecyclerHolder<ItemNaviContentBinding>?, t: NaviBean?, position: Int) {
        context = holder!!.binding.root.context
        holder!!.binding.setVariable(BR.item, t)
        showTagView(holder!!.binding.tflContent, t!!.articles)
    }

    private fun showTagView(tflContent: TagFlowLayout, articles: List<ArticlesBean>?) {
        tflContent.adapter=object : TagAdapter<ArticlesBean>(articles){
            override fun getView(parent: FlowLayout?, position: Int, t: ArticlesBean): View {
                val textView: TextView = getTextView()
                textView.text = Html.fromHtml(t.title)
                return textView
            }
        }

        tflContent.setOnTagClickListener{v:View,position:Int,parent:FlowLayout->
            ToastUtils.showToast(articles!![position].title)
            true
        }
    }

    private fun getTextView(): TextView {
        val hotText = TextView(context)
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        hotText.layoutParams = lp
        hotText.textSize = 13f
        val left: Int
        val top: Int
        val right: Int
        val bottom: Int
        hotText.maxLines = 1
        bottom = CommonUtils.dip2px(5f)
        right = bottom
        top = right
        left = top
        hotText.setBackgroundResource(R.drawable.shape_navi_tag)
        hotText.gravity = Gravity.CENTER
        lp.setMargins(left, top, right, bottom)
        return hotText
    }
}