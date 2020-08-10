package com.petterp.bullet.core.net

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import com.petterp.bullet.core.KtxContext
import java.io.IOException

/**
 * @Author petterp
 * @Date 2020/6/11-6:45 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
object NetObserver {

    internal var isNetEnable = false
    internal var isNetAvailable = false
    private var connectivityManager: ConnectivityManager? = null

    private fun initConnectivityManager(context: Context) {
        connectivityManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getSystemService(ConnectivityManager::class.java) ?: null
        } else {
            context.getSystemService(Context.CONNECTIVITY_SERVICE)?.let {
                it as ConnectivityManager
            }
        }
    }

    internal fun init(context: Context) {
        connectivityManager ?: initConnectivityManager(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val networkRequest = NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build()
            connectivityManager?.registerNetworkCallback(networkRequest, object :
                ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {//有可用网络
                    super.onAvailable(network)
                    val networkCapabilities = connectivityManager?.getNetworkCapabilities(network)
                    networkCapabilities?.let {
                        isNetEnable = true
                        //获取网络类型
                        val isWIFI = it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        val isMobile = it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        isAvailable()
                    }
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    isNetEnable = false
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    isNetEnable = false
                }
            })
        } else {
            //Android N以下通过广播监听
            val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            context.registerReceiver(NetworkStateReceiver(), intentFilter)
        }
    }

    fun getNetAvailable(): Boolean = isNetEnable == isNetAvailable

    fun isAvailable(): Boolean {
        //        try {
        //            val s = Socket()
        //            //国内使用114.114.114.114，如果全球通用google：8.8.8.8
        //            val host = InetAddress.getByName("8.8.8.8")
        //            s.connect(InetSocketAddress(host, 53), 5000)
        //            s.close()
        //           } catch (e: IOException) {
        //        }

        //如果status==0则表示网络可用，其中参数-c 1是指ping的次数为1次，-w是指超时时间单位为s
        try {
            val process = Runtime.getRuntime().exec("/system/bin/ping -c 1 -w 100 www.baidu.com")
            val status = process.waitFor()
            isNetAvailable = status == 0
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            return isNetAvailable
        }
    }
}

