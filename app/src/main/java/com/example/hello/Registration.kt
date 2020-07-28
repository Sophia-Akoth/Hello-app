package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnclickListener()
        {
            var firstName = etFirstName.text.toString()
            var lastName = etLastName.text.toString()
            var phoneNumber = etPhoneNumber.text.toString()
            var password = etPassword.text.toString()
            var confirmPassword = etConfirmPassword.text.toString()

        }
    }
}