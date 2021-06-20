package com.danielfsg.pirateships.presentation.shipdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielfsg.pirateships.domain.model.PirateShip
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PirateShipDetailViewModel @Inject constructor() : ViewModel() {

    val pirateShipLiveData = MutableLiveData<PirateShip>()

    fun loadPirateShipDetails(pirateShip: PirateShip) {
        pirateShipLiveData.value = pirateShip
    }
}