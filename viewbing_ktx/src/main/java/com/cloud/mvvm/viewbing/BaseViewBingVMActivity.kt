package com.cloud.mvvm.viewbing

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.cloud.mvvm.core.base.BaseViewModel
import com.cloud.mvvm.core.base.BaseActivity
import com.cloud.mvvm.core.ktx.createViewModel

/**
 * @Author petterp
 * @Date 2020/9/4-3:31 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
abstract class BaseViewBingVMActivity<VM : BaseViewModel, VB : ViewBinding> : BaseActivity() {

    protected val viewModel by lazy {
        createViewModel(this, this) as VM
    }

    protected abstract fun getViewBing(): VB

    private var _bing: VB? = null
    protected val bing get() = _bing!!

    override fun initCrate(savedInstanceState: Bundle?) {
        _bing = getViewBing()
        setContentView(bing.root)
    }
}