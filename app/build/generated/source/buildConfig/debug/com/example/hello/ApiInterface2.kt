package com.example.hello

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface2 {
    @POST("login")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse2>
}