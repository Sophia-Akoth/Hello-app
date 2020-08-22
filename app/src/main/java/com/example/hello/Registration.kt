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
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        if (progressBar != null) {
            val btn = findViewById<Button>(R.id.button)
            btnRegister.setOnClickListener {
                val visibility = if (progressBar.visibility == View.GONE) View.VISIBLE else View.GONE
                progressBar.visibility = visibility

                val btnText = if (progressBar.visibility == View.GONE) "SHOW PROGRESSBAR" else "HIDE PROGRESSBAR"
                btn.text = btnText

                btnRegister.setOnClickListener {}
        val phoneNumber = etPhoneNumber.text.toString()
        val password = etPassword.text.toString()
        val passwordConfirmation = etConfirmPassword.text.toString()
        if (firstName.isBlank() || firstName.isEmpty()) {
            etFirstName.error = "first name is required"
        }
        if (lastName.isBlank() || lastName.isEmpty()) {
            etLastName.error = "last name is required"
        }
        if (email.isBlank() || email.isEmpty()) {
            etEmail.error = "email is required"
        }
        if (phoneNumber.isBlank() || phoneNumber.isEmpty()) {
            etPhoneNumber.error = "phone number is required"
        }
        if (password.isBlank() || password.isEmpty()) {
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
