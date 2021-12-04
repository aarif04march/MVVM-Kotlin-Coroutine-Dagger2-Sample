package com.aarif.mvvmcoroutines.ui.album

import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.data.resultLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

class AlbumsRepository (val dao: AppDao, val remoteDataSource: RemoteDataSource, @Named("IO") private val io: CoroutineDispatcher = Dispatchers.IO){
    fun observeAlbums() = resultLiveData(
        networkCall = { remoteDataSource.getAlbums() },
        io = io
    )
}