package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_DATE = "com.example.DateCollector.EXTRA_DATE"

class DateCollector : AppCompatActivity() {

    var name: String = ""
    var address: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_collector)

        name = intent.getStringExtra(EXTRA_NAME).toString()
        address = intent.getStringExtra(EXTRA_ADDRESS).toString()

    }

    fun sendDate(view: View) {
        val inputField = findViewById<EditText>(R.id.dateInput)
        val date = inputField.text.toString()
        val intent = Intent(this, Summary::class.java).apply{
            putExtra(EXTRA_NAME, name)
            putExtra(EXTRA_ADDRESS, address)
            putExtra(EXTRA_DATE, date)
        }
        startActivity(intent)
    }
}