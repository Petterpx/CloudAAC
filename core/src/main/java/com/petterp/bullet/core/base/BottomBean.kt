package com.petterp.bullet.core.base

/**
 * Created by Petterp
 * on 2020/4/15
 * Function: 底部导航栏
 */
data class BottomBean(
    //first 选中状态，second未选中
    val mBottomImages: MutableList<Pair<Int, Int>>,
    val mBottomTexts: MutableList<String>,
    val mBottomTextColors: Pair<Int, Int>,
    val mBottomTextSizes: Pair<Float, Float>,
    val height: Float
)