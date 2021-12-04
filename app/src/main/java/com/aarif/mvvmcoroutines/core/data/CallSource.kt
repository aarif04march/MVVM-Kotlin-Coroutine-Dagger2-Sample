package com.aarif.mvvmcoroutines.core.data

import androidx.lifecycle.liveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.aarif.mvvmcoroutines.core.data.remote.APIResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay



fun <L, R> resultLiveData(
    databaseQuery: suspend () -> LiveData<L>,
    networkCall: suspend () -> APIResult<R>,
    saveCallResult: suspend (R) -> Unit,
    io: CoroutineDispatcher
): LiveData<APIResult<L>> =
    liveData(io) {
        emit(APIResult.loading<L>())
        delay(1_500)
        val source = databaseQuery.invoke().map {
            APIResult.success(it)
        }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == APIResult.Status.SUCCESS) {
            responseStatus.data?.let { saveCallResult(it) }
        } else if (responseStatus.status == APIResult.Status.ERROR) {
            if (responseStatus.message != null) {
                emit(APIResult.error<L>(responseStatus.message))
            }
            emitSource(source)
        }
    }

fun <R> resultLiveData(
    networkCall: suspend () -> APIResult<R>,
    io: CoroutineDispatcher
): LiveData<APIResult<R>> =
    liveData(io) {
        emit(APIResult.loading<R>())
        delay(1_500)
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == APIResult.Status.SUCCESS) {
            responseStatus.data?.let { emit(APIResult.success<R>(it)) }
        } else if (responseStatus.status == APIResult.Status.ERROR) {
            if (responseStatus.message != null) {
                emit(APIResult.error<R>(responseStatus.message))
            }
        }
    }
