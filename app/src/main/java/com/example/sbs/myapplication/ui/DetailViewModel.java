package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.dto.Pokemon;

public class DetailViewModel {
    public MutableLiveData<Pokemon> lvPokemon = new MutableLiveData<>();
    public MutableLiveData<String> lvBottomImgUrl = new MutableLiveData<>();
}
