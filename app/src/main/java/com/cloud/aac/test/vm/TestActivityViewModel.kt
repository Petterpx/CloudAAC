package com.cloud.aac.test.vm

import androidx.lifecycle.SavedStateHandle
import com.cloud.aac.core.base.BaseViewModel

/**
 * @Author petterp
 * @Date 2020/9/8-7:38 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestActivityViewModel : BaseViewModel {
    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)

}