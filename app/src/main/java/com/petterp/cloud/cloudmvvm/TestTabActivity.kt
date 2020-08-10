package com.petterp.cloud.cloudmvvm

import android.graphics.Color
import androidx.fragment.app.Fragment
import com.petterp.bullet.core.base.BaseTabActivity
import com.petterp.bullet.core.base.BottomBean
import com.petterp.cloud.cloudmvvm.tab.ItemFragment

/**
 * @Author petterp
 * @Date 2020/8/10-5:10 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class TestTabActivity : BaseTabActivity() {
    override fun getFragments(): List<Fragment> {
        return listOf(ItemFragment(), ItemFragment())
    }

    override fun bottomLayout(): Int {
        return R.layout.item_bottom_layout
    }

    override fun getBottomRes(): BottomBean {
        return BottomBean(
            mutableListOf(
                R.mipmap.ic_launcher to R.mipmap.ic_launcher,
                R.mipmap.ic_launcher to R.mipmap.ic_launcher
            )
            , mutableListOf("item1", "item2"),
            Color.RED to Color.WHITE,
            30f to 10f,
            80f
        )
    }
}