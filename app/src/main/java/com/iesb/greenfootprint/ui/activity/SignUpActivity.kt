package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.iesb.greenfootprint.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import com.iesb.greenfootprint.interector.SignUpInteractor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    @Inject lateinit var signUpInteractor: SignUpInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btSingUp.setOnClickListener {
            val email = twEmail.text.toString()
            val password = twPassword.text.toString()
            val confirmPassword = twConfirmPassword.text.toString()
            try {
                signUpInteractor.createUserAndSignIn(email, password, confirmPassword)
            } catch (err: Error) {
                Log.d("ERROR", err.message.toString())
                Toast.makeText(this, "Problemas na criacao de conta", Toast.LENGTH_LONG).show()
            }

        }
    }
}