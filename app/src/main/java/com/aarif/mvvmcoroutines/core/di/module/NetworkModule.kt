package com.aarif.mvvmcoroutines.core.di.module

import com.aarif.mvvmcoroutines.BuildConfig
import com.aarif.mvvmcoroutines.core.data.remote.APIService
import com.aarif.mvvmcoroutines.core.di.NetworkConnectionInterceptor
import com.aarif.mvvmcoroutines.utils.AppEnums
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule {
    private val REQUEST_TIMEPUT = 10L
    private lateinit var okHttpClinet: OkHttpClient


    @Singleton
    @Provides
    fun provideClient(networkConnectionInterceptor: NetworkConnectionInterceptor) : OkHttpClient{
        val logging= HttpLoggingInterceptor()
        logging.level=if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        okHttpClinet = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEPUT, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEPUT, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(getHeaderInterceptor())
            .addInterceptor(networkConnectionInterceptor)
            .build()
        return okHttpClinet
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : APIService{
        return retrofit.create(APIService::class.java)
    }

    /**
     * @author AaR!F
     */
    private fun getHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request: okhttp3.Request = chain.request()
            val headers = request.headers().newBuilder()
                .add("Accept", "application/json")
                .build()
            request = request.newBuilder().headers(headers).build()
            chain.proceed(request)
        }

    }



}