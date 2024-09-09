package com.example.testapex.ui.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Sealed class use to wrapper a dynamic string or  string resource.
 */
sealed class UiText {

    /**
     * Data class represent a default string
     * @param value String represent a text
     */
    data class DynamicString(val value: String) : UiText()

    /**
     * Class that represent a string resource
     * @param id The id of the string.
     * @param args The arguments that pass if the String contains params.
     */
    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = arrayOf()
    ) : UiText()


    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> LocalContext.current.getString(id, *args)
        }
    }

}