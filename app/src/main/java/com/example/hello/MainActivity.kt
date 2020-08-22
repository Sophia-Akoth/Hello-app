package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.activity_registration.etPassword
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_courses)
        tvRegister.setOnclickListener() {
            val intent = Intent(baseContext, Registration::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email = etUsername.text.toString()
            val password = etPassword.text.toString()
            if(email.isBlank() || email.isEmpty()){
                etUsername.error="email is required"
            }
            if(password.isBlank() || password.isEmpty()){
                etPassword.error="first name is required"
            }

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build()

            loginStudent(requestBody)

}


fun loginStudent(requestBody: RequestBody) {
    var apiClient = ApiClient.buildService(ApiInterface::class.java)
    var loginCall = apiClient.registerStudent(requestBody)
    loginCall.enqueue(object : Callback<RegistrationResponse2> {
        override fun onFailure(call: Call<RegistrationResponse2>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }

        override fun onResponse(
            call: Call<RegistrationResponse2>,
            response: Response<RegistrationResponse2>
        ) {
            if (response.isSuccessful) {
                Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                var accessToken = response.body()?.accessToken
                var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                var editor = sharedPreferences.edit()
                editor.putString("ACCESS_TOKEN_KEY", accessToken)
                editor.apply()
                val intent = Intent(baseContext, CoursesActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)

            }
        }
    })
}
}




}



private operator fun Intent.invoke(baseContext: Context?, java: Class<Registration>): Intent? {

}
