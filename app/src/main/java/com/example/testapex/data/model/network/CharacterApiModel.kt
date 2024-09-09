package com.example.testapex.data.model.network

import com.google.gson.annotations.SerializedName

/**
 * Data class that represent the Character api response
 */
data class CharacterApiModel(
    @SerializedName("id")
    val id : Int = 0,
    @SerializedName("name")
    val name : String = "",
    @SerializedName("status")
    val status : String = "",
    @SerializedName("species")
    val species : String = "",
    @SerializedName("type")
    val type : String = "",
    @SerializedName("gender")
    val gender : String = "",
    @SerializedName("origin")
    val origin : OriginApiModel? = null,
    @SerializedName("location")
    val location : LocationAPiModel? = null,
    @SerializedName("image")
    val image : String = "",
    @SerializedName("episode")
    val episode : List<String> = emptyList(),
    @SerializedName("url")
    val url : String = "",
    @SerializedName("created")
    val created : String = "")

data class OriginApiModel(val name : String, val url : String)

data class LocationAPiModel(val name: String, val url : String)
