package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.getBooleanExtra("LOGOUT", false))
            finish();

    }

    fun play(view: View){
        val intent = Intent(this, ActivityQuestions::class.java)
        startActivity(intent)
    }
}