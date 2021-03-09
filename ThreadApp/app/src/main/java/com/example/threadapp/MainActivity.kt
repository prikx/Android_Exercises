package com.example.threadapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var workerThread : Thread
    private var running = true

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        workerThread = Thread {
            while(running) {
                val randomString = RandomString()

                textView.post({textView.setText(randomString.string)})

                try {
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        workerThread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        running = false
        try {
            workerThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}