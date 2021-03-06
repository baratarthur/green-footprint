package com.iesb.greenfootprint.ui.activity.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iesb.greenfootprint.R
import com.iesb.greenfootprint.ui.activity.AuthActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash_screen)
        GlobalScope.launch(context = Dispatchers.Main) {
            delay(2500)
            chamaMenu()
        }
    }
    private fun chamaMenu(){
        val ChamadaMenu = Intent(this, AuthActivity::class.java)
        startActivity(ChamadaMenu)
    }
}