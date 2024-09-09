package com.example.testapex.presentation

import app.cash.turbine.test
import com.example.testapex.MainDispatcherRule
import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.domain.usecase.FetchCharactersUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeVieModelTest {

    private lateinit var viewmodel: HomeVieModel

    @Mock
    private lateinit var fetchCharactersUseCase: FetchCharactersUseCase

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun onSetup() {
        viewmodel = HomeVieModel(fetchCharactersUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testWhenViewmodelInvokeFetchUseCaseAndReturnResultValueSuccess() = runTest {

        `when`(fetchCharactersUseCase()).thenReturn(
            ResultValue.Success(
                listOf(
                    CharacterModel(
                        1,
                        "Dummy character",
                        ""
                    )
                )
            )
        )

        viewmodel.uiState.test {

            assertFalse(awaitItem().isLoading)
            viewmodel.fetchDataAction()
            advanceUntilIdle()
            assertTrue(awaitItem().characters.isNotEmpty())
        }

    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testWhenViewmodelInvokeFetchUseCaseAndReturnResultValueError() = runTest {

        `when`(fetchCharactersUseCase()).thenReturn(
            ResultValue.Error(
                DataError.Network.UNKNOWN
            )
        )

        viewmodel.uiState.test {
            assertFalse(awaitItem().isLoading)
            viewmodel.fetchDataAction()
            advanceUntilIdle()
            assertTrue(awaitItem().characters.isEmpty())
        }

    }
}