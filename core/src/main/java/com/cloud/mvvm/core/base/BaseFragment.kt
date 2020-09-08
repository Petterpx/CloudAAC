package com.cloud.mvvm.core.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloud.mvvm.core.ktx.CloudConfig
import com.cloud.mvvm.core.ktx.getAppViewModelProvider
import com.cloud.mvvm.core.listener.IBarListener

/**
 * @Author petterp
 * @Date 2020/8/10-3:19 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 基础BaseFragment,只包含相应的扩展方法
 */
abstract class BaseFragment : Fragment(), IBarListener {

    protected var rootView: View? = null

    protected val mHandler by lazy { CloudConfig.HANDLER }

    /** 当前fragment是否已经加载过，用于viewpager中初始化相关*/
    @Volatile
    private var onVisible = false

    /** 首次执行onResume */
    protected open fun initResume() {}

    /** onViewCreateView之后执行，用于初始化Fragment */
    protected open fun initFragment() {}

    /*** 可见 - 常用于viewPager中*/
    protected open fun showData() {}

    /*** 不可见 - 常用于viewPager中*/
    protected open fun hideData() {}

    /** 获取共享状态下的ViewModel,常用与Fragment与Fragment的数据共享 */
    @SuppressLint("UseRequireInsteadOfGet")
    protected inline fun <reified VM : ViewModel> getStateViewModel(): VM =
        ViewModelProvider(requireActivity()).get(VM::class.java)

    /** 获取指定ViewModel */
    protected inline fun <reified VM : ViewModel> getViewModel(): VM =
        ViewModelProvider(this).get(VM::class.java)

    /**  */
    protected fun appViewModelProvider() =
        getAppViewModelProvider(requireActivity().application)

    fun test() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!onVisible) {
            initFragment()
        }
    }

    override fun onResume() {
        super.onResume()
        updateBar()
        if (!onVisible) {
            onVisible = true
            initResume()
        } else {
            showData()
        }
    }

    override fun onPause() {
        super.onPause()
        hideData()
    }
}