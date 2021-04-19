package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R
import kotlinx.android.synthetic.main.activity_menu_app.*

class MenuAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_app)

        bt_cadNovoPlantio.setOnClickListener{
            val ChamadaAvaliacao = Intent(this, AvaliacaoActivity::class.java)
            startActivity(ChamadaAvaliacao)
        }
    }
}