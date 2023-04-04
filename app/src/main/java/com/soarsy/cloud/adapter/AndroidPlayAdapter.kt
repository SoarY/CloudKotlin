package com.soarsy.cloud.adapter

import com.alibaba.android.arouter.launcher.ARouter
import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.activity.ArticleListActivity
import com.soarsy.cloud.base.BaseAdapter
import com.soarsy.cloud.bean.ArticlesBean
import com.soarsy.cloud.constants.RouteConstants
import com.soarsy.cloud.databinding.ItemAndroidPlayBinding

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