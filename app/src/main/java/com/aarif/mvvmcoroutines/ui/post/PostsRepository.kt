package com.aarif.mvvmcoroutines.ui.post

import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.data.resultLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

class PostsRepository (val dao: AppDao, val remoteDataSource: RemoteDataSource, @Named("IO") private val io: CoroutineDispatcher = Dispatchers.IO){
    fun observePosts() = resultLiveData(
        networkCall = { remoteDataSource.getPosts() },
        io = io
    )
}