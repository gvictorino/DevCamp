package com.devcamp

import android.app.Activity
import android.content.Intent
import com.devcamp.ui.LoginActivity

class Navigator(var activity: Activity) {

    fun goToLogin() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(intent)
        activity.finish()
    }
}