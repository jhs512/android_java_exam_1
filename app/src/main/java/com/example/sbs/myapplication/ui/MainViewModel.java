package com.example.sbs.myapplication.ui;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.sbs.myapplication.dto.Pokemon;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

public class MainViewModel extends ViewModel {
    private PokemonService pokemonService;
    public RecyclerViewPokemonAdapter recyclerViewPokemonAdapter;

    public MainViewModel() {
        // 포켓몬 서비스
        pokemonService = new PokemonService();

        // 포켓몬 리사이클러 뷰 어덥터
        recyclerViewPokemonAdapter = new RecyclerViewPokemonAdapter();

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickItem(view -> {
            int pokemonIndex = (int)view.getTag();

            Pokemon pokemon = recyclerViewPokemonAdapter.getPokemon(pokemonIndex);

            BaseActivity currentActivity = Util.getCurrentActivity();
            Intent intent = new Intent(currentActivity, DetailActivity.class);
            intent.putExtra("id", pokemon.getId());
            currentActivity.startActivity(intent);
        });

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickLoadMore(view -> {
            view.setEnabled(false);

            loadMore(view);
        });

        loadMore();
    }

    public void loadMore() {
        loadMore(null);
    }

    public void loadMore(View view) {
        pokemonService.getPokemons(recyclerViewPokemonAdapter.getDataSize(), recyclerViewPokemonAdapter.getLoadCount(), responseBody -> {
            recyclerViewPokemonAdapter.addPokemons(responseBody.getResults());
            if ( view != null ) {
                view.setEnabled(true);
            }
        });
    }
}
