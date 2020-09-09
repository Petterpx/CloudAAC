package com.cloud.mvvm.core.expand

import android.app.Activity
import androidx.fragment.app.Fragment
import com.cloud.mvvm.core.ktx.CloudConfig
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar

/**
 * @Author petterp
 * @Date 2020/9/8-11:01 AM
 * @Email ShiyihuiCloud@163.com
 * @Function 对 ImmersionBar 的扩展
 * immersionBar 是一个非常优秀的状态栏处理工具，为了更好的配合CloudMVVM,故作此封装便于使用
 */
interface IBarExpand {

    fun Fragment.updateBar() {
        immersionBar { initBar() }
    }

    fun Activity.updateBar() {
        immersionBar { initBar() }
    }

    /**
     *  考虑到可能每个人可能有不同的全局配置，故提供全局配置清单
     *  如果需要单独特殊处理，重写此方法即可，默认优先使用全局配置
     * */
    fun ImmersionBar.initBar() {
        CloudConfig.getImmersionBar()?.invoke(this) ?: initBarConfig()
    }

    /** 提供的默认配置清单，不可被重写*/
    private fun ImmersionBar.initBarConfig() {
        transparentStatusBar()
        fullScreen(false)
        navigationBarColor(android.R.color.white)
        keyboardEnable(true)
        navigationBarDarkIcon(true)
        statusBarDarkFont(isBarTextColor())
        fitsSystemWindows(isFitsSystemWindows())
    }

    /** 默认-状态栏字体颜色处理方式，true->黑色 false->浅色 */
    fun isBarTextColor() = true


    /** 默认配置-是否使用默认的状态栏处理方式，默认true */
    fun isFitsSystemWindows() = true

}