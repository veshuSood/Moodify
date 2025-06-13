package com.example.moodify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val moods = listOf("Happy", "Sad", "Love", "Party", "Angry", "nothing")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Mood clickable views
        findViewById<LinearLayout>(R.id.moodHappy).setOnClickListener { goToResult("Happy") }
        findViewById<LinearLayout>(R.id.moodSad).setOnClickListener { goToResult("Sad") }
        findViewById<LinearLayout>(R.id.moodAngry).setOnClickListener { goToResult("Angry") }
        findViewById<LinearLayout>(R.id.moodLove).setOnClickListener { goToResult("Love") }
        findViewById<LinearLayout>(R.id.moodParty).setOnClickListener { goToResult("Party") }
        findViewById<LinearLayout>(R.id.moodNothing).setOnClickListener { goToResult("Nothing") }


        //surprise me btn
        findViewById<Button>(R.id.btnSurpriseMe).setOnClickListener {
            val randomMood = moods.random()
            goToResult(randomMood)

        }
    }
    private fun goToResult(selectedMood: String) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("mood", selectedMood)
            startActivity(intent)
        }
}