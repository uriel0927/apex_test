package com.example.testapex.presentation.mappers

import com.example.testapex.domain.model.CharacterModel
import com.example.testapex.ui.model.CharacterUiModel

/**
 * Extension function responsible to map a CharacterModel to CharacterUiModel
 */
fun CharacterModel.asUiModel(): CharacterUiModel =
    CharacterUiModel(id = this.id, name = this.name, imageUrl = this.image)