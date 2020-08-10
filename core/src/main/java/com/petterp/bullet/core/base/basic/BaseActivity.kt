package com.petterp.bullet.core.base.basic

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.petterp.bullet.core.R

/**
 * @Author petterp
 * @Date 2020/8/10-11:16 AM
 * @Email ShiyihuiCloud@163.com
 * @Function 基础BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {
    companion object {
        val HANDLER by lazy {
            Handler()
        }
    }


    val activity: Activity by lazy {
        this
    }


    override fun onResume() {
        super.onResume()
        initBar()
    }

    open fun initView() {}

    open fun initData() {}


    /**
     * 网络变化监听 子类重写
     */
//    open fun onNetworkStateChanged(netState: NetState) {}

    open fun initBar() {
        immersionBar {
            transparentStatusBar()
            fullScreen(false)
            navigationBarColor(R.color.white)
            keyboardEnable(true)
            navigationBarDarkIcon(true)
            statusBarDarkFont(isBarTextColor())
            if (isFitsSystemWindows()) {
                fitsSystemWindows(true)
            }
            updateBar(this)
        }
    }


    /**
     * 状态栏字体颜色是否为深色，默认为深色
     * [true]深色 [false]亮色
     * @return
     */
    open fun isBarTextColor(): Boolean {
        return true
    }

    open fun isFitsSystemWindows(): Boolean {
        return true
    }

    /** 用于额外的需求 */
    open fun updateBar(immersionBar: ImmersionBar) {}
}