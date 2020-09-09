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
        _savedStateHandle = state
    }

    /** ViewModel在内存不足被干掉后的数据恢复  */
    private var _savedStateHandle: SavedStateHandle? = null

    val handle: SavedStateHandle
        get() = _savedStateHandle!!

    /** 保存数据到saveStateHandle */
    fun <T> setSave(key: String, t: T) {
        handle.set(key, t)
    }

    /** 从saveStateHandle中取出数据 */
    fun <T> getSave(key: String): T? {
        return handle.get(key)
    }

    /** 获取指定saveStateHandle -key 的LiveData */
    fun <T> getSaveLiveData(key: String): MutableLiveData<T>? =
        handle.getLiveData(key)

}
