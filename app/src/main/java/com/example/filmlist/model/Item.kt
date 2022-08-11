package com.example.filmlist.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("actors")
    val actors: List<Actor>,
    @SerializedName("directorName")
    val directorName: String,
    @SerializedName("releaseYear")
    val releaseYear: Int,
    @SerializedName("title")
    val title: String
)