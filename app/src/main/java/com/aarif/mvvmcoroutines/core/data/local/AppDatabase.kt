package com.aarif.mvvmcoroutines.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aarif.mvvmcoroutines.core.data.model.Sample
import javax.inject.Inject

@Database(entities = [Sample::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao() : AppDao

    companion object{

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase{
            return instance ?: synchronized(this){
                instance?: buildDatabase(context)
            }
        }

        private fun buildDatabase(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, "assignmentDB")
                .build()
        }

    }
}