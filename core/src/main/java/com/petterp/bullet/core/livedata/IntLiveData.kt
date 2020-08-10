package com.petterp.bullet.core.livedata


/**
 * @Author petterp
 * @Date 2020/5/31-11:02 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class IntLiveData(value: Int = 0) : MutableLiveDataKtx<Int>(value) {
    override fun getValue(): Int {
        return super.getValue()!!
    }
}