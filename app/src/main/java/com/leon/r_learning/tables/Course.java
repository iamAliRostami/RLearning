package com.leon.r_learning.tables;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private ArrayList<Lesson> lessons;
    private int percentageProgress;

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Course(int id, String title, ArrayList<Lesson> lessons) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
    }

    public Course(String title, int percentageProgress) {
        this.title = title;
        this.percentageProgress = percentageProgress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public int getPercentageProgress() {
        return percentageProgress;
    }

    public void setPercentageProgress(int percentageProgress) {
        this.percentageProgress = percentageProgress;
    }
}
