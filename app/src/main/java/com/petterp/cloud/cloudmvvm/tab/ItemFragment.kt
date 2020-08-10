package com.petterp.cloud.cloudmvvm.tab

import com.petterp.cloud.cloudmvvm.R
import com.petterp.cloud.cloudmvvm.databinding.FragmentItemBinding
import com.petterp.cloud.databing.BaseDataBingFragment
import com.petterp.cloud.databing.DataBindingConfig

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