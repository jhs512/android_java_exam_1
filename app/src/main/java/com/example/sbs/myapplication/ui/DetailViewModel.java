package com.example.sbs.myapplication.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.dto.Pokemon;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetailViewModel extends AndroidViewModel {
    public MutableLiveData<Pokemon> lvPokemon = new MutableLiveData<>();
    public MutableLiveData<String> lvBottomImgUrl = new MutableLiveData<>();

    private PokemonService pokemonService;

    @Inject
    public DetailViewModel(@NonNull Application application, PokemonService pokemonService) {
        super(application);

        this.pokemonService = pokemonService;

        int id = Util.getCurrentActivity().getIntent().getIntExtra("id", 0);

        pokemonService.getPokemon(id, responseBody -> {
            lvPokemon.setValue(responseBody.getPokemon());
        });

        // 하단 이미지 로드
        lvBottomImgUrl.setValue("https://i.picsum.photos/id/199/536/354.jpg?hmac=g0IyHUDJS4xn7wz_TpnFDJAtrGcukcqV1Ye7w22fdFk");
    }
}

