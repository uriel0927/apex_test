package com.example.testapex.domain.model

/**
 * Class that represent the types of error that can occur  in data layer
 */
sealed interface DataError : Error {

    /**
     * Enum that represent the types of error that can occur in the network datasource.
     */
    enum class Network : DataError{
        API,
        CONNECTION,
        UNKNOWN
    }


}