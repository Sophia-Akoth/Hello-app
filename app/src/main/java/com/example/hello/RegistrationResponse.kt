package com.example.hello
import com.google.gson.annotations.SerializedName

 data class RegistrationResponse(
     @SerializedName("Message") var message:String,
     @SerializedName("Student") var student:Student
 )

