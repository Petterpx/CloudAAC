package com.cloud.aac.test.tab_ktx

import com.cloud.aac.test.R
import com.cloud.aac.test.databinding.FragmentItemBinding
import com.cloud.aac.databing.BaseDataBingFragment
import com.cloud.aac.databing.DataBindingConfig

/**
 * @Author petterp
 * @Date 2020/8/10-5:11 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 示例 ItemFragment
 */
class ItemFragment : BaseDataBingFragment<FragmentItemBinding>() {
    override fun createDataBingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.fragment_item)
    }
}