package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_ADDRESS = "com.example.AddressCollector.ADDRESS"

class AddressCollector : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_collector)

        findViewById<EditText>(R.id.addressInput).setText(currentUser.address1)
        findViewById<EditText>(R.id.addressInput2).setText(currentUser.address2)
    }

    fun sendAddress(view: View) {
        val inputField = findViewById<EditText>(R.id.addressInput)
        val inputField2 = findViewById<EditText>(R.id.addressInput2)

        currentUser.address1 = inputField.text.toString()
        currentUser.address2 = inputField2.text.toString()
        db.userDao().update(currentUser)

        val intent = Intent(this, DateCollector::class.java)
        startActivity(intent)
    }
}