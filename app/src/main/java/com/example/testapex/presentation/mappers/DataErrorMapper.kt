package com.example.testapex.presentation.mappers

import com.example.testapex.R
import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.ResultValue
import com.example.testapex.ui.model.UiText

/**
 * Extension function responsible to map the string resource.
 */
fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Network.API -> UiText.StringResource(R.string.error_api)
        DataError.Network.CONNECTION -> UiText.StringResource(R.string.error_connection)
        DataError.Network.UNKNOWN -> UiText.StringResource(R.string.error_unknown)
    }
}

fun ResultValue.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}