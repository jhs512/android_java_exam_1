package com.example.sbs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sbs.myapplication.util.Util;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onResume(){
        super.onResume();
        Util.setCurrentActivity(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Util.setCurrentActivity(null);
    }
}
