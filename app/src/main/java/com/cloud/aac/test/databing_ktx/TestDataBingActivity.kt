package com.cloud.aac.test.databing_ktx

import androidx.activity.viewModels
import com.cloud.aac.test.BR
import com.cloud.aac.test.R
import com.cloud.aac.test.vm.TestViewModel
import com.cloud.aac.test.databinding.ActivityTestDatabingBinding
import com.cloud.aac.databing.BaseDataBingActivity
import com.cloud.aac.databing.DataBindingConfig

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

