package com.example.sbs.myapplication.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.dto.Pokemon;

public class DetailViewModel extends ViewModel {
    public MutableLiveData<Pokemon> lvPokemon = new MutableLiveData<>();
    public MutableLiveData<String> lvBottomImgUrl = new MutableLiveData<>();
}

