package com.clint.networkmanager.others

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object CustomNetworkCall {
    suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiCall: suspend () -> T
    ): ApiResult<T> {
        return withContext(dispatcher) {
            try {
                val result = apiCall.invoke()
                ApiResult.Success(result)
            } catch (throwable: Exception) {
                ApiResult.Error(throwable)
            }
        }
    }
}