package com.soarsy.cloud.vm

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.databinding.ObservableInt
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.soarsy.cloud.R
import com.soarsy.cloud.adapter.ImageAdapter
import com.soarsy.cloud.base.BaseViewModel
import com.soarsy.cloud.util.CommonUtils
import com.soarsy.cloud.util.FileUtils
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * NAME：YONG_
 * Created at: 2023/4/6 15
 * Describe:
 */
class ImageViewModel(application:Application) : BaseViewModel(application){

    var mContext:Activity?=null

    val position=ObservableInt()
    val adapter= ImageAdapter()

    fun setContext(context: Activity) {
        this.mContext = context
    }

    val onPageChangeListener=object :ViewPager.OnPageChangeListener{
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(pos: Int) {
            position.set(pos)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

    val keepOnClickListener= View.OnClickListener {
        downloadImg()
    }

    @SuppressLint("CheckResult")
    private fun downloadImg() {
        Observable.create<File> {
            it.onNext(
                Glide.with(mContext!!)
                    .load(adapter.getItem(position.get()))
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get()
            )
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe {
                val pictureFolder = mContext!!.getExternalFilesDir(null)
                val appDir = File(pictureFolder, mContext!!.getString(R.string.app_name))
                if (!appDir.exists())
                    appDir.mkdirs()
                val fileName: String = CommonUtils.MD5(it.getName()) + ".jpg"
                val destFile = File(appDir, fileName)
                FileUtils.copy(it, destFile)
                // 最后通知图库更新
                mContext!!.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(File(destFile.path))))
                uiLiveData.toastEvent.show(String.format(mContext!!.getString(R.string.success_img_keep), mContext!!.getString(R.string.app_name)))
            }
    }

    override fun onDestroy(){
        super.onDestroy()
        mContext=null
    }
}