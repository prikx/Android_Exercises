package com.example.chuckthreadapp

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.animation.Animation
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call


class MainActivity : AppCompatActivity() {

    private lateinit var gson : Gson
    private lateinit var retrofit: Retrofit
    private lateinit var joker : RandomJokes
    private lateinit var workerThread : Thread
    private lateinit var textView : TextView
    private val BASE_URL = "https://api.icndb.com"
    private var running : Boolean = true

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        gson = GsonBuilder()
            .setDateFormat("dd-mm-yyyy'T'HH:mm:ssZ")
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        joker = retrofit.create(RandomJokes::class.java)

        workerThread = Thread {
            while (running) {
                val jokeSon = joker.getJoke()

                val joke = jokeSon.execute().body()
                val jokeText = Html.fromHtml(joke?.value?.joke, 0).toString()

                textView.post({textView.setText(jokeText)})

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