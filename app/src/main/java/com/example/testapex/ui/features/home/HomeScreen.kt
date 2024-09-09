package com.example.testapex.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testapex.presentation.HomeVieModel


/**
 * Composable that represent the Home Screen.
 * @param modifier Modifier that will be apply to the composable.
 * @param viewmodel Viewmodel responsible to manage the ui sate.
 */
@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    viewmodel: HomeVieModel = hiltViewModel()
) {
    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

    HomeScreenContent(
        modifier = modifier.background(Color(0xFFE6E5E5)),
        characters = uiState.characters,
        isLoadingData = uiState.isLoading,
        loadError = uiState.errorToShow,
        onRetry = {
            viewmodel.fetchDataAction()
        }
    )
}