package com.brenda.demoretrofil_post.models

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("name") var name:String,
    @SerializedName("cathPhrase") var cathPhrase:String,
    @SerializedName("bs") var bs:String
)