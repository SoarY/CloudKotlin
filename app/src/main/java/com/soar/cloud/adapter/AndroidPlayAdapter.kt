package com.soar.cloud.adapter

import com.alibaba.android.arouter.launcher.ARouter
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.activity.ArticleListActivity
import com.soar.cloud.base.BaseAdapter
import com.soar.cloud.bean.ArticlesBean
import com.soar.cloud.constants.RouteConstants
import com.soar.cloud.databinding.ItemAndroidPlayBinding

/**
 * NAME：YONG_
 * Created at: 2023/3/29 13
 * Describe:
 */
class AndroidPlayAdapter : BaseAdapter<ArticlesBean, ItemAndroidPlayBinding>(){
    override fun initLayoutId(): Int {
        return R.layout.item_android_play
    }

    override fun onBindView(holder: RecyclerHolder<ItemAndroidPlayBinding>?, t: ArticlesBean?, position: Int) {
        holder!!.binding.setVariable(BR.item, t)

        holder.binding.tvClassify.setOnClickListener { v ->
            ARouter.getInstance()
                .build(RouteConstants.Music.ARTICLE)
                .withInt(ArticleListActivity.CID, t!!.chapterId)
                .withString(ArticleListActivity.CHAPTER_NAME, t.chapterName)
                .navigation()
        }
    }
}