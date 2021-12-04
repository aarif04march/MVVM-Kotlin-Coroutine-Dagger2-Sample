package com.aarif.mvvmcoroutines.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aarif.mvvmcoroutines.core.data.model.Sample

@Dao
interface AppDao {

    @Query("SELECT * FROM sample")
    suspend fun getPostList(): List<Sample>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setPostList(list: List<Sample?>)
}