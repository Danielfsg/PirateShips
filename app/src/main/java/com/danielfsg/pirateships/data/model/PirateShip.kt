package com.danielfsg.pirateships.data.model

import com.google.gson.annotations.SerializedName

data class PirateShip(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Int,
    @SerializedName("image") val image: String,
    @SerializedName("greeting_type") val greetingType: String? = null
)