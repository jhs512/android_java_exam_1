package com.example.sbs.myapplication.service;

import androidx.annotation.NonNull;

import com.example.sbs.myapplication.api.PokeApi;
import com.example.sbs.myapplication.api.PokeApi__getPokemon__ResponseBody;
import com.example.sbs.myapplication.api.PokeApi__getPokemons__ResponseBody;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonService {
    private PokeApi pokeApi;

    @Inject
    public PokemonService(PokeApi pokeApi) {
        this.pokeApi = pokeApi;
    }

    public void getPokemons(int offset, int limit, @NonNull Consumer<? super PokeApi__getPokemons__ResponseBody> onNext) {
        pokeApi.getPokemons(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }

    public void getPokemon(int id, @NonNull Consumer<? super PokeApi__getPokemon__ResponseBody> onNext) {
        pokeApi.getPokemon(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, throwable -> {
                    Util.log("throwable : " + throwable.getMessage());
                });
    }
}
