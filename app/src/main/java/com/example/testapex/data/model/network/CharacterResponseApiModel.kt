package com.example.testapex.data.model.network

import com.google.gson.annotations.SerializedName

/**
 * Data class that represent the Api Response
 */
data class CharacterResponseApiModel(
    @SerializedName("results")
    val results : List<CharacterApiModel>
)
