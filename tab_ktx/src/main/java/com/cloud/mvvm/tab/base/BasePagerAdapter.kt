package com.cloud.mvvm.tab.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Petterp
 * on 2020/3/27
 * Function:通用Vp-Adapter
 * 注意 在FragmentPagerAdapter时，这样使用无问题
 */
class BasePagerAdapter(fm: FragmentManager, private var list: List<Fragment>, behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) : FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }
}
