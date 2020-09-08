package com.cloud.mvvm.core.base

import androidx.lifecycle.*

/**
 * @Author petterp
 * @Date 2020/5/18-4:04 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
open class BaseViewModel : ViewModel {

    constructor() : super() {}

    constructor(state: SavedStateHandle) : super() {
        savedStateHandle = state
    }

    /** ViewModel在内存不足被干掉后的数据恢复  */
    private var savedStateHandle: SavedStateHandle? = null

    /** 保存数据到saveStateHandle */
    protected fun <T> saveCurrentValue(key: String, t: T) {
        savedStateHandle?.set(key, t)
    }

    /** 从saveStateHandle中取出数据 */
    protected fun <T> getCurrentValue(key: String): T? {
        return savedStateHandle?.get(key)
    }

    /** 获取指定saveStateHandle -key 的LiveData */
    protected fun <T> getSaveStateLiveData(key: String): MutableLiveData<T>? =
        savedStateHandle?.getLiveData(key)
}
