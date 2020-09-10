package com.example.hello

import com.google.gson.annotations.SerializedName

class RegisteredResponse {
    @SerializedName("message") var accessToken: String,
    @SerializedName("registration") var message: String
}