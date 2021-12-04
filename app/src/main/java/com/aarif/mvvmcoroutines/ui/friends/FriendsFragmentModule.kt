package com.aarif.mvvmcoroutines.ui.friends

import androidx.lifecycle.ViewModelProvider
import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.di.factory.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class FriendsFragmentModule {

    @Provides
    fun provideViewModel(repository: FriendsRepository) : FriendsFragmentViewModel {
        return FriendsFragmentViewModel(repository)
    }

    @Provides
    fun provideRepository(dao: AppDao, remoteDataSource: RemoteDataSource) : FriendsRepository {
        return FriendsRepository(dao, remoteDataSource)
    }


    @Provides
    fun provideViewModelProvider(viewModel: FriendsFragmentViewModel) : ViewModelProvider.Factory{
        return ViewModelFactory(viewModel)
    }

}