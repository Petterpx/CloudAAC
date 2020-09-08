package com.cloud.mvvm.tab.data

/**
 * Created by Petterp
 * on 2020/4/15
 * Function: 底部导航栏-Bean
 */
data class BottomBean(
    //first 选中状态，second未选中
    val mBottomImages: MutableList<Pair<Int, Int>>,
    val mBottomTexts: MutableList<String>,
    val mBottomTextColors: Pair<Int, Int>,
    val mBottomTextSizes: Pair<Float, Float>,
    val height: Float
)