package com.petterp.bullet.core.livedata

import androidx.lifecycle.MutableLiveData

/**
 * @Author petterp
 * @Date 2020/5/17-6:16 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class FloatLiveData(value: Float = 0f) : MutableLiveData<Float>() {
    override fun getValue(): Float {
        return super.getValue()!!
    }
}