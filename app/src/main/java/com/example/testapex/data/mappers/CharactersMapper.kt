package com.example.testapex.data.mappers

import com.example.testapex.data.model.network.CharacterApiModel
import com.example.testapex.domain.model.CharacterModel

/**
 * Extension function responsible to map CharacterApiModel to CharacterModel
 */
fun CharacterApiModel.asDomain(): CharacterModel {

    return CharacterModel(id = this.id, name = this.name, image = this.image)

}