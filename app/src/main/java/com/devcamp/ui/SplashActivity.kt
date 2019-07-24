package com.devcamp.ui

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.devcamp.Navigator
import com.devcamp.R

class SplashActivity : Activity(){
    companion object {
       private const val SPLASH_DURATION = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
    }

    public override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            Navigator(this).goToLogin()
        }, SPLASH_DURATION.toLong())
    }
}