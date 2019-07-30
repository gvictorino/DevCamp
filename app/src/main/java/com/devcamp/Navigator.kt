package com.devcamp

import android.app.Activity
import android.content.Intent
import com.devcamp.ui.LoginActivity
import com.devcamp.ui.main.MainActivity

class Navigator(var activity: Activity) {

    fun goToLogin() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(intent)
        activity.finish()
    }

    fun goToMainActivity(username: String, password: String) {
        val intent = Intent(activity, MainActivity::class.java).apply {

        }

        activity.startActivity(intent)
    }
}