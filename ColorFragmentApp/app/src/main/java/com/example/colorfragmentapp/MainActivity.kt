package com.example.colorfragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)
    }

    fun blue(view: View) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, BlueFragment())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun white(view: View) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, WhiteFragment())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun red(view: View) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, RedFragment())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun green(view: View) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, GreenFragment())
        ft.addToBackStack(null)
        ft.commit()
    }
}