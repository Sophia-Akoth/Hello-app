package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
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
            val intent = intent(baseContext, Registration::class.java)
            startActivity(intent)
        }
        val email = etUsername.text.toString()
        val password = etPassword.text.toString()

        var requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("email", email)
            .addFormDataPart("password", password)
            .build()

        registerUser(requestBody)
        Toast.makeText(baseContext, email, Toast.LENGTH_SHORT).show()
    }
}


fun registerUser(requestBody: RequestBody) {
    var apiClient = ApiClient.buildService(ApiInterface::class.java)
    var registrationCall = apiClient.registerStudent(requestBody)
    registrationCall.enqueue(object : Callback<RegistrationResponse2> {
        override fun onFailure(call: Call<RegistrationResponse2>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }

        override fun onResponse(
            call: Call<RegistrationResponse2>,
            response: Response<RegistrationResponse2>
        ) {
            if (response.isSuccessful) {
                Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                startActivity(Intent)
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }
    })
}
}

    }


}



private operator fun Intent.invoke(baseContext: Context?, java: Class<Registration>): Intent? {

}
