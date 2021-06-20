package com.danielfsg.pirateships.data.repository

import com.danielfsg.pirateships.data.mapper.PirateShipMapper
import com.danielfsg.pirateships.data.remote.RetrofitService
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.domain.repository.Repository
import io.reactivex.rxjava3.core.Single
import timber.log.Timber

class DataRepository(
    private val retrofitService: RetrofitService,
    private val mapper: PirateShipMapper
) : Repository {

    override fun getPirateShips(): Single<List<PirateShip>> {
        Timber.d("[DataRepository]  -  Get Pirate Ships")
        return retrofitService.getPirateShips()
            .toFlowable()
            .map { pirateShips ->
                pirateShips.ships.removeAll { it == null }
                pirateShips
            }
            .flatMapIterable { it.ships }
            .map { mapper.mapToPirateShip(it) }
            .toList()
            .doOnSuccess { Timber.d("[DataRepository]  -  Success fetching the pirate ships") }
            .doOnError { Timber.e(it, "[DataRepository]  -  Error") }
            .onErrorReturn { listOf() }
    }

}