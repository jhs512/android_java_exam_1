package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.ActivityDetailBinding;
import com.example.sbs.myapplication.service.PokemonService;

public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);

        setTitle(id + "번 포켓몬 상세정보");

        DetailViewModel detailViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(DetailViewModel.class);
        binding.setVm(detailViewModel);

        // 포켓몬 서비스
        final PokemonService pokemonService = new PokemonService();

        pokemonService.getPokemon(id, responseBody -> {
            detailViewModel.lvPokemon.setValue(responseBody.getPokemon());
        });

        /*
        Util.setTimeout(() -> {
            pokemonService.getPokemon(id + 1, responseBody -> {
                detailViewModel.lvPokemon.setValue(responseBody.getPokemon());
            });
        }, 5000);
        */

        // 하단 이미지 로드
        detailViewModel.lvBottomImgUrl.setValue("https://i.picsum.photos/id/199/536/354.jpg?hmac=g0IyHUDJS4xn7wz_TpnFDJAtrGcukcqV1Ye7w22fdFk");

        /*
        Util.setTimeout(() -> {
            detailViewModel.lvBottomImgUrl.setValue("https://i.picsum.photos/id/254/536/354.jpg?hmac=HI8J-HWbYztb20pxIW36rKEkg4wqIbYPmayDvAk3ehA");
        }, 3000);
        */
    }
}