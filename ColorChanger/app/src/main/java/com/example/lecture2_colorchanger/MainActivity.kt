package com.example.lecture2_colorchanger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toColorCanvas(view: View) {
        intent = Intent(this, ColorCanvas::class.java)
        startActivity(intent)
    }

    fun toColorSimon(view: View) {
        intent = Intent(this, ColorSimon::class.java)
        startActivity(intent)
    }
}