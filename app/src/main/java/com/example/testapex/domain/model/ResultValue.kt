package com.example.testapex.domain.model

typealias RootError = Error

sealed interface ResultValue<out D, out E : RootError> {

    data class Success<out D, out E : RootError>(val data: D) : ResultValue<D, E>
    data class Error<out D, out E : RootError>(val error: E) : ResultValue<D, E>
}