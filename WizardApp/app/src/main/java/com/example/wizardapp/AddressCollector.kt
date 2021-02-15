package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_ADDRESS = "com.example.AddressCollector.ADDRESS"

class AddressCollector : AppCompatActivity() {

    var name: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_collector)

        name = intent.getStringExtra(EXTRA_NAME).toString()
    }

    fun sendAddress(view: View) {
        val inputField = findViewById<EditText>(R.id.addressInput)
        val inputField2 = findViewById<EditText>(R.id.addressInput2)
        val address = inputField.text.toString() + "\n" + inputField2.text.toString()
        val intent = Intent(this, DateCollector::class.java).apply{
            putExtra(EXTRA_NAME, name)
            putExtra(EXTRA_ADDRESS, address)
        }
        startActivity(intent)
    }
}