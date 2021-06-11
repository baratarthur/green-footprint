package com.iesb.greenfootprint.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.interector.ForgotInteractor
import kotlinx.android.synthetic.main.activity_forgot_password.*
import javax.inject.Inject

class ForgotPasswordActivity : AppCompatActivity() {

    @Inject
    lateinit var ForgotinInteractor: ForgotInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btForgotPassword.setOnClickListener {
            val email = twEmailForgotPassword.text.toString()

            try {
                ForgotinInteractor.signinWithUser(email)
                Log.d("auth", "")
            } catch (err: Error) {
                Log.d("ERROR", err.message.toString())
                Toast.makeText(this, "Erro no envio do Email", Toast.LENGTH_LONG).show()
                finish()
            }


        }
    }
}