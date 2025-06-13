package com.example.moodify

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
        //animation
        val logo = findViewById<ImageView>(R.id.imageView)  // Get the logo view from the layout
        logo.alpha = 0f  // Make the logo fully transparent (invisible) initially
        logo.animate().alpha(1f).setDuration(2500).start()  // Animate the logo’s transparency to fully visible over 1.5 seconds


    }
}