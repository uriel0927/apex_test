package com.example.testapex.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.testapex.ui.model.UiText
import com.example.testapex.ui.model.CharacterUiModel



/**
 * Composable that represent the content of the home screen.
 * @param modifier Modifier that will be apply to the composable.
 * @param characters The list of dat characters that will be show in the screen.
 * @param isLoadingData Boolean that represent if the screen is in loading state.
 * @param loadError Model that contains the string to show.
 * @param onRetry Callback handles the action retry.
 */
@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    characters: List<CharacterUiModel>,
    isLoadingData: Boolean,
    loadError: UiText,
    onRetry: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .background(Color(0xFFE6E5E5))
            .fillMaxSize()
    ) {
        val (loadingRef, errorRef) = createRefs()

        if (!isLoadingData && loadError.asString().isEmpty()) LazyGridCharacters(
            modifier = modifier.padding(8.dp),
            characters = characters
        )

        if (loadError.asString().isNotEmpty()) {
            ErrorView(modifier = Modifier.constrainAs(errorRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
                errorText = loadError,
                onRetry = {
                    onRetry()
                })
        }

        if (isLoadingData) {
            Box(modifier = Modifier
                .constrainAs(loadingRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                }) {
                CircularProgressIndicator()
            }
        }
    }


}


@Preview
@Composable
private fun HomeScreenContentPreview() {

    HomeScreenContent(
        modifier = Modifier
            .fillMaxSize()
        ,
        characters = listOf(
            CharacterUiModel(123, "Dummy character", ""),
            CharacterUiModel(13, "Dummy character 2", ""),
            CharacterUiModel(125, "Dummy character 3", "")
        ),
        isLoadingData = false,
        loadError = UiText.DynamicString(""),
        onRetry = {

        }
    )

}