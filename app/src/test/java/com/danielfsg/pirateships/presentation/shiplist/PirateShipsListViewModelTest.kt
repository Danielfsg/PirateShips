package com.danielfsg.pirateships.presentation.shiplist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.danielfsg.pirateships.domain.model.PirateShip
import com.danielfsg.pirateships.domain.usecase.GetPirateShipsUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
class PirateShipsListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: PirateShipsListViewModel

    @Mock
    lateinit var observer: Observer<List<PirateShip>>

    @Mock
    lateinit var useCase: GetPirateShipsUseCase

    private val onSuccessCaptor = argumentCaptor<(List<PirateShip>) -> Unit>()
    private val onErrorCaptor = argumentCaptor<(Throwable) -> Unit>()
    private val onCompleteCaptor = argumentCaptor<() -> Unit>()

    @Before
    fun setUp() {
        viewModel = PirateShipsListViewModel(useCase)
        viewModel.pirateShipsLiveData.observeForever(observer)
    }

    @Test
    fun `test getPirateShipsLiveData success`() {
        val pirateShip = PirateShip(1, "title", "description", "price", "image", "greetingType")

        viewModel.loadPirateShips()

        verify(useCase).execute(
            onSuccessCaptor.capture(),
            onErrorCaptor.capture(),
            onCompleteCaptor.capture()
        )

        onSuccessCaptor.firstValue.invoke(listOf(pirateShip))
        onCompleteCaptor.firstValue.invoke()

        verify(observer).onChanged(listOf(pirateShip))
    }

    @Test
    fun `test getPirateShipsLiveData error`() {
        val mockError: Exception = mock()

        viewModel.loadPirateShips()

        verify(useCase).execute(
            onSuccessCaptor.capture(),
            onErrorCaptor.capture(),
            onCompleteCaptor.capture()
        )

        onErrorCaptor.firstValue.invoke(mockError)
        onCompleteCaptor.firstValue.invoke()

        verify(observer).onChanged(listOf())
    }
}