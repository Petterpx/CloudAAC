package com.cloud.mvvm.core.ktx

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

/**
 * Created by Petterp
 * on 2020/4/12
 * Function: 获取AppViewModelProvider
 */
private var appViewModelProvider: ViewModelProvider? = null

fun getAppViewModelProvider(application: Application): ViewModelProvider {
    if (appViewModelProvider == null) {
        appViewModelProvider = ViewModelProvider(
            ViewModelStore(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )
    }
    return appViewModelProvider!!
}


/**
 * 获取当前类绑定的泛型ViewModel-clazz
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}

fun <VM> createViewModel(owner: ViewModelStoreOwner, cls: Any): VM {
    return ViewModelProvider(owner).get(getVmClazz(cls))
}


