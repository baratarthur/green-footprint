package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R
import kotlinx.android.synthetic.main.activity_menu_login_sign.*


class MenuLoginSignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login_sign)

        bt_loginMain.setOnClickListener{
            val ChamadaLogin = Intent(this, LoginActivity::class.java)
            startActivity(ChamadaLogin)

        }
        bt_cadastroMain.setOnClickListener{
            val ChamadaSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(ChamadaSignUp)
        }
    }
}