package com.cloud.mvvm.viewbing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.cloud.mvvm.core.base.BaseFragment

/**
 * @Author petterp
 * @Date 2020/9/4-3:27 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 不附带初始化ViewModel的Fragment
 * 虽然没有初始化，但是也可以使用Fragment-ktx viewModes去初始化,推荐这种方式
 */
abstract class BaseViewBingFragment<VB : ViewBinding> : BaseFragment() {
    protected abstract fun getViewBing(): VB
    private var _bing: VB? = null
    protected val bing: VB
        get() = _bing!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bing = getViewBing()
        rootView = bing.root
        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //Fragment 的存在时间比其视图长。请务必在 Fragment 的 onDestroyView() 方法中清除对绑定类实例的所有引用。
        _bing = null
    }
}