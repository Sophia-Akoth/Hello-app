package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.courses.view.*
@Entity(tableName = "courses")
data class Course(
    @PrimaryKey @NonNull @SerializedName("course_id") val courseId: Int,
    @SerializedName("course_name") val courseName: String,
    @SerializedName("course_code") val courseCode: Int,
    @SerializedName("instructor") val instructor: String,
    @SerializedName("description") val description: String
)


