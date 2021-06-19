package com.danielfsg.pirateships.domain.usecase

import com.danielfsg.pirateships.base.SingleUseCase
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.domain.repository.Repository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPirateShipsUseCase @Inject constructor(
    private val repository: Repository
) : SingleUseCase<List<PirateShip>>() {

    override fun build(): Single<List<PirateShip>> {
        return repository.getPirateShips()
    }
}