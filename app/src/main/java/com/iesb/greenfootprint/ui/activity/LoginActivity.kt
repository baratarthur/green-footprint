package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.interector.SigninInteractor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var signinInteractor: SigninInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvForgotPassword.setOnClickListener {
            val forgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(forgotPassword)
        }

        btLogin.setOnClickListener {
            val email = twEmailLogin.text.toString()
            val password = twPasswordLogin.text.toString()

            try {
                signinInteractor.signinWithUser(email, password)
                Log.d("auth", "user logged with success")
            } catch (err: Error) {
                Log.d("ERROR", err.message.toString())
                Toast.makeText(this, "Problemas na criacao de conta", Toast.LENGTH_LONG).show()
            }
        }
    }

}