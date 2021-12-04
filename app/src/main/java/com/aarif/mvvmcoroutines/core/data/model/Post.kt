package com.aarif.mvvmcoroutines.core.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("userId")
    @Expose
    var userId: Int = 0

    @SerializedName("title")
    @Expose
    var title: String = ""

    @SerializedName("body")
    @Expose
    var body: String = ""


}