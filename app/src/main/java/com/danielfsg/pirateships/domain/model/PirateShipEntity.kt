package com.danielfsg.pirateships.domain.model

data class PirateShipEntity(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val image: String,
    val greetingType: String
)