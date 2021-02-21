package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.dto.Todo;
import com.example.sbs.myapplication.util.Util;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Todo> todos = Util.spGetObj("todos", new TypeReference<List<Todo>>() {});

        Util.log(todos.get(0).getTitle());
    }
}