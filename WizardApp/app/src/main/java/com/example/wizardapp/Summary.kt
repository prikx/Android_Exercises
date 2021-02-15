package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Summary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val name = intent.getStringExtra(EXTRA_NAME)
        val address = intent.getStringExtra(EXTRA_ADDRESS)
        val date = intent.getStringExtra(EXTRA_DATE)

        val summary: String = name + "\n" + date + "\n\n" + address
        val textView = findViewById<TextView>(R.id.summaryText).apply{
            text = summary
        }
    }

    fun goBack(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply{ }
        startActivity(intent)
    }
}