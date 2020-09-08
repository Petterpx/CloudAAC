package com.cloud.mvvm.viewbing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.cloud.mvvm.core.base.BaseViewModel
import com.cloud.mvvm.core.base.BaseFragment
import com.cloud.mvvm.core.ktx.createViewModel

/**
 * @Author petterp
 * @Date 2020/9/3-5:58 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 附带懒加载的Fragment
 */
abstract class BaseViewBingVMFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFragment() {

    protected val viewModel by lazy {
        createViewModel(this, this) as VM
    }

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