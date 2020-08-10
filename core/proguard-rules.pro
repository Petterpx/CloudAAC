# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 不混淆core下的所有类
-keep  class com.petterp.bullet.core.base.** { *; }

-keep public class  com.petterp.bullet.core.base.BottomBean { *; }


# 不混淆指定的其子类
-keep public class * extends com.petterp.bullet.core.base.basic.BaseActivity { *; }
-keep public class * extends com.petterp.bullet.core.base.basic.BaseFragment { *; }
-keep public class * extends com.petterp.bullet.core.base.BaseTabActivity { *; }
-keep public class * extends com.petterp.bullet.core.base.BaseVMActivity { *; }
-keep public class * extends com.petterp.bullet.core.base.BaseVMFragment { *; }
-keep public class * extends com.petterp.bullet.core.base.BasePagerAdapter { *; }