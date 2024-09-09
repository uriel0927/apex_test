package com.example.testapex.data.network

import com.example.testapex.data.model.network.CharacterResponseApiModel
import retrofit2.http.GET

/**
 * Interface that represent all the method or action that the api provide
 */
interface CharacterApiService {

    @GET("/api/character")
    suspend fun getCharacters() : CharacterResponseApiModel

}