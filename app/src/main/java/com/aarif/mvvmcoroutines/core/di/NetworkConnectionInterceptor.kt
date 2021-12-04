package com.aarif.mvvmcoroutines.core.di

import com.aarif.mvvmcoroutines.utils.NoInternetException
import com.aarif.mvvmcoroutines.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(val utils: Utils): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!utils.isNetworkAvailable())
            throw NoInternetException("Make sure you have an active internet connection.")
        return chain.proceed(chain.request())
    }
}