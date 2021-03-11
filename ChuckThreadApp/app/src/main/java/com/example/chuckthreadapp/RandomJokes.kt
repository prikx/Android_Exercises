package com.example.chuckthreadapp

import retrofit2.Call
import retrofit2.http.GET

interface RandomJokes {

    @GET("/jokes/random")
    fun getJoke() : Call<Joke>
}