package com.petterp.bullet.core.viewmodel

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/** 获取指定ViewModel */
@SuppressLint("UseRequireInsteadOfGet")
inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(cls: Class<VM>): VM {
    return ViewModelProvider(
        this
    ).get(cls)
}

/** 用于Fragment间获取activity-viewModel，常用与ff间通信 */
@SuppressLint("UseRequireInsteadOfGet")
inline fun <reified VM : ViewModel> Fragment.getStateViewModel(cls: Class<VM>): VM {
    return ViewModelProvider(
        requireActivity()
    ).get(cls)
}

/** 获取指定ViewModel,一般用于Activity&&Activity之间共享 */
@SuppressLint("UseRequireInsteadOfGet")
inline fun <reified VM : ViewModel> Fragment.getViewModel(cls: Class<VM>): VM {
    return ViewModelProvider(
        this
    ).get(cls)
}