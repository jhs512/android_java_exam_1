package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.sbs.myapplication.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewTop = findViewById(R.id.activity_main__imageViewTop);
        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageViewTop);
    }
}