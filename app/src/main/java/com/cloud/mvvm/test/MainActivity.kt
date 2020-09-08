package com.cloud.mvvm.test

import android.content.Intent
import android.os.Bundle
import com.cloud.mvvm.test.databing_ktx.TestDataBingActivity
import com.cloud.mvvm.test.tab_ktx.TestTabActivity
import com.cloud.mvvm.test.core.TestVMActivity
import com.cloud.mvvm.core.base.BaseActivity
import com.cloud.mvvm.test.viewbing_ktx.TestViewBingActivity
import kotlinx.android.synthetic.main.activity_main.*

/** 示例Activity入口 */
class MainActivity : BaseActivity() {
    override fun initCrate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
    }

    override fun initView() {
        btnBing.setOnClickListener {
            startActivity(Intent(this, TestDataBingActivity::class.java))
        }
        btnVm.setOnClickListener {
            startActivity(Intent(this, TestVMActivity::class.java))
        }
        btnViewBing.setOnClickListener {
            startActivity(Intent(this, TestViewBingActivity::class.java))
        }
        btnTab.setOnClickListener {
            startActivity(Intent(this, TestTabActivity::class.java))
        }
    }

}