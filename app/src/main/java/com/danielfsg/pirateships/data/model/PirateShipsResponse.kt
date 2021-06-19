package com.danielfsg.pirateships.data.model

import com.google.gson.annotations.SerializedName

data class PirateShipsResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("ships") val ships: MutableList<PirateShipEntity?>
)