package com.petterp.bullet.core.base

import android.os.Bundle
import android.view.View
import com.petterp.bullet.core.base.basic.BaseActivity

/**
 * @Author petterp
 * @Date 2020/5/18-4:03 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
abstract class BaseVMActivity : BaseActivity() {

    abstract fun layoutId(): Any

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (layoutId()) {
            is Int -> {
                setContentView(layoutId() as Int)
            }
            is View -> {
                setContentView(layoutId() as View)
            }
            else -> {
                throw RuntimeException("layoutId not error")
            }
        }
        initView()
        initData()
    }
}