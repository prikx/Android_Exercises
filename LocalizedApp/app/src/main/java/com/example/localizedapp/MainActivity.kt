package com.example.localizedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes

class MainActivity : AppCompatActivity() {

    var i = 0
    val picIds = arrayOf<Int>(R.drawable.pexels_photo, R.drawable.pexels_photo_210723, R.drawable.pexels_photo_462353, R.drawable.pexels_photo_62592)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nextPicture(view: View) {
        findViewById<ImageView>(R.id.imageShow).setImageResource(picIds[i])
        i++
        if (i > 3) {
            i = 0
        }
    }

    fun previousPicture(view:View) {
        findViewById<ImageView>(R.id.imageShow).setImageResource(picIds[i])
        i--
        if (i < 0) {
            i = 3
        }
    }
}