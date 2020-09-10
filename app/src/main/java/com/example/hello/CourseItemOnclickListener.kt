package com.example.hello

import ke.co.hello.models.Course

interface CourseItemClickListener {
    fun onItemClick(course: Course)
}