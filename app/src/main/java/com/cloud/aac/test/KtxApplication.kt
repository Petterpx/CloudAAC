package com.cloud.aac.test

import android.app.Application
import com.cloud.aac.core.ktx.CloudConfig

/**
 * @Author petterp
 * @Date 2020/8/7-11:54 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class KtxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // TODO: 2020/9/8 增加状态栏的全局配置 ，这样的话默认会优先使用全局配置
        CloudConfig.setImmersion {
            transparentStatusBar()
            fullScreen(false)
            navigationBarColor(android.R.color.white)
            keyboardEnable(true)
            navigationBarDarkIcon(true)
            fitsSystemWindows(true)
        }
    }
}