package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.ActivityMainBinding;
import com.example.sbs.myapplication.service.PokemonService;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("포켓몬 리스트");
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());

        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setVm(vm);
    }
}
