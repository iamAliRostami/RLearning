package com.leon.r_learning.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leon.r_learning.R;
import com.leon.r_learning.layout.FitDoughnut;
import com.leon.r_learning.tables.Course;

import java.util.List;

import static com.leon.r_learning.utils.Preferences.CoursesColors;

public class CoursesProgGridAdapter extends BaseAdapter {

    private final List<Course> courses;

    public CoursesProgGridAdapter(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_courseprog, parent, false);

        TextView textViewCourseTitle = view.findViewById(R.id.text_view_title);
        textViewCourseTitle.setText(courses.get(position).getTitle());

        FitDoughnut fitDoughnutCourse = view.findViewById(R.id.fit_doughnut);
        TextView textViewCoursePercent = view.findViewById(R.id.text_view_percentage);

        fitDoughnutCourse.setColorPrimary(Color.parseColor(CoursesColors[position]));
        fitDoughnutCourse.animateSetPercent((float) courses.get(position).getPercentageProgress());
        String t = courses.get(position).getPercentageProgress() + "%";
        textViewCoursePercent.setText(t);

        textViewCourseTitle.setTextColor(Color.parseColor(CoursesColors[position]));
        textViewCoursePercent.setTextColor(Color.parseColor(CoursesColors[position]));

        return view;
    }
}