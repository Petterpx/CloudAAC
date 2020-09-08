package com.cloud.mvvm.databing

import android.os.Bundle
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cloud.mvvm.core.base.BaseActivity

/**
 * @Author petterp
 * @Date 2020/8/10-9:48 AM
 * @Email ShiyihuiCloud@163.com
 * @Function 对于BaseActivity-dataBing的扩展
 */
abstract class BaseDataBingActivity<Bing : ViewDataBinding> : BaseActivity() {

    /** 谨慎使用Bing,尽量避免直接使用 */
    protected lateinit var binding: Bing

    abstract fun createDataBingConfig(): DataBindingConfig

    override fun initCrate(savedInstanceState: Bundle?) {
        val dataBindingConfig = createDataBingConfig()
        binding =
            DataBindingUtil.setContentView(this, dataBindingConfig.layout)
        dataBindingConfig.bingParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        binding.lifecycleOwner = this
    }
}