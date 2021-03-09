package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_DATE = "com.example.DateCollector.EXTRA_DATE"

class DateCollector : MainActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_collector)

        findViewById<EditText>(R.id.dateInput).setText(currentUser.birthday)
    }

    fun sendDate(view: View) {
        val inputField = findViewById<EditText>(R.id.dateInput)

        currentUser.birthday = inputField.text.toString()

        db.userDao().update(currentUser)

        val intent = Intent(this, Summary::class.java)
        startActivity(intent)
    }
}