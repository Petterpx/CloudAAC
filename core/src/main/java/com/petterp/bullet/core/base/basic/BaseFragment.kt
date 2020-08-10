package com.petterp.bullet.core.base.basic

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ktx.immersionBar
import com.petterp.bullet.core.R

/**
 * @Author petterp
 * @Date 2020/8/10-3:19 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
abstract class BaseFragment : Fragment() {

    protected var rootView: View? = null

    @Volatile
    private var onVisible = false

    companion object {
        val HANDLER: Handler = Handler()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!onVisible) {
            initFragment()
            initData()
        }
    }

    override fun onResume() {
        super.onResume()
        initBar()
        if (!onVisible) {
            onVisible = true
            initResume()
        } else {
            updateData()
        }
    }

    /** 状态栏字体颜色是否为深色，默认为深色 */
    protected open fun isBarTextColor(): Boolean {
        return true
    }

    protected open fun isFitsSystemWindows(): Boolean {
        return true
    }


    protected open fun initBar() {
        immersionBar {
            transparentStatusBar()
            fullScreen(false)
            navigationBarColor(R.color.white)
            keyboardEnable(true)
            navigationBarDarkIcon(true)
            statusBarDarkFont(isBarTextColor())
            fitsSystemWindows(isFitsSystemWindows())
        }
    }

    /** 首次执行onResume */
    protected open fun initResume() {}


    /** 首次执行onResume onViewCreateView之后执行 */
    protected open fun initFragment() {}

    /** 做一些io操作 [onStart]
     *  注意，此方法禁止在ViewPager中使用，容易产生重复请求
     * */
    protected open fun initData() {}


    override fun onPause() {
        super.onPause()
        hideData()
    }

    /**
     * 可见- tab
     */
    protected open fun updateData() {}

    /**
     * 不可见
     */
    protected open fun hideData() {}
}