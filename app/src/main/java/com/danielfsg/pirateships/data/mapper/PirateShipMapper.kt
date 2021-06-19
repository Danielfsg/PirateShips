package com.danielfsg.pirateships.data.mapper

import com.danielfsg.pirateships.data.model.PirateShip
import com.danielfsg.pirateships.domain.model.PirateShipEntity
import javax.inject.Inject

class PirateShipMapper @Inject constructor() {

    fun mapToEntity(pirateShip: PirateShip?): PirateShipEntity {
        return PirateShipEntity(
            id = pirateShip?.id ?: 0,
            title = pirateShip?.title.orEmpty(),
            description = pirateShip?.description.orEmpty(),
            price = pirateShip?.price ?: 0,
            image = pirateShip?.image.orEmpty(),
            greetingType = pirateShip?.greetingType.orEmpty()
        )
    }

}