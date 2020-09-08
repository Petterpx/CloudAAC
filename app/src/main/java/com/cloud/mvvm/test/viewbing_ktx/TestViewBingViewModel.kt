package com.cloud.mvvm.test.viewbing_ktx

import androidx.lifecycle.SavedStateHandle
import com.cloud.mvvm.core.base.BaseViewModel


/**
 * @Author petterp
 * @Date 2020/9/7-5:50 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestViewBingViewModel : BaseViewModel {
    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)

}