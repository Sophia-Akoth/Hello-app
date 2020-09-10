package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.etPassword

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)



        btnRegister.setOnClickListener {}
        val phoneNumber = etPhoneNumber.text.toString()
        val password = etPassword.text.toString()
        val passwordConfirmation = etConfirmPassword.text.toString()
        var error=false
        if (firstName.isBlank() || firstName.isEmpty()) {
            error=true
            etFirstName.error = "first name is required"
        }
        if (lastName.isBlank() || lastName.isEmpty()) {
            error=true
            etLastName.error = "last name is required"
        }
        if (email.isBlank() || email.isEmpty()) {
            error=true
            etEmail.error = "email is required"
        }
        if (phoneNumber.isBlank() || phoneNumber.isEmpty()) {
            error=true
            etPhoneNumber.error = "phone number is required"
        }
        if (password.isBlank() || password.isEmpty()) {
            error=true
            etPassword.error = "password is required"
        }


        var requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("first_name", firstName)
            .addFormDataPart("last_name", lastName)
            .addFormDataPart("email", email)
            .addFormDataPart("phone_number", phoneNumber)
            .addFormDataPart("password", password)
            .build()

        registerUser(requestBody)
        Toast.makeText(baseContext, lastName, Toast.LENGTH_SHORT).show()
    }
}


fun registerUser(requestBody: RequestBody) {
    var apiClient = ApiClient.buildService(ApiInterface::class.java)
    var registrationCall = apiClient.registerStudent(requestBody)
    registrationCall.enqueue(object : Callback<RegistrationResponse> {
        override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }

        override fun onResponse(
            call: Call<RegistrationResponse>,
            response: Response<RegistrationResponse>
        ) {
            if (response.isSuccessful) {
                Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, MainActivity::class.java))
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }
    })
}
