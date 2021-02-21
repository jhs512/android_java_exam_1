package com.example.sbs.myapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Pokemon> data = new ArrayList<>();
        data.add(new Pokemon(1, "bulbasaur"));
        data.add(new Pokemon(2, "ivysaur"));
        data.add(new Pokemon(3, "venusaur"));

        RecyclerView recyclerViewPokemon = findViewById(R.id.activity_main__recyclerViewPokemon);
        recyclerViewPokemon.setAdapter(new RecyclerViewPokemonAdapter(data));
    }
}