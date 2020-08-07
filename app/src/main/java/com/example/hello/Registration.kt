package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.etPassword

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnclickListener() {
            var firstName = etFirstName.text.toString()
        }
        btnRegister.setOnclickListener(){
            var lastName = etLastName.text.toString()
            Toast.makeText(baseContext,Email, Toast.LENGTH_LONG).show()

        }
        btnRegister.setOnclickListener(){
            var confirmPassword = etConfirmPassword.text.toString()
        }
        btnRegister.setOnclickListener(){
            var password = etPassword.text.toString()
            Toast.makeText(baseContext,Email, Toast.LENGTH_LONG).show()
        }

        btnRe.setOnClickListener(){
            var email=etEmail.text.toString()
            Toast.makeText(baseContext,Email, Toast.LENGTH_LONG).show()
        }
        btnRegister.setOnclickListener(){
            var phoneNumber = etPhoneNumber.text.toString()
            Toast.makeText(baseContext,Email, Toast.LENGTH_LONG).show()
        }

    }
}