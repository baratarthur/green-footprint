package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intencaoDechamada = Intent(this, MenuActivity::class.java)
        startActivity(intencaoDechamada)

    }

}