# CloudMVVM
基于JetPack-MVVM的开发框架，不同于大多数复杂化的框架,CloudMVVM 非常克制，没有去按照大多数那样去做一个复杂的框架，对于官方提供的工具，尽可能采用组合的方式，便于更简单的使用 Android-JetPack 开发工具。

[![](https://jitpack.io/v/Petterpx/CloudMVVM.svg)](https://jitpack.io/#Petterpx/CloudMVVM)

### 如何使用？

```groovy
allprojects {
    repositories {
   			
        maven { url 'https://jitpack.io' }
    }
}
```

> **为了便于更好的扩展及使用，CloudMVVM 区分了DataBinding 和 直接使用ViewModel实现手动绑定。**

```groovy
//不包含DataBinding的扩展，即默认的ViewModel实现手动绑定
implementation 'com.github.Petterpx:CloudMVVM:core:1.0.1' 
```

```groovy
//包含DataBinding的扩展
implementation 'com.github.Petterpx:CloudMVVM:databing_core:1.0.1'
```

很多开发者可能不习惯使用 **DataBinding**, 那么依赖 **core** 即可。 如果你习惯使用 **DataBinding**，那么直接依赖 **databing_core** 即可，内部已经包含了对于 **DataBinding** 的单独处理。



<br/>

## 相关核心类的介绍

#### BaseVMActivity && BaseVMFragment

适用于ViewModel 的通用Activity.具体使用详见使用demo.

<br/>

#### BaseTabActivity

适用于常见的tab页需求，对于一个 **tab** 页，只需要如下代码即可生成。

```kotlin
class TestTabActivity : BaseTabActivity() {
  
  	//fragments，使用的是FragmentPagerAdapter,所以不必担心传递整个list导致的内存泄漏问题
    override fun getFragments(): List<Fragment> {
        return listOf(ItemFragment(), ItemFragment())
    }
		
  	//你的底部布局,默认按照 图片-文字 排版，具体参照demo
    override fun bottomLayout(): Int {
        return R.layout.item_bottom_layout
    }

    override fun getBottomRes(): BottomBean {
        return BottomBean(
          	//选中tab图片 && 未选择图片 组
            mutableListOf(
                R.mipmap.ic_select to R.mipmap.ic_noselect,
                R.mipmap.ix_select to R.mipmap.ix_noselect
            )
            , mutableListOf("测试1", "测试2"),
          	//选中颜色 && 非选中颜色
            Color.RED to Color.WHITE,
          	//选中字体大小 && 非选中大小
            30f to 10f,
          	//底部bottomLayout高度
            80f
        )
    }
}
```

<br/>

#### BasePagerAdapter

通用的一个PagerAdapter 适用于少量 Fragment,内部配合 **behavior** 已完成懒加载处理。

<br/>

#### BaseDataBingActivity && BaseDataBingFragment

适用于 **Databinding**  的通用 Activity && Fragment.

> 注意 **binding** 变量 请谨慎使用，非必要场景下，**务必禁止使用，避免造成视图不一致的问题。**

<br/>

<br/>

<br/>

具体使用请参见Demo中的案例,如果在使用中有任何问题，欢迎提 issues,或者联系我的邮箱 ShiyihuiCloud@163.com





