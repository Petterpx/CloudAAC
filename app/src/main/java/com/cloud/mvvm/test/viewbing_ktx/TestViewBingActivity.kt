package com.cloud.mvvm.test.viewbing_ktx

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import com.cloud.mvvm.test.databinding.ActivityTestBinding
import com.cloud.mvvm.test.vm.TestViewModel
import com.cloud.mvvm.viewbing.BaseViewBingVMActivity

/**
 * @Author petterp
 * @Date 2020/9/7-5:48 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 测试ViewBing-Activity
 */
class TestViewBingActivity :
    BaseViewBingVMActivity<TestViewModel, ActivityTestBinding>() {

    // TODO: 2020/9/9 这里传入你的Bing实例，后续使用直接调用 [bing] 即可
    override fun getViewBing(): ActivityTestBinding = ActivityTestBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        bing.constLayout.setOnClickListener {
            viewModel.sumAdd()
        }
    }

    override fun initData() {
        viewModel.sumLiveData.observe(this, Observer {
            bing.tvSum.text = it.toString()
        })
    }

    // TODO: 2020/9/9 onSaveInstanceState 和 ViewModel-SavedStateHandle 该怎么选？解释源自google开发者
    //  https://medium.com/androiddevelopers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090
    //  简要概述如下：
    /**
     * 1. SavedStateHandle并不能代替 onSaveInstanceState
     * 2. onSaveInstanceState适合保存数据的唯一标识符，比如搜索记录的 搜索标题，用户当前的userId等
     * 3. SavedStateHandle 适合保存当前UI所需的所有数据
     * 4. 一般来说，onSaveInstanceState 与 SavedStateHandle是配合使用
     * */
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}