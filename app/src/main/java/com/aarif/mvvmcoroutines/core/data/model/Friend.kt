package com.aarif.mvvmcoroutines.core.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Friend {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("username")
    @Expose
    var username: String = ""

    @SerializedName("email")
    @Expose
    var email: String = ""


}