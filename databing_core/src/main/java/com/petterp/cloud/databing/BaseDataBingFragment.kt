package com.petterp.cloud.databing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.petterp.bullet.core.base.basic.BaseFragment

/**
 * @Author petterp
 * @Date 2020/8/10-3:21 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 适用于DataBing的Fragment
 */
abstract class BaseDataBingFragment<Bing : ViewDataBinding> : BaseFragment() {

    /** 谨慎使用Bing,尽量避免直接使用,避免视图调用一致性问题 */
    lateinit var binding: Bing

    abstract fun createDataBingConfig(): DataBindingConfig

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view.takeIf {
            it != null
        } ?: createView(inflater, container)
    }

    private fun createView(inflater: LayoutInflater, container: ViewGroup?): View {
        val dataBindingConfig = createDataBingConfig()
        binding =
            DataBindingUtil.inflate(inflater, dataBindingConfig.layout, container, false)
        dataBindingConfig.bingParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        binding.lifecycleOwner = this
        return binding.root
    }

}