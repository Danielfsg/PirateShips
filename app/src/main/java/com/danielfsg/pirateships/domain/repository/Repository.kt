package com.danielfsg.pirateships.domain.repository

import com.danielfsg.pirateships.domain.model.PirateShipEntity
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getPirateShips(): Single<List<PirateShipEntity>>
}