package com.example.hello

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<RegistrationResponse2>
    @POST("register-course")
    fun registeredCourse(
        @Body requestBody: RequestBody,
        @Header("Authorization") accessToken: String
    ): Call<RegisteredResponse>
}