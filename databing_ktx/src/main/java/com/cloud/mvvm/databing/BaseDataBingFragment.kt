package com.cloud.mvvm.databing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.cloud.mvvm.core.base.BaseFragment

/**
 * @Author petterp
 * @Date 2020/8/10-3:21 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 适用于DataBing的Fragment
 */
abstract class BaseDataBingFragment<Bing : ViewDataBinding> : BaseFragment() {

    /** 谨慎使用Bing,尽量避免直接使用,避免视图调用一致性问题 */
    private var _binding: Bing? = null

    protected val bind: Bing
        get() = _binding!!

    abstract fun createDataBingConfig(): DataBindingConfig

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return createView(inflater, container)
    }

    private fun createView(inflater: LayoutInflater, container: ViewGroup?): View {
        val dataBindingConfig = createDataBingConfig()
        _binding =
            DataBindingUtil.inflate(inflater, dataBindingConfig.layout, container, false)
        dataBindingConfig.bingParams.forEach { key, value ->
            bind.setVariable(key, value)
        }
        bind.lifecycleOwner = this
        rootView = bind.root
        return rootView!!
    }


    override fun onDestroyView() {
        super.onDestroyView()
        //Fragment 的存在时间比其视图长。请务必在 Fragment 的 onDestroyView() 方法中清除对绑定类实例的所有引用。
        _binding = null
    }

}