package com.example.hello.database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ke.co.hello.Course
import ke.co.hello.models.Course

@Dao
interface CourseDao {
       @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertCourse(course: Course)

        @Query("SELECT * FROM courses")
        fun getAllCourses(): List<Course>
    }
