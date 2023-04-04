package com.soarsy.cloud.util

import android.os.Handler
import android.widget.Toast
import com.soarsy.cloud.MyApplication

/**
 * NAME：YONG_
 * Created at: 2023/3/24 15
 * Describe:
 */
object ToastUtils {
    private var mToast: Toast? = null

    /**
     * 在子线程中弹吐司
     */
    fun showToastOnThread(text: String?) {
        Handler().post { showToast(text) }
    }

    /**
     * 防止重复弹出toast
     *
     * Toast引用被static所以不要传入activity的context(防止内存泄露)
     */
    fun showToast(text: String?) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.context, text, Toast.LENGTH_SHORT)
        } else {
            mToast!!.setText(text)
            mToast!!.duration = Toast.LENGTH_SHORT
        }
        mToast!!.show()
    }
}