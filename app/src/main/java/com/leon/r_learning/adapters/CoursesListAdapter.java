/*
 *  Copyright (c) 2018 Gabriele Corso
 *
 *  Distributed under the MIT software license, see the accompanying
 *  file LICENSE or http://www.opensource.org/licenses/mit-license.php.
 */

package com.leon.r_learning.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.leanback.widget.HorizontalGridView;

import com.leon.r_learning.R;
import com.leon.r_learning.tables.Course;

import java.util.List;

public class CoursesListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Course> courses;

    public CoursesListAdapter(Context context, List<Course> courses) {
        this.context = context;
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
        View view = inflater.inflate(R.layout.item_course, parent, false);

        TextView tvCourseTitle = view.findViewById(R.id.text_view_course_title);
        tvCourseTitle.setText(courses.get(position).getTitle());

        LessonsHorizontalAdapter lessonsAdapter = new LessonsHorizontalAdapter(context, courses.get(position).getLessons(), courses.get(position).getId());
        HorizontalGridView lessonsView = view.findViewById(R.id.horizontal_grid_view_lessons);
        lessonsView.setAdapter(lessonsAdapter);

        return view;
    }
}