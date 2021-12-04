package com.aarif.mvvmcoroutines.core.data.remote

data class APIResult<out T>(val status: Status, val data: T?, val message: String?){

    enum class Status{
        SUCCESS, ERROR, LOADING
    }

    companion object{
        fun <T> success(data: T): APIResult<T> = APIResult(status = Status.SUCCESS, data, message = null)

        fun <T> error(message: String, data: T? = null): APIResult<T> = APIResult(status = Status.ERROR, data, message = message)

        fun <T> loading(data: T? = null): APIResult<T> = APIResult(status = Status.LOADING, data = data, message = null)
    }
}
