package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.dto.Todo;
import com.example.sbs.myapplication.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Todo todo1 = new Todo(1, "제목1");
        Todo todo2 = new Todo(2, "제목2");

        List<Todo> todos = new ArrayList<>();

        todos.add(todo1);
        todos.add(todo2);

        Util.spPut("todos", todos);
        Util.spCommit();

        String jsonString = Util.spGetString("todos", "");

        Util.log(jsonString);
    }
}