package com.example.filmlist.model


import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("actorName")
    val actorName: String
)