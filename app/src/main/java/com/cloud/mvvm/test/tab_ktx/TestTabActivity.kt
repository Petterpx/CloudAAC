package com.cloud.mvvm.test.tab_ktx

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.cloud.mvvm.test.R
import com.cloud.mvvm.tab.base.BaseTabActivity
import com.cloud.mvvm.tab.data.BottomBean

/**
 * @Author petterp
 * @Date 2020/8/10-5:10 PM
 * @Email ShiyihuiCloud@163.com
 * @Function 示例TabActivity
 */
class TestTabActivity : BaseTabActivity() {

    //fragments，使用的是FragmentPagerAdapter,所以不必担心传递整个list导致的内存泄漏问题
    override fun getFragments(): List<Fragment> {
        return listOf(
            ItemFragment(),
            ItemFragment()
        )
    }

    //你的底部布局,默认按照 图片-文字 排版
    override fun bottomLayout(): Int {
        return R.layout.item_bottom_layout
    }

    override fun getBottomRes(): BottomBean {
        return BottomBean(
            //选中tab图片 && 未选择图片 组
            mutableListOf(
                R.mipmap.ic_launcher to R.mipmap.ic_launcher,
                R.mipmap.ic_launcher to R.mipmap.ic_launcher
            )
            //底部tab-title
            , mutableListOf("item1", "item2"),
            //选中颜色 && 非选中颜色
            Color.RED to Color.WHITE,
            //选中字体大小 && 非选中大小
            30f to 10f,
            //底部bottomLayout高度
            80f
        )
    }

}