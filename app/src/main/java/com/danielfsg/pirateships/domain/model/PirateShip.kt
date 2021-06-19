package com.danielfsg.pirateships.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PirateShip(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val image: String,
    val greetingType: String
):Parcelable