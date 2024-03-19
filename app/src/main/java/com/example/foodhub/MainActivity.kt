package com.example.foodhub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodhub.R
import com.example.foodhub.ui.SplashActivity
import com.example.foodhub.ui.WelcomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        moveToSplashScreen()
    }

    private fun moveToSplashScreen() {
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
    }
}