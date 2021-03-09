package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.wizardapp.database.AppDatabase
import com.example.wizardapp.database.UserDao

const val EXTRA_NAME = "com.example.wizardapp.NAME"

class NameCollector : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_collector)

        findViewById<EditText>(R.id.nameInput).setText(currentUser.name)

    }

    fun sendName(view: View) {
        val inputField = findViewById<EditText>(R.id.nameInput)
        val name = inputField.text.toString()
        currentUser.name = name

        db.userDao().update(currentUser)

        val intent = Intent(this, AddressCollector::class.java)
        startActivity(intent)
    }
}