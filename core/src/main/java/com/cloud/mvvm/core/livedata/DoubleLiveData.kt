package com.cloud.mvvm.core.livedata

import androidx.lifecycle.MutableLiveData

/**
 * @Author petterp
 * @Date 2020/5/17-6:03 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class DoubleLiveData(value: Double = 0.0) : MutableLiveData<Double>() {
    override fun getValue(): Double {
        return super.getValue()!!
    }
}