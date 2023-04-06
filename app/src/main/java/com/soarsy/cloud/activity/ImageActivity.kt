package com.soarsy.cloud.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.soarsy.cloud.BR
import com.soarsy.cloud.R
import com.soarsy.cloud.base.BaseActivity
import com.soarsy.cloud.constants.RouteConstants
import com.soarsy.cloud.databinding.ActivityImageBinding
import com.soarsy.cloud.vm.ImageViewModel

/**
 * NAME：YONG_
 * Created at: 2023/4/6 15
 * Describe:
 */
@Route(path = RouteConstants.Discover.WELFARE_IMG)
class ImageActivity : BaseActivity<ActivityImageBinding, ImageViewModel>(){

    companion object{
        const val POSITION="position"
        const val IMAGE_URLS="imageUrls"
    }

    @JvmField
    @Autowired
    var position = 0

    @JvmField
    @Autowired
    var imageUrls:ArrayList<String>?=null


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_image
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)
        initView()
    }

    private fun initView() {
        mViewModel.setContext(context)

        mViewModel.adapter.setContext(context)
        mViewModel.adapter.setData(imageUrls)
        mDinding.viewPager.setAdapter(mViewModel.adapter)
        mDinding.viewPager.setCurrentItem(position)
        mViewModel.position.set(position)
    }
}