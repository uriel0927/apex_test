package com.example.testapex.data.datasource.remote

import com.example.testapex.data.datasource.BaseDatasource
import com.example.testapex.data.model.network.CharacterResponseApiModel
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.Error
import com.example.testapex.domain.model.ResultValue

abstract class RemoteCharactersDatasource : BaseDatasource() {

    /**
     * Fetch the characters from the remote source.
     * @return NetworkResultModel<CharacterResponseApiModel> The model that contain the response of the Api.
     */
    abstract suspend fun fetchAllCharacters() : ResultValue<CharacterResponseApiModel, DataError.Network>

}