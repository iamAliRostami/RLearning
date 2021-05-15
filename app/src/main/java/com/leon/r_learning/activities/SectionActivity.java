package com.leon.r_learning.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.leon.r_learning.MyApplication;
import com.leon.r_learning.databinding.ActivitySectionBinding;
import com.leon.r_learning.enums.BundleEnum;
import com.leon.r_learning.utils.ReadFile;

public class SectionActivity extends AppCompatActivity {
    ActivitySectionBinding binding;
    Activity activity;
    int lessonId, sectionNumber, courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        initialize();
    }

    void initialize() {
        getBundle();
        initializeTextViews();
        initializeImageViews();
    }

    void getBundle() {
        Intent intent = getIntent();
        lessonId = intent.getIntExtra(BundleEnum.LESSON_ID.getValue(), 0);
        sectionNumber = intent.getIntExtra(BundleEnum.SECTION_NUMBER.getValue(), 1);
        courseId = intent.getIntExtra(BundleEnum.COURSE_ID.getValue(), 0);
    }


    void initializeTextViews() {
        Log.e("courseId", String.valueOf(courseId));
        Log.e("lessonId", String.valueOf(lessonId));
        Log.e("sectionNumber", String.valueOf(sectionNumber));
        String data = ReadFile.readFile(activity, "c".concat(String.valueOf(courseId)).concat("l".concat(String.valueOf(lessonId)).concat("s").concat(String.valueOf(sectionNumber)).concat(".txt")));
        if (data != null) {
            binding.textViewSectionTitle.setText(data.substring(0, data.indexOf(MyApplication.SEPARATOR)));
            binding.textViewSection.setText(data.substring(binding.textViewSectionTitle.getText().toString().concat(MyApplication.SEPARATOR).length()));
        }
        String page = MyApplication.LESSONS[courseId - 1][lessonId - 1]
                + "  " + (sectionNumber)
                + "/" + MyApplication.SECTION_NUMBER[courseId - 1][lessonId - 1];
        binding.textViewPage.setText(page);
    }

    void setOnImageViewCloseClickListener() {
        binding.imageViewClose.setOnClickListener(view -> {
            Intent intent = new Intent(SectionActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

    void initializeImageViews() {
        String imageName = "s" + courseId + "_" + lessonId + "_" + sectionNumber;
        Log.e("image", imageName);
        binding.aspectRatioImageSection.setImageResource(getResources().getIdentifier(imageName,
                "drawable", getPackageName()));
        setOnImageViewCloseClickListener();

        if (sectionNumber == 1) {
            binding.imageViewNavPrevious.setVisibility(View.GONE);
        } else {
            binding.imageViewNavPrevious.setOnClickListener(view -> changeSection(sectionNumber - 1));
        }
        binding.imageViewNavNext.setOnClickListener(view -> {
            Log.e("number 1", String.valueOf(sectionNumber));
            Log.e("number 2", String.valueOf(MyApplication.SECTION_NUMBER[courseId - 1][lessonId - 1]));
            if (sectionNumber < MyApplication.SECTION_NUMBER[courseId - 1][lessonId - 1]) {
                changeSection(sectionNumber + 1);
            } else {
                startQuiz(lessonId);
            }
        });
    }

    void changeSection(int sectionNumber) {
        Intent intent = new Intent(SectionActivity.this, SectionActivity.class);
        intent.putExtra(BundleEnum.SECTION_NUMBER.getValue(), sectionNumber);
        intent.putExtra(BundleEnum.LESSON_ID.getValue(), lessonId);
        intent.putExtra(BundleEnum.COURSE_ID.getValue(), courseId);
        startActivity(intent);
    }

    void startQuiz(int lessonId) {
        Intent intent = new Intent(SectionActivity.this, QuizActivity.class);
        intent.putExtra(BundleEnum.LESSON_ID.getValue(), lessonId);
        startActivity(intent);
    }
}