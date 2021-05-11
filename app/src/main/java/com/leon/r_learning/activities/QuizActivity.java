package com.leon.r_learning.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leon.r_learning.databinding.ActivityQuizBinding;

public class QuizActivity extends AppCompatActivity {
    ActivityQuizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}