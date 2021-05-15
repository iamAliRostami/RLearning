package com.leon.r_learning.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.leon.r_learning.MyApplication;
import com.leon.r_learning.databinding.ActivitySectionBinding;
import com.leon.r_learning.enums.BundleEnum;
import com.leon.r_learning.utils.ReadFile;

public class SectionActivity extends AppCompatActivity {
    ActivitySectionBinding binding;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activity = this;
        initialize();
    }

    void initialize() {
        Intent intent = getIntent();
        final int lessonId = intent.getIntExtra(BundleEnum.LESSON_ID.getValue(), 0);
        final int sectionNumber = intent.getIntExtra(BundleEnum.SECTION_NUMBER.getValue(), 0);
        final int courseId = intent.getIntExtra(BundleEnum.COURSE_ID.getValue(), 0);

        String data = ReadFile.readFile(activity, "l".concat(String.valueOf(courseId)).concat("s").concat(String.valueOf(lessonId)).concat(".txt"));

        String imageName = "s" + courseId + "_" + lessonId + "_" + sectionNumber;
        binding.aspectRatioImageSection.setImageResource(getResources().getIdentifier(imageName,
                "drawable", getPackageName()));
        if (data != null) {
            binding.textViewSectionTitle.setText(data.substring(0, data.indexOf(MyApplication.SEPARATOR)));
            binding.textViewSection.setText(data.substring(binding.textViewSectionTitle.getText().toString().concat(MyApplication.SEPARATOR).length()));
        }
    }
}