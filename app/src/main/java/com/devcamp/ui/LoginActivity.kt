package com.devcamp.ui

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.devcamp.Navigator
import com.devcamp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : Activity(){
    private var username : EditText? = null
    private var password : EditText? = null
    private var login : Button? = null
    private lateinit var usernameText : String
    private lateinit var passwordText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        username = usernameEditText
        password = passwordEditText
        login = loginButton

        login?.setOnClickListener { verifyLogin() }
    }

    private fun verifyLogin(){
        usernameText = username?.text.toString()
        passwordText = password?.text.toString()

        if(!usernameText.isBlank() && !passwordText.isBlank()){
            if(usernameText.equals("devcamp@teste.com") && passwordText.equals("devcamp2019")){
                doLogin()
            }
        } else {
            Toast.makeText(this,"Ops, tente de novo !", Toast.LENGTH_LONG).show()
        }
    }

    private fun doLogin(){
        Navigator(this).goToMainActivity(usernameText,passwordText)
    }
}
