package com.petterp.bullet.core.base

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.petterp.bullet.core.R
import com.petterp.bullet.core.base.basic.BaseActivity
import com.petterp.bullet.core.custom.NoScrollViewPager


/**
 * @Author petterp
 * @Date 2020/6/26-9:19 PM
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
abstract class BaseTabActivity : BaseActivity() {

    private lateinit var mlistener: ViewPager.OnPageChangeListener
    private lateinit var viewPager: NoScrollViewPager
    private lateinit var mBottomRes: BottomBean
    private var currentPosition = 0

    //LinearLayout
    private lateinit var viewMain: LinearLayout
    private val ivBottomTag by lazy {
        resources.getString(R.string.ivBottom)
    }
    private val tvBottomTag by lazy {
        resources.getString(R.string.tvBottom)
    }
    private val mBottomViews by lazy {
        mutableListOf<View>()
    }


    abstract fun getFragments(): List<Fragment>

    abstract fun bottomLayout(): Int

    open fun defaultPosition(): Int = 0


    abstract fun getBottomRes(): BottomBean

    open fun setTabLayout(): Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    /**
     * 初始化
     */
    override fun initView() {
        //如果用户选择自定义
        if (setTabLayout() == null) {
            viewMain = LinearLayout(this)
            viewMain.orientation = LinearLayout.VERTICAL
            viewMain.id = R.id.llMain
            viewMain.layoutParams = LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContentView(viewMain)
        } else {
            setContentView(setTabLayout()!!)
            viewMain = findViewById(R.id.llMain)
        }
        //初始化viewPager
        val fragments = getFragments()
        if (fragments.isNotEmpty()) {
            viewPager = NoScrollViewPager(this)
            viewPager.isScroll = isViewPagerScroll()
            viewPager.id = R.id.vpMain
            viewPager.adapter = BasePagerAdapter(supportFragmentManager, fragments)
            viewPager.offscreenPageLimit = fragments.size - 1
            viewPager.currentItem = defaultPosition()
            viewPager.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
            )
            //如果运行滑动，即监听滑动事件
            if (isViewPagerScroll()) {
                defaultPageChangeListener()
            }
            viewMain.addView(viewPager)
        }
        initBottomRes()
    }

    private fun defaultPageChangeListener() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                updateTab(position)
            }

        })
    }


    /** 滑动监听 */
    protected open fun addOnPagerListener(listener: ViewPager.OnPageChangeListener) {
        this.mlistener = listener
    }

    /**是否禁止滑动 false-禁止滑动*/
    protected open fun isViewPagerScroll(): Boolean = false

    /** viewPager指定位置 */
    protected fun setCurrentItem(position: Int, boolean: Boolean = false) {
        viewPager.setCurrentItem(position, false)
    }

    /** itemView初始化时的监听 */
    protected open fun initBottomItemView(i: Int, view: View) {}

    protected fun getViewPager(): ViewPager {
        return viewPager
    }

    /** 重写此方法实现底部tab的自定义 */
    @SuppressLint("WrongConstant")
    protected open fun initBottomRes() {
        mBottomRes = getBottomRes()
        with(mBottomRes) {
            if (mBottomImages.size != mBottomTexts.size) {
                throw  RuntimeException("The picture in the bottom navigation bar does not correspond to the length of the text!!")
            }
            val size = mBottomImages.size

            //先创建一个LinearLayout,再创建一条虚线+BottomLinearLayout
            val bottomLayout = LinearLayoutCompat(this@BaseTabActivity)
            bottomLayout.layoutParams = LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dip2px(height)
            )

            //设置底部bottom的方向
            bottomLayout.orientation = LinearLayoutCompat.VERTICAL

            val viewLine = View(this@BaseTabActivity)
            viewLine.layoutParams = LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dip2px(1f)
            )
            viewLine.setBackgroundColor(Color.parseColor("#f5f5f5"))

            val bottomItem = LinearLayoutCompat(this@BaseTabActivity)
            bottomItem.layoutParams = LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            bottomLayout.addView(bottomItem)
            viewMain.addView(bottomLayout)
            val defaultPosition = defaultPosition()
            currentPosition = defaultPosition

            for (i in 0 until size) {
                val view = LayoutInflater.from(this@BaseTabActivity)
                    .inflate(bottomLayout(), bottomItem, false)
                initBottomItemView(i, view)

                //设置每个item的点击事件
                view.setOnClickListener {
                    val position = it?.tag as Int
                    //避免重复加载问题
                    if (position != currentPosition) {
                        updateTab(position)
                    }
                }
                //加标记
                view.tag = i

                //拿到具体的itemView
                val itemIcon =
                    view.findViewWithTag<ImageView>(ivBottomTag)
                val itemTitle = view.findViewWithTag<TextView>(tvBottomTag)

                //初始化数据
                itemIcon.setImageResource(mBottomImages[i].second)
                itemTitle.text = mBottomTexts[i]
                itemTitle.setTextColor(mBottomTextColors.second)

                //判断是否被选中
                if (i == defaultPosition) {
                    itemIcon.setImageResource(mBottomImages[i].first)
                    itemTitle.setTextColor(mBottomTextColors.first)
                    itemTitle.textSize = mBottomTextSizes.first
                }
                //添加到布局中
                bottomItem.addView(view)
                //缓存具体的bottom-item-view
                mBottomViews.add(i, view)
            }
        }
    }


    /**
     * 重置方法，每次点击之后,别的颜色
     */
    private fun resetClear() {
        mBottomViews.forEachIndexed { index, it ->
            val itemIcon = it.findViewWithTag<AppCompatImageView>(ivBottomTag)
            val itemTitle = it.findViewWithTag<AppCompatTextView>(tvBottomTag)
            itemIcon.setImageResource(mBottomRes.mBottomImages[index].second)
            itemTitle.setTextColor(mBottomRes.mBottomTextColors.second)
            itemTitle.textSize = mBottomRes.mBottomTextSizes.second
        }
    }

    @Synchronized
    private fun updateTab(position: Int) {
        resetClear()
        val layout = mBottomViews[position]
        val itemIcon = layout.findViewWithTag<AppCompatImageView>(ivBottomTag)
        val itemTitle = layout.findViewWithTag<AppCompatTextView>(tvBottomTag)
        itemIcon.setImageResource(mBottomRes.mBottomImages[position].first)
        itemTitle.setTextColor(mBottomRes.mBottomTextColors.first)
        itemTitle.textSize = mBottomRes.mBottomTextSizes.first
        currentPosition = position
        viewPager.setCurrentItem(position, isViewPagerScroll())
    }

    /**
     * dp转px
     */
    private fun Context.dip2px(dpValue: Float): Int {
        val scale: Float = resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }


    /**
     * px转dp
     */
    private fun Context.px2dip(pxValue: Float): Int {
        val scale = resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}