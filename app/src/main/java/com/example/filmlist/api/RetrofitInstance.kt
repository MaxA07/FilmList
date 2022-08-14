package com.example.filmlist.api

import com.example.filmlist.utils.Constants.Companion.BASE_URL
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: FilmApi by lazy {
        retrofit.create(FilmApi::class.java)
    }

}