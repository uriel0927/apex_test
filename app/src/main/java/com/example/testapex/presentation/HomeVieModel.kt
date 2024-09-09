package com.example.testapex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.domain.usecase.FetchCharactersUseCase
import com.example.testapex.presentation.mappers.asErrorUiText
import com.example.testapex.presentation.mappers.asUiModel
import com.example.testapex.presentation.mappers.asUiText
import com.example.testapex.ui.model.CharactersScreenUiState
import com.example.testapex.ui.model.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Viewmodel responsible to manage the action of the ui and manage the ui state.
 * @param fetchCharactersUseCase Use case responsible to fetch the data.
 */
@HiltViewModel
class HomeVieModel @Inject constructor(private val fetchCharactersUseCase: FetchCharactersUseCase) :
    ViewModel() {

    /**
     * StateFlow for holding the UI state.
     */
    private val _uiState: MutableStateFlow<CharactersScreenUiState> = MutableStateFlow(
        CharactersScreenUiState()
    )
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = _uiState.value
    )


    init {
        fetchDataAction()
    }

    /**
     * Fetch the characters data and update the ui state
     */
    fun fetchDataAction() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(isLoading = true, errorToShow = UiText.DynamicString(""))
            }

            when (val resultFetch = fetchCharactersUseCase()) {
                is ResultValue.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false, errorToShow = resultFetch.asErrorUiText()

                        )
                    }

                }

                is ResultValue.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            characters = resultFetch.data.map { it.asUiModel() },
                            errorToShow = UiText.DynamicString("")
                        )
                    }
                }
            }

        }

    }

}