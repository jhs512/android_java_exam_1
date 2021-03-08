package com.example.sbs.myapplication.ui;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.sbs.myapplication.dto.Pokemon;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends AndroidViewModel {
    private PokemonService pokemonService;
    public RecyclerViewPokemonAdapter recyclerViewPokemonAdapter;

    @Inject
    public MainViewModel(@NonNull Application application, PokemonService pokemonService) {
        super(application);

        // 포켓몬 서비스
        this.pokemonService = pokemonService;

        // 포켓몬 리사이클러 뷰 어덥터
        recyclerViewPokemonAdapter = new RecyclerViewPokemonAdapter();

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickItem(view -> {
            int pokemonIndex = (int)view.getTag();

            Pokemon pokemon = recyclerViewPokemonAdapter.getPokemon(pokemonIndex);

            Intent intent = new Intent(Util.getCurrentActivity(), DetailActivity.class);
            intent.putExtra("id", pokemon.id);
            Util.getCurrentActivity().startActivity(intent);
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
            recyclerViewPokemonAdapter.addPokemons(responseBody.results);
            if ( view != null ) {
                view.setEnabled(true);
            }
        });
    }
}
