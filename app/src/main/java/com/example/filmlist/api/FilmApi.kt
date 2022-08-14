package com.example.filmlist.api

import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import retrofit2.Response
import retrofit2.http.GET

interface FilmApi {

    @GET("constanta-android-dev/intership-wellcome-task/main/films.json")
    suspend fun getFilm(): Films

    @GET("constanta-android-dev/intership-wellcome-task/main/films.json")
    suspend fun getActor(): Actor
}