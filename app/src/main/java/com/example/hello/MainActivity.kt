package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
data class Courses(val id:int,val name:String,val code:Int,val instructor:String,val description:String)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_courses)
        tvRegister.setOnclickListener() {
            val intent = intent(baseContext, Registration::class.java)
            startActivity(intent)
        }
    }
    rvCourses.layoutManager = LinearLayoutManager(baseContext)
    val coursesAdapter=CoursesActivity(listOf(Courses(101,"Python",1997,"Joy","Best"),
        Courses(102,"Javascript",2012,"Mary","Enjoyable"),
        Courses(301,"Ruby",2002,"Jane","heavy"),Courses(303,"Kotlin",1992,"Paul","Educative"),Courses(306,"PHP",1989,"Nony","inspiring"),Courses(309,"Java",2000,"Oli","broad"),Courses(307,"Cobalt",1998,"Peter""heavy"),Courses(202,"HTML",1999,"Welbeck","Outstanding"),Courses(505,"Pd",1968,"Zack","wide"),Courses(606,"Econ",1960,"Callum","Educative"))

            rvCourses.adapter = namesAdapter
}



private operator fun Intent.invoke(baseContext: Context?, java: Class<Registration>): Intent? {

}
