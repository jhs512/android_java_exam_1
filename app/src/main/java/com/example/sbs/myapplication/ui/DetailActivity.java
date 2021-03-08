package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.ActivityDetailBinding;
import com.example.sbs.myapplication.service.PokemonService;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);

        setTitle(id + "번 포켓몬 상세정보");

        DetailViewModel vm = new ViewModelProvider(this).get(DetailViewModel.class);
        binding.setVm(vm);
    }
}