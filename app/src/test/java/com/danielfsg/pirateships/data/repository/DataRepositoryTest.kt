package com.danielfsg.pirateships.data.repository

import com.danielfsg.pirateships.data.mapper.PirateShipMapper
import com.danielfsg.pirateships.data.model.PirateShipEntity
import com.danielfsg.pirateships.data.model.PirateShipsResponse
import com.danielfsg.pirateships.data.remote.RetrofitService
import com.danielfsg.pirateships.domain.model.PirateShip
import io.reactivex.rxjava3.core.Single

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class DataRepositoryTest {

    private lateinit var repository: DataRepository

    @Mock
    lateinit var service: RetrofitService

    @Mock
    lateinit var mapper: PirateShipMapper

    @Before
    fun setUp() {
        repository = DataRepository(service, mapper)
    }

    @Test
    fun `test getPirateShips success`() {
        val mockPirateShipsResponse: PirateShipsResponse = mock()
        val mockPirateShipsEntity: PirateShipEntity = mock()
        val mockPirateShip: PirateShip = mock()

        whenever(mockPirateShipsResponse.ships).thenReturn(mutableListOf(mockPirateShipsEntity))
        whenever(service.getPirateShips()).thenReturn(Single.just(mockPirateShipsResponse))
        whenever(mapper.mapToPirateShip(any())).thenReturn(mockPirateShip)

        repository.getPirateShips()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it.isNotEmpty() }

        verify(service).getPirateShips()
        verify(mapper).mapToPirateShip(mockPirateShipsEntity)

    }

    @Test
    fun `test getPirateShips error`() {
        val mockError: Exception = mock()

        whenever(service.getPirateShips()).thenReturn(Single.error(mockError))

        repository.getPirateShips()
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it.isEmpty() }

        verify(service).getPirateShips()
    }

}