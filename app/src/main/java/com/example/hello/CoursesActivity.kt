package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.courses.view.*
data class Course(
    @SerializedName("course_id") val courseId: Int,
    @SerializedName("course_name") val courseName: String,
    @SerializedName("course_code") val courseCode: Int,
    @SerializedName("instructor") val instructor: String,
    @SerializedName("description") val description: String
)

class CoursesActivity(val coursesList: List<String>) :
    RecyclerView.Adapter<CoursesActivity.NamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.courses, parent, false)
        return NamesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return coursesList .size
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.rowView.tvCourseDescription.text = coursesList[position]
        holder.rowView.tvCourseId.text = coursesList[position]
        holder.rowView.tvCourseName.text = coursesList[position]
        holder.rowView.tvCourseInstructor.text = coursesList[position]
        holder.rowView.tvCourseInstructor.text = coursesList[position]

    }

    class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}

