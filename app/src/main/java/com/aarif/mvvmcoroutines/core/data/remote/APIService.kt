package com.aarif.mvvmcoroutines.core.data.remote

import com.aarif.mvvmcoroutines.core.data.model.Album
import com.aarif.mvvmcoroutines.core.data.model.Friend
import com.aarif.mvvmcoroutines.core.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("users")
    suspend fun getFriends(): Response<List<Friend>>
}