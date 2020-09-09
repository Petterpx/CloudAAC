package com.cloud.aac.databing

import android.util.SparseArray
import androidx.annotation.LayoutRes

/**
 * @Author petterp
 * @Date 2020/8/10-9:49 AM
 * @Email ShiyihuiCloud@163.com
 * @Function DataBinding的配置，参考自KunMinx  -> zbc!
 */
open class DataBindingConfig(@LayoutRes val layout: Int) {

    val bingParams by lazy {
        SparseArray<Any>(3)
    }

    fun addBingParam(variableId: Int, param: Any): DataBindingConfig {
        bingParams.put(variableId, param)
        return this
    }

}