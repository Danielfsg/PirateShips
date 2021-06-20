package com.danielfsg.pirateships.domain.usecase

import com.danielfsg.pirateships.data.repository.DataRepository
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetPirateShipsUseCaseTest {

    private lateinit var getPirateShipsUseCase: GetPirateShipsUseCase

    @Mock
    lateinit var repository: DataRepository

    @Before
    fun setUp() {
        getPirateShipsUseCase = GetPirateShipsUseCase(repository)
    }

    @Test
    fun build() {
        whenever(repository.getPirateShips()).thenReturn(Single.just(listOf()))

        getPirateShipsUseCase.build()
            .test()
            .assertComplete()
            .assertNoErrors()

    }
}