package com.petterp.cloud.cloudmvvm

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.petterp.bullet.core.base.BaseVmActivity
import kotlinx.android.synthetic.main.activity_test.*

/**
 * @Author petterp
 * @Date 2020/8/10-4:43 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestVmActivity : BaseVmActivity() {

    val testViewModel by viewModels<TestViewModel>()

    override fun layoutId(): Any {
        return R.layout.activity_test
    }

    override fun initData() {
        super.initData()
        constLayout.setOnClickListener {
            testViewModel.sumAdd()
        }
        testViewModel.sumLiveData.observe(this, Observer {
            tvSum.text = it.toString()
        })
    }

}