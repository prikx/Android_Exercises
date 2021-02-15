package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_NAME = "com.example.wizardapp.NAME"

class NameCollector : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_collector)
    }

    fun sendName(view: View) {
        val inputField = findViewById<EditText>(R.id.nameInput)
        val name = inputField.text.toString()
        val intent = Intent(this, AddressCollector::class.java).apply{
            putExtra(EXTRA_NAME, name)
        }
        startActivity(intent)
    }
}