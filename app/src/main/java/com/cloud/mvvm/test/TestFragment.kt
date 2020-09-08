package com.cloud.mvvm.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cloud.mvvm.core.base.BaseFragment
import com.cloud.mvvm.test.vm.TestActivityViewModel
import com.cloud.mvvm.test.vm.TestViewModel

/**
 * @Author petterp
 * @Date 2020/9/8-7:40 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestFragment : BaseFragment() {

    // TODO: 2020/9/8 对于ViewModel的使用，更推荐使用ktx的扩展,当然有人更习惯去通过泛型去扩展，这里展示的是google推荐方式
    val viewModel by viewModels<TestViewModel>()
    val activityViewModel by viewModels<TestActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}