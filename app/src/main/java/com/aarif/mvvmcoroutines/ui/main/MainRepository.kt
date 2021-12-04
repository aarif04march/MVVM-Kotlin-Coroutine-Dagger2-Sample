package com.aarif.mvvmcoroutines.ui.main

import com.aarif.mvvmcoroutines.core.data.local.AppDao
import com.aarif.mvvmcoroutines.core.data.remote.RemoteDataSource
import com.aarif.mvvmcoroutines.core.data.resultLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject
import javax.inject.Named

class MainRepository @Inject constructor(val dao: AppDao, val remoteDataSource: RemoteDataSource, @Named("IO") private val io: CoroutineDispatcher = IO){

}