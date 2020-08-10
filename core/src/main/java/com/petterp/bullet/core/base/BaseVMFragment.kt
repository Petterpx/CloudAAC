package com.petterp.bullet.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.petterp.bullet.core.base.basic.BaseFragment


/**
 * Created by Petterp
 * on 2020-02-21
 * Function: fragment&Androidx&懒加载&协程
 * 请在initData中执行耗时，initFragment初始化，注意PagerAdapter的写法
 */
abstract class BaseVMFragment : BaseFragment() {

    @LayoutRes
    abstract fun layoutId(): Int
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view.takeIf {
            it != null
        } ?: inflater.inflate(layoutId(), null)
    }

}