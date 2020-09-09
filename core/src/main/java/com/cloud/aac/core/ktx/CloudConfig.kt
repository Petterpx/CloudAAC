package com.cloud.aac.core.ktx

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.gyf.immersionbar.ImmersionBar

/**
 * @Author petterp
 * @Date 2020/9/4-9:33 AM
 * @Email ShiyihuiCloud@163.com
 * @Function 一些配置文件清单
 */
object CloudConfig {
    //提供的全局handler
    internal val HANDLER by lazy {
        Handler(Looper.getMainLooper())
    }

    private var _immbar: (ImmersionBar.() -> Unit)? = null

    fun setImmersion(listener: ImmersionBar.() -> Unit) {
        this._immbar = listener
    }

    fun getImmersionBar(): (ImmersionBar.() -> Unit)? {
        return _immbar
    }

}

/**
 * dp转px
 */
fun Context.dip2px(dpValue: Float): Int {
    val scale: Float = resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}


/**
 * px转dp
 */
internal fun Context.px2dip(pxValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}