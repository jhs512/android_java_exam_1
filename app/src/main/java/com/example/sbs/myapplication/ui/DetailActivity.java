package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.databinding.ActivityDetailBinding;
import com.example.sbs.myapplication.util.Util;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);

        setTitle(id + "번 포켓몬 상세정보");

        binding.activityDetailTextViewId.setText(id + "번");
    }
}