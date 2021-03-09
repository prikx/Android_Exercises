package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Summary : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val name = currentUser.name
        val address = currentUser.address1 + "\n" + currentUser.address2
        val date = currentUser.birthday

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