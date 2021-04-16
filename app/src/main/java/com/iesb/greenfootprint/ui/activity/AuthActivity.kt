package com.iesb.greenfootprint.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R

// O layout dessa activity é responsavel por mostrar as telas de login/cadastro/forgot e a inicial do app

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}