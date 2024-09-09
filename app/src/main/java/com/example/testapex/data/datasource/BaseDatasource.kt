package com.example.testapex.data.datasource

import com.example.testapex.domain.model.DataError
import com.example.testapex.domain.model.Error
import com.example.testapex.domain.model.ResultValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

open class BaseDatasource {

    /**
     * Executes a network call using the provided suspending lambda function.
     * @param apiCall The suspending lambda function that defines the network call.
     * @return A [ResultValue] containing the result of the network call.
     */
    protected suspend fun <T> safeCallApi(apiCall: suspend () -> T): ResultValue<T,DataError.Network> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiCall.invoke()
                return@withContext ResultValue.Success(response)
            } catch (throwable: Throwable) {
                return@withContext ResultValue.Error(createError(throwable))
            }
        }
    }

    /**
     * Create an error based in type of Throwable
     * @param throwable The throwable to check and convert in a NetworkErrorModel.
     * @return  The [Error] that correspond to the Throwable.
     */
    private fun createError(throwable: Throwable): DataError.Network {
        return when (throwable) {
            is IOException -> {
                DataError.Network.CONNECTION
            }

            is HttpException -> {
               DataError.Network.API
            }

            else -> {
                DataError.Network.UNKNOWN
            }
        }
    }

}