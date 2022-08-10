package com.brenda.demoretrofil_post.models

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id") var userId:Int,
    @SerializedName("name") var name:String,
    @SerializedName("username") var username:String,
    @SerializedName("email") var email:String,
    @SerializedName("address") var address:Address,
    @SerializedName("phone") var phone:String,
    @SerializedName("website") var website:String,
    @SerializedName("company") var company:Company
)