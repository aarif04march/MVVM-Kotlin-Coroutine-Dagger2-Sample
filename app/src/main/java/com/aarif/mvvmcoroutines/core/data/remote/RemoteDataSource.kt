package com.aarif.mvvmcoroutines.core.data.remote

import com.aarif.mvvmcoroutines.core.base.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIService) : BaseDataSource(){

    suspend fun getPosts() = getResults {
        apiService.getPosts()
    }

    suspend fun getAlbums() = getResults {
        apiService.getAlbums()
    }

    suspend fun getFriends() = getResults {
        apiService.getFriends()
    }
}