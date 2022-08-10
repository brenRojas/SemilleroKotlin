package com.brenda.demoretrofil_post.models

import com.google.gson.annotations.SerializedName

data class Todos(
    @SerializedName("userId") var userId:Int,
    @SerializedName("id") var id:Int,
    @SerializedName("title") var title:String,
    @SerializedName("completed") var completed:Boolean
)