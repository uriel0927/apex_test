package com.example.testapex.ui.features.home

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.testapex.ui.model.CharacterUiModel

/**
 * Composable responsible to show the name and image of the character
 * @param modifier Modifier that will be apply to the composable.
 * @param character Model contains the data to shown in composable.
 * @param onClick Callback when the user click on the card.
 */
@Composable
fun CardCharacter(
    modifier: Modifier = Modifier,
    character: CharacterUiModel,
    onClick: (CharacterUiModel) -> Unit
) {

    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = White),
        onClick = {
            onClick(character)
        }) {
        AsyncImage(
            modifier = Modifier
                .padding(16.dp)
                .size(125.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(Uri.parse(character.imageUrl))
                .crossfade(enable = true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp, end = 8.dp, start = 8.dp, bottom = 16.dp)
                .align(Alignment.CenterHorizontally), text = character.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )


    }

}


@Preview
@Composable
private fun CardCharacterPreview() {
    CardCharacter(
        character = CharacterUiModel(123, "Character Dummy", "")
    )
    {

    }
}