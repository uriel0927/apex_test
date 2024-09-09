package com.example.testapex.data.datasource.remote

import com.example.testapex.data.model.network.CharacterResponseApiModel
import com.example.testapex.data.network.CharacterApiService
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.Error
import com.example.testapex.domain.model.ResultValue
import javax.inject.Inject

class RemoteCharactersDatasourceImpl @Inject constructor(private val apiService: CharacterApiService) : RemoteCharactersDatasource(){

    override suspend fun fetchAllCharacters(): ResultValue<CharacterResponseApiModel,DataError.Network> {
        return safeCallApi {apiService.getCharacters()}
    }

}