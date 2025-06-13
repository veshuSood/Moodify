package com.example.moodify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    // ResultActivity.kt
// This activity displays the mood result, suggested quote, music link, and allows note-taking.



        private lateinit var tvMood: TextView
        private lateinit var tvQuote: TextView
        private lateinit var btnPlayMusic: Button
        private lateinit var etNotes: EditText
        private lateinit var btnDetectAgain: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            // Step 1: Link UI elements with their IDs
            tvMood = findViewById(R.id.tvMood)
            tvQuote = findViewById(R.id.tvQuote)
            btnPlayMusic = findViewById(R.id.btnPlayMusic)
            etNotes = findViewById(R.id.etNotes)
            btnDetectAgain = findViewById(R.id.btnDetectAgain)

            // Step 2: Get mood and quote from previous activity
            val mood = intent.getStringExtra("mood") ?: "Neutral"
            val quote = intent.getStringExtra("quote") ?: "Be yourself; everyone else is already taken."


            // Step 3: Display mood and quote on screen
            tvMood.text = "Current Vibe: $mood"
            tvQuote.text = when (mood) {
                "Happy" -> "Happiness is not something ready-made. It comes from your own actions."  // Happy quote
                "Sad" -> "Tears come from the heart and not from the brain"    // Sad quote
                "Angry" -> "For every minute you remain angry, you give up sixty seconds of peace of mind."
                "Nothing"-> "Every day may not be good... but there’s something good in every day"
                "Party" -> "Life is a party. Dress like it"
                "Love" -> "To love and be loved is to feel the sun from both sides"
                else -> "Be yourself; everyone else is already taken"  // Default
            }

            // Step 4: Play mood-based music when button is clicked

            btnPlayMusic.setOnClickListener {
                val cleanedMood = mood.trim()
                val moodMusicUrl = when (cleanedMood) {
                    "Happy" -> "https://open.spotify.com/playlist/37i9dQZF1DWTwbZHrJRIgD?si=9ffe22d6eb134aca"  // Happy song
                    "Sad" -> "https://open.spotify.com/playlist/1OupsYWGdAJepD9wbIOlad?si=5a8bc88909304f70"    // Sad song
                    "Angry" -> "https://open.spotify.com/playlist/5aB7AtfgnXlbAAvE8v90qJ?si=f2cb471bff494812"
                    "Nothing"-> "https://open.spotify.com/playlist/1x52zZhTAJakCP5GNjAnf1?si=d2b9ce010b6646db"
                    "Party" -> "https://open.spotify.com/playlist/737Sb1t2RdUfyXRWrEcWHA?si=29896d44b9e04dc2"
                    "Love" -> "https://open.spotify.com/playlist/0hDSACfKCw5sL5waVpV2lg?si=f6005d7811ae4c94"
                    else -> "https://open.spotify.com/playlist/0hDSACfKCw5sL5waVpV2lg?si=32ffe2ad32004c29"     // Default
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(moodMusicUrl))
                startActivity(intent)
            }

            // Step 5: Restart mood detection
            btnDetectAgain.setOnClickListener {
                finish() // Go back to previous screen
            }
        }
    }

