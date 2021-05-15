package com.leon.r_learning.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.leon.r_learning.MyApplication;
import com.leon.r_learning.adapters.CoursesListAdapter;
import com.leon.r_learning.databinding.ActivityHomeBinding;
import com.leon.r_learning.tables.Course;
import com.leon.r_learning.tables.Lesson;
import com.leon.r_learning.utils.ReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    Activity activity;
    ArrayList<Course> courses = new ArrayList<>();
    CoursesListAdapter coursesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        initialize();
    }

    void initialize() {
        for (int i = 0; i < MyApplication.LESSON_NUMBER; i++) {
            ArrayList<String> arrayListLesson = new ArrayList<>(Arrays.asList(MyApplication.LESSONS[i]));
            ArrayList<Lesson> lessons = new ArrayList<>();

            for (int k = 0; k < MyApplication.LESSONS[i].length; k++) {
                Lesson lesson = new Lesson(k + 1, i + 1, MyApplication.LESSONS[i][k]);
                lessons.add(lesson);
            }

//            Course course = new Course(i + 1, arrayListLesson, MyApplication.COURSES[i]);
            Course course = new Course(i + 1, MyApplication.COURSES[i], lessons);
            courses.add(course);
        }
        coursesListAdapter = new CoursesListAdapter(activity, courses);
        binding.listCourses.setAdapter(coursesListAdapter);
    }
}