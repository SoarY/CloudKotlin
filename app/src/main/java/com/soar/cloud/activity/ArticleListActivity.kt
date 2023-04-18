package com.soar.cloud.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.soar.cloud.BR
import com.soar.cloud.R
import com.soar.cloud.base.BaseActivity
import com.soar.cloud.constants.RouteConstants
import com.soar.cloud.databinding.ActivityArticleListBinding
import com.soar.cloud.vm.AndroidPlayViewModel

/**
 * NAME：YONG_
 * Created at: 2023/3/31 10
 * Describe:
 */
@Route(path = RouteConstants.Music.ARTICLE)
class ArticleListActivity : BaseActivity<ActivityArticleListBinding, AndroidPlayViewModel>() {

    companion object{
        val CID = "cid"
        val CHAPTER_NAME = "chapterName"
    }

    @JvmField
    @Autowired
    var cid = 0

    @JvmField
    @Autowired
    var chapterName: String? = null

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_article_list
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)
        initView()
        initData()
    }

    private fun initView() {
        mDinding.incToolbarTitle.toolbar.setTitle(chapterName)
        mDinding.incToolbarTitle.toolbar.setNavigationIcon(R.mipmap.icon_back)
        mDinding.incToolbarTitle.toolbar.setNavigationOnClickListener { v -> finish() }
    }

    private fun initData() {
        mViewModel.setCID(cid)
        mViewModel.getHomeList(true)
    }
}