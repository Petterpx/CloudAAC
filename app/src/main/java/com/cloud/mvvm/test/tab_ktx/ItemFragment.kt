package com.cloud.mvvm.test.tab_ktx

import com.cloud.mvvm.test.R
import com.cloud.mvvm.test.databinding.FragmentItemBinding
import com.cloud.mvvm.databing.BaseDataBingFragment
import com.cloud.mvvm.databing.DataBindingConfig

/**
 * @Author petterp
 * @Date 2020/8/10-5:11 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class ItemFragment : BaseDataBingFragment<FragmentItemBinding>() {
    override fun createDataBingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_item)
    }
}