package com.aarif.mvvmcoroutines.core.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sample", primaryKeys = ["userId"])
class Sample(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)