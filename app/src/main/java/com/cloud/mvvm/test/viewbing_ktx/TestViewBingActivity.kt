package com.cloud.mvvm.test.viewbing_ktx

import androidx.lifecycle.Observer
import com.cloud.mvvm.test.databinding.ActivityTestBinding
import com.cloud.mvvm.test.databinding.ActivityTestViewbingBinding
import com.cloud.mvvm.test.vm.TestViewModel
import com.cloud.mvvm.viewbing.BaseViewBingVMActivity

/**
 * @Author petterp
 * @Date 2020/9/7-5:48 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestViewBingActivity :
    BaseViewBingVMActivity<ActivityTestBinding, TestViewModel>() {


    override fun getViewBing(): ActivityTestBinding = ActivityTestBinding.inflate(layoutInflater)

    override fun initView() {
        viewModel.sumAdd()
    }

    override fun initData() {
    }

}