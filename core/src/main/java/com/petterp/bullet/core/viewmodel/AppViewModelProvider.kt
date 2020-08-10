package com.petterp.bullet.core.viewmodel

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import java.lang.reflect.ParameterizedType

/**
 * Created by Petterp
 * on 2020/4/12
 * Function: 获取AppViewModelProvider
 */

private var appViewModelProvider: ViewModelProvider? = null


/**
 * 获取当前类绑定的泛型ViewModel-clazz
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}

private fun getAppViewModelProvider(application: Application): ViewModelProvider {
    if (appViewModelProvider == null) {
        appViewModelProvider = ViewModelProvider(
            ViewModelStoreOwner {
                //这里暂时未处理，后期可以存放全局被销毁后所保存的数据
                ViewModelStore()
            },
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
    }
    return appViewModelProvider!!
}

private fun checkApplication(activity: Activity?): Application {
    return activity?.application
        ?: throw IllegalStateException(
            "Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call."
        )
}

fun Activity.appViewModelProvider(): ViewModelProvider = getAppViewModelProvider(application)

fun Fragment.appViewModelProvider(): ViewModelProvider =
    getAppViewModelProvider(checkApplication(activity))




