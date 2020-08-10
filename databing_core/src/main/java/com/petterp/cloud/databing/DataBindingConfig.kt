package com.petterp.cloud.databing

import android.util.SparseArray
import androidx.annotation.LayoutRes

/**
 * @Author petterp
 * @Date 2020/8/10-9:49 AM
 * @Email ShiyihuiCloud@163.com
 * @Function 参考自KunMinx  -> zbc!
 */
open class DataBindingConfig(@LayoutRes val layout: Int) {


    val bingParams by lazy {
        SparseArray<Any>(3)
    }


    fun addBingParam(variableId: Int, param: Any): DataBindingConfig {
        if (bingParams.get(variableId) == null)
            bingParams.put(variableId, param)
        return this
    }


}