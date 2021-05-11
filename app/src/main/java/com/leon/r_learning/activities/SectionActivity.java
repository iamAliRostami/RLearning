package com.leon.r_learning.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leon.r_learning.R;
import com.leon.r_learning.databinding.ActivitySectionBinding;

public class SectionActivity extends AppCompatActivity {
    ActivitySectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}