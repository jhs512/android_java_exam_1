package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.dto.Todo;
import com.example.sbs.myapplication.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Todo todo = new Todo(1, "제목1");

        //Util.spPut("todo1", todo);
        //Util.spCommit();

        Todo todo = Util.spGetObj("todo1", Todo.class);

        Util.toast(todo.toString());
    }
}