package com.example.testapex.data.repository

import com.example.testapex.data.datasource.remote.RemoteCharactersDatasource
import com.example.testapex.data.mappers.asDomain
import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val remoteCharactersDatasource: RemoteCharactersDatasource) :
    CharactersRepository {

    override suspend fun fetchCharacters(): ResultValue<List<CharacterModel>, DataError> {
        return when( val resutlNetwork = remoteCharactersDatasource.fetchAllCharacters()){
            is ResultValue.Error -> {
                ResultValue.Error(resutlNetwork.error)
            }
            is ResultValue.Success -> {
                ResultValue.Success(resutlNetwork.data.results.map{
                    it.asDomain()
                })
            }
        }
    }


}