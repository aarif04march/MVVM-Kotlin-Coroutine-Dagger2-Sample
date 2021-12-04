package com.aarif.mvvmcoroutines.core.di.module

import android.app.Application
import android.content.Context
import com.aarif.mvvmcoroutines.MCSApplication
import com.aarif.mvvmcoroutines.core.data.local.AppDatabase
import com.aarif.mvvmcoroutines.core.data.remote.APIService
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.di.NetworkConnectionInterceptor
import com.aarif.mvvmcoroutines.utils.Utils
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: MCSApplication): Context = application

    @Provides
    @Singleton
    fun provideApplication(app: MCSApplication): Application = app

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideUtils(context: Context) = Utils(context = context)

    @Provides
    @Singleton
    @Named("DEFAULT")
    fun provideDefaultDispatchers(): CoroutineDispatcher =
        Dispatchers.Default

    @Provides
    @Singleton
    @Named("IO")
    fun provideBackgroundDispatchers(): CoroutineDispatcher =
        Dispatchers.IO

    @Provides
    @Singleton
    @Named("MAIN")
    fun provideMainDispatchers(): CoroutineDispatcher =
        Dispatchers.Main

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(utils: Utils) = NetworkConnectionInterceptor(utils)

    @Provides
    @Singleton
    fun provideRoomDB(app: Application) = AppDatabase.getInstance(app)

    @Provides
    @Singleton
    fun provideAppDao(db: AppDatabase) = db.appDao()

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: APIService) = RemoteDataSource(apiService)
}