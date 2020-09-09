package com.cloud.aac.viewbing

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.cloud.aac.core.base.BaseActivity

/**
 * @Author petterp
 * @Date 2020/9/4-8:17 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 不附带初始化ViewModel的Activity
 * 虽然没有初始化，但是也可以使用Fragment-ktx viewModes去初始化,推荐这种方式
 */
abstract class BaseViewBingActivity<VB : ViewBinding> : BaseActivity() {

    abstract fun getBing(): VB

    override fun initCrate(savedInstanceState: Bundle?) {
        setContentView(getBing().root)
    }
}