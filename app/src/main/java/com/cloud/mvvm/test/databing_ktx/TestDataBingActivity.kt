package com.cloud.mvvm.test.databing_ktx

import androidx.activity.viewModels
import com.cloud.mvvm.test.BR
import com.cloud.mvvm.test.R
import com.cloud.mvvm.test.vm.TestViewModel
import com.cloud.mvvm.test.databinding.ActivityTestDatabingBinding
import com.cloud.mvvm.databing.BaseDataBingActivity
import com.cloud.mvvm.databing.DataBindingConfig

/**
 * @Author petterp
 * @Date 2020/8/10-4:33 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestDataBingActivity : BaseDataBingActivity<ActivityTestDatabingBinding>() {

    private val testDataBingViewModel by viewModels<TestViewModel>()

    override fun createDataBingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.activity_test_databing).addBingParam(BR.vm, testDataBingViewModel)
    }

}

