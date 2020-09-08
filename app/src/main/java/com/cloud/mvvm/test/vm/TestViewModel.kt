package com.cloud.mvvm.test.vm

import com.cloud.mvvm.core.base.BaseViewModel
import com.cloud.mvvm.core.livedata.IntMutableLiveData

/**
 * @Author petterp
 * @Date 2020/8/10-4:44 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestViewModel : BaseViewModel() {
    val sumLiveData = IntMutableLiveData()

    fun sumAdd() {
        var value = sumLiveData.value
        sumLiveData.value = ++value
    }

}