package com.example.mvvm_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModel = AppViewModel()

        textView = findViewById(R.id.jokeText)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            myViewModel.randomJoke()
        }

        myViewModel.joke.observe(this, {joke ->
            textView.text = joke.joke})
    }

}