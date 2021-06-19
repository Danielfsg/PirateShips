package com.danielfsg.pirateships.domain.repository

import com.danielfsg.pirateships.domain.model.PirateShipEntity
import io.reactivex.Single

interface Repository {
    fun getPirateShips(): Single<List<PirateShipEntity>>
}