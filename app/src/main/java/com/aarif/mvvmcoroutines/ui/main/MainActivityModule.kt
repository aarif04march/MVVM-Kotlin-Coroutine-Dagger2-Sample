package com.aarif.mvvmcoroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun providesViewModel(repository: MainRepository) : MainViewModel {
        return MainViewModel(repository)
    }

    @Provides
    fun provideRepository(dao: AppDao, remoteDataSource: RemoteDataSource) : MainRepository {
        return MainRepository(dao, remoteDataSource)
    }

    @Provides
    fun provideViewModelProvider(viewModel: MainViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }
}