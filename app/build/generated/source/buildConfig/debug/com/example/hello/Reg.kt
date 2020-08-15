package com.example.hello

import com.google.gson.annotations.SerializedName

data class Reg(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)