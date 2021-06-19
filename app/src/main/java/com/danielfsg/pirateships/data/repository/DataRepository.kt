package com.danielfsg.pirateships.data.repository

import com.danielfsg.pirateships.data.mapper.PirateShipMapper
import com.danielfsg.pirateships.data.remote.RetrofitService
import com.danielfsg.pirateships.domain.model.PirateShipEntity
import com.danielfsg.pirateships.domain.repository.Repository
import io.reactivex.Single

class DataRepository(
    private val retrofitService: RetrofitService,
    private val mapper: PirateShipMapper
) : Repository {

    override fun getPirateShips(): Single<List<PirateShipEntity>> {
        return retrofitService.getPirateShips()
            .toFlowable()
            .flatMapIterable { it.ships }
            .map { mapper.mapToEntity(it) }
            .toList()
    }

}