package cn.cctech.kccommand.utils

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import cn.cctech.kccommand.fragments.base.LazyFragment

inline fun <reified T> Activity.findView(@IdRes res: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById<View>(res) as T
}

inline fun <reified T> LazyFragment.findView(@IdRes res: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById(res) as T
}

inline fun <reified T> View.findView(@IdRes res: Int): T {
    @Suppress("UNCHECKED_CAST")
    return findViewById<View>(res) as T
}

inline fun <reified T> Activity.findViewLazy(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById<View>(res) as T }
}

inline fun <reified T> LazyFragment.findViewLazy(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById(res) as T }
}

inline fun <reified T> View.findViewLazy(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById<View>(res) as T }
}