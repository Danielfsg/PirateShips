package com.danielfsg.pirateships.data.mapper

import com.danielfsg.pirateships.data.model.PirateShipEntity
import com.danielfsg.pirateships.domain.model.PirateShip
import javax.inject.Inject

class PirateShipMapper @Inject constructor() {

    fun mapToEntity(pirateShip: PirateShipEntity?): PirateShip {
        return PirateShip(
            id = pirateShip?.id ?: 0,
            title = pirateShip?.title.orEmpty(),
            description = pirateShip?.description.orEmpty(),
            price = pirateShip?.price ?: 0,
            image = pirateShip?.image.orEmpty(),
            greetingType = pirateShip?.greetingType.orEmpty()
        )
    }

}