package com.petterp.cloud.databing

import android.os.Bundle
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.petterp.bullet.core.base.basic.BaseActivity

/**
 * @Author petterp
 * @Date 2020/8/10-9:48 AM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
abstract class BaseDataBingActivity<Bing : ViewDataBinding> : BaseActivity() {

    /** 谨慎使用Bing,尽量避免直接使用 */
    lateinit var binding: Bing

    abstract fun createDataBingConfig(): DataBindingConfig


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBindingConfig = createDataBingConfig()
        binding =
            DataBindingUtil.setContentView(this, dataBindingConfig.layout)
        dataBindingConfig.bingParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        binding.lifecycleOwner = this
        initView()
        initData()
    }
}