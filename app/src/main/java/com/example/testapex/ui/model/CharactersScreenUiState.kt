package com.example.testapex.ui.model

/**
 * Model represents the ui state
 * @param isLoading Boolean that represent if the screen is in loading state.
 * @param characters List of [CharacterUiModel] that represent all data to show in screen.
 * @param errorToShow [UiText] Model that represent the error string to show
 */
data class CharactersScreenUiState(
    val isLoading : Boolean = false,
    val characters : List<CharacterUiModel> = emptyList(),
    val errorToShow : UiText = UiText.DynamicString("")
)
