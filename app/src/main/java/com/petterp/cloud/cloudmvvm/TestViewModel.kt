package com.petterp.cloud.cloudmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author petterp
 * @Date 2020/8/10-4:44 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestViewModel : ViewModel() {
    val sumLiveData = MutableLiveData(0)

    fun sumAdd() {
        var value = sumLiveData.value!!
        sumLiveData.value = ++value
    }

}