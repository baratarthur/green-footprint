package com.iesb.greenfootprint.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        bt_cadNovoPlantio.setOnClickListener {
            val intencaoDechamada = Intent(this, DescreverPlantioActivity::class.java)
            startActivity(intencaoDechamada)
        }

    }


}