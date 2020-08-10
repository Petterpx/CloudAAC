package com.petterp.cloud.cloudmvvm

import androidx.activity.viewModels
import com.petterp.cloud.cloudmvvm.databinding.ActivityTestDatabingBinding
import com.petterp.cloud.databing.BaseDataBingActivity
import com.petterp.cloud.databing.DataBindingConfig

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

