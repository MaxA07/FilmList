package com.example.filmlist.model


import com.google.gson.annotations.SerializedName

data class Films(
    @SerializedName("items")
    val items: List<Item>
)