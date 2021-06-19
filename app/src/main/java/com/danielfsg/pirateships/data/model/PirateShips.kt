package com.danielfsg.pirateships.data.model

import com.google.gson.annotations.SerializedName

data class PirateShips(
    @SerializedName("ships") val ships: MutableList<PirateShip?>
)