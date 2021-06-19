package com.danielfsg.pirateships.data.model

import com.google.gson.annotations.SerializedName

data class PirateShip(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("greeting_type") val greetingType: String? = null
)