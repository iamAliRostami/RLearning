package com.leon.r_learning.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leon.r_learning.databinding.ActivityHomeBinding;
import com.leon.r_learning.utils.CustomToast;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}