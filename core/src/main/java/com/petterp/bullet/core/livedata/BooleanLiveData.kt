package com.petterp.bullet.core.livedata


/**
 * @Author petterp
 * @Date 2020/5/17-5:54 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 自定义BooleanLiveData
 */
class BooleanLiveData(value: Boolean = false) : MutableLiveDataKtx<Boolean>(value) {
    override fun getValue(): Boolean {
        return super.getValue()!!
    }
}