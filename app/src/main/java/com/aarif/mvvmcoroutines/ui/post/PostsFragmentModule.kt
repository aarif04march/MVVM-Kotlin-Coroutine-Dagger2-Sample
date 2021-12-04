package com.aarif.mvvmcoroutines.ui.post

import androidx.lifecycle.ViewModelProvider
import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PostsFragmentModule {

    @Provides
    fun provideViewModel(repository: PostsRepository) : PostsFragmentViewModel {
        return PostsFragmentViewModel(repository)
    }

    @Provides
    fun provideRepository(dao: AppDao, remoteDataSource: RemoteDataSource) : PostsRepository {
        return PostsRepository(dao, remoteDataSource)
    }


    @Provides
    fun provideViewModelProvider(viewModel: PostsFragmentViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

}