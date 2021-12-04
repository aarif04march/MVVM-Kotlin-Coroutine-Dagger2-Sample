package com.aarif.mvvmcoroutines.ui.album

import androidx.lifecycle.ViewModelProvider
import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AlbumsFragmentModule {

    @Provides
    fun provideViewModel(repository: AlbumsRepository) : AlbumsFragmentViewModel {
        return AlbumsFragmentViewModel(repository)
    }

    @Provides
    fun provideRepository(dao: AppDao, remoteDataSource: RemoteDataSource) : AlbumsRepository {
        return AlbumsRepository(dao, remoteDataSource)
    }


    @Provides
    fun provideViewModelProvider(viewModel: AlbumsFragmentViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

}