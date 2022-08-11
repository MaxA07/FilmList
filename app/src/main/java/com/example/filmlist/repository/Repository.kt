package com.example.filmlist.repository

import com.example.filmlist.api.RetrofitInstance
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import com.example.filmlist.model.Item
import retrofit2.Response

class Repository {

    suspend fun getFilm(): Response<Films> {
        return RetrofitInstance.api.getFilm()
    }

    suspend fun getActor(): Response<Actor> {
        return RetrofitInstance.api.getActor()
    }
}