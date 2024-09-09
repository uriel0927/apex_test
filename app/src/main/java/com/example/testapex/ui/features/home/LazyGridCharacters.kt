package com.example.testapex.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapex.ui.model.CharacterUiModel

/**
 * Composable represents the grid that show all characters
 * @param modifier Modifier that will be apply to composable.
 * @param characters List that contains all data of the characters.
 * @param state State of LazyGridState
 */
@Composable
fun LazyGridCharacters(
    modifier: Modifier = Modifier,
    characters: List<CharacterUiModel>,
    state : LazyGridState = rememberLazyGridState()
) {

    LazyVerticalGrid(
        modifier = modifier,
        state = state,
        columns = GridCells.Adaptive(150.dp) ,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characters) { item ->
            CardCharacter(character = item) {

            }
        }
    }

}

@Preview(showSystemUi = true, backgroundColor = 0x00EBE3E3, showBackground = true)
@Composable
private fun LazyGridCharactersPreview() {
    LazyGridCharacters(
        modifier = Modifier.fillMaxSize(),
        characters = listOf(
            CharacterUiModel(123, "Dummy 1", ""),
            CharacterUiModel(123, "Dummy 1", ""),
            CharacterUiModel(123, "Dummy 1", "")

        )
    )

}