package com.example.mvvm_app

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    private val jokes = listOf<Joke>(Joke("hahah funy"), Joke("Another funy one"), Joke("haha yes funy is written funny, but i am not"))
    val joke = MutableLiveData<Joke>()

    fun randomJoke() {
        joke.value = jokes.random()
    }
}

data class Joke(val joke: String)