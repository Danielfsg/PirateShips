package com.danielfsg.pirateships.presentation.shipdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.danielfsg.pirateships.domain.model.PirateShip
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class PirateShipDetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: PirateShipDetailViewModel

    @Mock
    lateinit var observer: Observer<PirateShip>

    @Before
    fun setUp() {
        viewModel = PirateShipDetailViewModel()
        viewModel.pirateShipLiveData.observeForever(observer)
    }

    @Test
    fun getPirateShipLiveData() {
        val pirateShip = PirateShip(1, "title", "description", "price", "image", "greetingType")

        viewModel.loadPirateShipDetails(pirateShip)

        verify(observer).onChanged(pirateShip)
    }
}