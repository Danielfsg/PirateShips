package com.danielfsg.pirateships.data.mapper

import com.danielfsg.pirateships.data.model.PirateShip
import com.danielfsg.pirateships.domain.model.PirateShipEntity
import javax.inject.Inject

class PirateShipMapper @Inject constructor() {

    fun mapToEntity(pirateShip: PirateShip): PirateShipEntity {
        return PirateShipEntity(
            id = pirateShip.id,
            title = pirateShip.title,
            description = pirateShip.description,
            price = pirateShip.price,
            image = pirateShip.image,
            greetingType = pirateShip.greetingType.orEmpty()
        )
    }

}