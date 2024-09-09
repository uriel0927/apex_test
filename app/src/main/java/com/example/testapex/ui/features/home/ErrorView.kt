package com.example.testapex.ui.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapex.R
import com.example.testapex.ui.model.UiText

/**
 * Composable responsible to show the description of the error that occurs.
 * @param modifier Modifier that will be apply to the composable.
 * @param errorText Model that represent the string of the error.
 * @param onRetry Callback to handle when user retry the request.
 */
@Composable
fun ErrorView(modifier: Modifier, errorText: UiText, onRetry: () -> Unit) {
    Box(
        modifier = modifier
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                modifier = Modifier.size(45.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_error),
                contentDescription = "Icon error"
            )
            Text(text = errorText.asString(), fontSize = 20.sp, textAlign = TextAlign.Center)

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onRetry() }) {
                Text(text = stringResource(id = R.string.retry))

            }

        }
    }
}