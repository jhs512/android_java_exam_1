package com.example.sbs.myapplication.api;

import com.example.sbs.myapplication.Pokemon;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokeApi {
    String baseUrl = "https://pokeapi.co/api/v2/";

    @GET("pokemon")
    Observable<PokeApi__getPokemons__ResponseBody> getPokemons();
}
