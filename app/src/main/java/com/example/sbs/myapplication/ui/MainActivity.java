package com.example.sbs.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.service.PokemonService;
import com.example.sbs.myapplication.util.Util;

public class MainActivity extends AppCompatActivity {
    private PokemonService pokemonService;
    private RecyclerViewPokemonAdapter recyclerViewPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("포켓몬 리스트");
        setContentView(R.layout.activity_main);

        // 포켓몬 서비스
        pokemonService = new PokemonService();

        // 포켓몬 리사이클러 뷰
        final RecyclerView recyclerViewPokemon = findViewById(R.id.activity_main__recyclerViewPokemon);
        // 포켓몬 리사이클러 뷰 어덥터
        recyclerViewPokemonAdapter = new RecyclerViewPokemonAdapter();

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickItem(view -> {
            int pokemonIndex = (int)view.getTag();

            Pokemon pokemon = recyclerViewPokemonAdapter.getPokemon(pokemonIndex);

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("id", pokemon.getId());
            startActivity(intent);
        });

        // 푸터의 `더 보기` 버튼을 클릭하면 일어날 일을 세팅
        recyclerViewPokemonAdapter.setOnClickLoadMore(view -> {
            view.setEnabled(false);

            loadMore(view);
        });

        recyclerViewPokemon.setAdapter(recyclerViewPokemonAdapter);

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
