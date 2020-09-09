package com.cloud.mvvm.test.core

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.cloud.mvvm.core.base.BaseActivity
import com.cloud.mvvm.core.ktx.createViewModel
import com.cloud.mvvm.test.R
import com.cloud.mvvm.test.vm.TestViewModel
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @Author petterp
 * @Date 2020/8/10-4:43 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 最基础的Activity示例
 */
// TODO: 2020/9/8 根据自己的需求去改造，对于onCreate,作为基础base-A,自行改造即可
//   initCreate 仅用于初始化view,以便于initData与initView
class TestVMActivity : BaseActivity() {

    val viewModel by viewModels<TestViewModel>()

    override fun initCrate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_test)
    }

    override fun initData() {
        super.initData()
        constLayout.setOnClickListener {
            viewModel.sumAdd()
        }
        viewModel.sumLiveData.observe(this, Observer {
            tvSum.text = it.toString()
        })
    }


}