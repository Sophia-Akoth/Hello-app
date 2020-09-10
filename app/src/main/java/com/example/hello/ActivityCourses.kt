package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hello.activities.Registration
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityCourses : AppCompatActivity() {
    class CoursesActivity : AppCompatActivity(), CourseItemClickListener {
        lateinit var database: HelloDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun displayCourses(courses: List<Course>){
            var coursesAdapter = CoursesAdapter(courses)
            var coursesAdapter = CoursesAdapter(courses, this)
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = coursesAdapter
        }

        override fun onItemClick(course: Course) {
            fun registerCourse(requestBody: RequestBody) {
                var apiClient =
                    ApiClient.buildService(ApiInterface::class.java)
                var courseCall = apiClient.registerStudent(requestBody)
                courseCall.enqueue(object : Callback<RegisteredResponse> {
                    override fun onFailure(call: Call<RegisteredResponse>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show(

                    }

                    override fun onResponse(
                        call: Call<RegisteredResponse>,
                        response: Response<RegisteredResponse>
                    ) {
                        if (response.isSuccessful) {
                            progressBar.visibility = View.GONE
                            Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                            var accessToken = response.body()?.accessToken
                            var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
                            var editor = sharedPreferences.edit()
                            editor.putString("ACCESS_TOKEN_KEY", accessToken)
                            editor.apply()
                            val intent = Intent(baseContext, com.example.hello.CoursesActivity::class.java)
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



        private operator fun Intent.invoke(baseContext: Context?, java: Class<com.example.hello.CoursesActivity>): Intent? {

        }

    }

        }
    }

}