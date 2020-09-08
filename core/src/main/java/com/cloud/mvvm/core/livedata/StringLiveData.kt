package com.cloud.mvvm.core.livedata

import androidx.lifecycle.MutableLiveData

/**
 * @Author petterp
 * @Date 2020/5/17-6:01 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class StringLiveData(value: String = "") : MutableLiveData<String>() {
    override fun getValue(): String {
        return super.getValue()!!
    }
}