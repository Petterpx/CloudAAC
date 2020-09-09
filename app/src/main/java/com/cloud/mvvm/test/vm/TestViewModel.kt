package com.cloud.mvvm.test.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import com.cloud.mvvm.core.base.BaseViewModel
import kotlinx.coroutines.delay

/**
 * @Author petterp
 * @Date 2020/8/10-4:44 PM
 * @Email ShiyihuiCloud@163.com
 * @Function  带数据恢复的viewModel
 */
class TestViewModel : BaseViewModel {

    private val KEY_SUM = "sumLiveData"

    constructor() : super()

    // TODO: 2020/9/9 viewModel在意外被杀(内存不足等，不是主动kill掉)后，数据是不会保存
    //  此时可以重载viewModel的构造函数，并在之中处理可能要保存的数据，如下所示
    //   可以在开发者模式，设置  [不保留活动] ，这样就可以模拟相应状况
    constructor(state: SavedStateHandle) : super(state) {
        if (!state.contains("KEY_NUMBER")) {
            state.set("KEY_NUMBER", 0)
        }
    }

    // TODO: 2020/9/9 对于SaveStateHandle 和 onSaveInstanceState 应该怎么选？


    // TODO: 2020/9/9 我们提倡对外只暴露LiveData,而非 MutableLiveData，从而避免数据的不统一
    private val _sumLiveData: MutableLiveData<Int>
        get() {
            return getSaveLiveData(KEY_SUM)!!
        }
    val sumLiveData: LiveData<Int> = _sumLiveData

    // TODO: 2020/9/9 当然，上述操作可能稍显麻烦，我们也可以定义 [快捷代码模板] 简化使用，另一种方式如下
    //  使用liveData-ktx 也可以一定程度上简化上述操作，不过具体需求场景不同，这里只是顺带提一下
    //  如果有些场景，你需要做一些耗时操作，然后获取数据，可以使用如下操作
    val ktxLiveData = liveData {
        //这是一连串耗时操作
        delay(3000)
        emit(123)
    }


    fun sumAdd() {
        var value = _sumLiveData.value ?: 0
        _sumLiveData.value = ++value
    }

}