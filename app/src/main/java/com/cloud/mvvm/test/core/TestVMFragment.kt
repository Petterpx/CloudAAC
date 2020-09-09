package com.cloud.mvvm.test.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cloud.mvvm.core.base.BaseFragment
import com.cloud.mvvm.core.ktx.createViewModel
import com.cloud.mvvm.test.R
import com.cloud.mvvm.test.vm.TestActivityViewModel
import com.cloud.mvvm.test.vm.TestViewModel

/**
 * @Author petterp
 * @Date 2020/9/8-7:25 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 最基础的BaseFragment示例
 */
// TODO: 2020/9/8 根据自己的需求去改造，对于onCreateView,作为基础base-F,自行改造即可，每个人都可能有自己的业务想法
class TestVMFragment : BaseFragment() {

    val viewModel by viewModels<TestViewModel>()
    val activityViewModel by viewModels<TestActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, null)
    }


}