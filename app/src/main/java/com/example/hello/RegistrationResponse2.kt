package com.example.hello

import com.google.gson.annotations.SerializedName

data class RegistrationResponse2(
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("message") var message: String
)