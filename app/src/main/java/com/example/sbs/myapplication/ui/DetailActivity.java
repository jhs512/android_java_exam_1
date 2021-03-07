package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sbs.myapplication.databinding.ActivityDetailBinding;
import com.example.sbs.myapplication.service.PokemonService;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);

        setTitle(id + "번 포켓몬 상세정보");

        DetailViewModel detailViewModel = new DetailViewModel();

        // 포켓몬 서비스
        final PokemonService pokemonService = new PokemonService();

        pokemonService.getPokemon(id, responseBody -> {
            detailViewModel.pokemon = responseBody.getPokemon();
            binding.setVm(detailViewModel);
        });

        // 하단 이미지 로드
        detailViewModel.bottomImgUrl = "https://i.picsum.photos/id/199/536/354.jpg?hmac=g0IyHUDJS4xn7wz_TpnFDJAtrGcukcqV1Ye7w22fdFk";
    }
}