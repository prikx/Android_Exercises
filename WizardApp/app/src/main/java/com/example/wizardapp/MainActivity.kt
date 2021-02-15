package com.example.wizardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("CHECK", "On Create")
    }

    override fun onStart() {
        super.onStart()
        Log.d("CHECK", "On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CHECK", "On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CHECK", "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CHECK", "On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CHECK", "On Destroy")
    }

    fun startWizard(view: View) {
        val intent = Intent(this, NameCollector::class.java).apply {  }
        startActivity(intent)
    }
}