package com.example.testapex.domain.repository

import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue

interface CharactersRepository {

    /**
     * Fetch all characters
     */
    suspend fun fetchCharacters() :  ResultValue<List<CharacterModel>, DataError>

}