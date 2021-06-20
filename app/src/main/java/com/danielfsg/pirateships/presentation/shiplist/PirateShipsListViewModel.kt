package com.danielfsg.pirateships.presentation.shiplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.domain.usecase.GetPirateShipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PirateShipsListViewModel @Inject constructor(
    private val getPirateShipsUseCase: GetPirateShipsUseCase
) : ViewModel() {

    val pirateShipsLiveData = MutableLiveData<List<PirateShip>>()

    fun loadPirateShips() {
        getPirateShipsUseCase.execute(
            onSuccess = {
                pirateShipsLiveData.value = it
            },
            onError = {
                pirateShipsLiveData.value = listOf()
            },
            onComplete = {
                Timber.d("[PirateShipListViewModel]  -  get Pirate Ships UseCase COMPLETED")
            }
        )
    }
}