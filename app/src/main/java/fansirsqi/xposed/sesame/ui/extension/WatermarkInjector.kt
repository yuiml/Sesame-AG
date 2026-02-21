package fansirsqi.xposed.sesame.ui.extension

import android.app.Activity

/**
 * 专门供 Java Activity 调用的辅助类
 */
object WatermarkInjector {
    @JvmStatic
    fun inject(@Suppress("UNUSED_PARAMETER") activity: Activity) = Unit
}
