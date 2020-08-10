package com.petterp.bullet.core.net

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

/**
 * @Author petterp
 * @Date 2020/6/11-6:53 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class NetworkStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.getSystemService(Context.CONNECTIVITY_SERVICE)?.let {
            val cm = it as ConnectivityManager
            cm.activeNetworkInfo?.let { networkInfo ->
                networkInfo.type//网络类型
                NetObserver.isNetEnable = networkInfo.isConnected//是否连接
                NetObserver.isAvailable()
                return
            }
            NetObserver.isNetEnable = false
            NetObserver.isNetAvailable = false
        }
    }

}
