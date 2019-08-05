package com.devcamp.tv

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.SystemClock
import android.view.View

var lastClickTime: Long = 0

fun Activity.unselectedViews(vararg views: View) {
    for (view in views) {
        view.isSelected = false
    }
}

fun Activity.whichViewIsSelected(vararg views: View): Int {
    for (view in views) {
        if (view.isSelected) {
            return view.id
        }
    }
    return 0
}

fun View.focusDelayed(): View {
    Handler().postDelayed({ requestFocus() }, 100)
    return this
}

fun View.selected(): View {
    isSelected = true
    return this
}

inline fun Context.preventMultipleClick(action: () -> Unit) {
    if (SystemClock.elapsedRealtime() - lastClickTime < 800) {
        return
    }
    lastClickTime = SystemClock.elapsedRealtime()
    action()
}