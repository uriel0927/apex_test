package com.example.testapex.domain.usecase

import com.example.testapex.MainDispatcherRule
import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.domain.repository.CharactersRepository
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
class FetchCharactersUseCaseTest{

    @Mock
    private lateinit var repository: CharactersRepository

    private lateinit var fetchPlanetsUseCase: FetchCharactersUseCase

    @get:Rule
    val mainDIspatcherRule = MainDispatcherRule()

    @Before
    fun onSetup() {
        fetchPlanetsUseCase = FetchCharactersUseCase(repository)
    }

    @Test
    fun testFetchCharactersUseCaseAndRepositoryReturnResultValueSuccess() = runTest {
        `when`(repository.fetchCharacters()).thenReturn(ResultValue.Success(data = listOf(
            CharacterModel(1,"Dummy Character", "")
        )))

        val result = fetchPlanetsUseCase()

        assertTrue(result is ResultValue.Success)
    }

    @Test
    fun testFetchCharactersUseCaseAndRepositoryReturnResultValueError() = runTest {
        `when`(repository.fetchCharacters()).thenReturn(ResultValue.Error(DataError.Network.UNKNOWN))

        val result = fetchPlanetsUseCase()

        assertTrue(result is ResultValue.Error)
    }

}