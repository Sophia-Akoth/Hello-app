package com.example.hello.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.courses.view.*

class CoursesActivity(val coursesList: List<String>) :
class CoursesAdapter(var courseList: List<Course>, var courseItemClickListener: CourseItemClickListener) :
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

