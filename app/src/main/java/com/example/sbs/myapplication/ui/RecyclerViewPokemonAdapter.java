package com.example.sbs.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.Pokemon;
import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

import java.util.List;

public class RecyclerViewPokemonAdapter extends RecyclerView.Adapter<RecyclerViewPokemonAdapter.ViewHolder> {
    private List<Pokemon> data;

    public RecyclerViewPokemonAdapter(List<Pokemon> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = data.get(position);
        holder.textViewId.setText(pokemon.getId() + "번");
        holder.textViewId.setTag(position);

        holder.textViewName.setText(pokemon.getName());
        holder.textViewName.setTag(position);
        
        Util.loadImageOn(pokemon.getImgUrl(), holder.imageViewPokemon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewId;
        public TextView textViewName;
        public ImageView imageViewPokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.item_pokemon__textViewId);
            textViewName = itemView.findViewById(R.id.item_pokemon__textViewName);
            imageViewPokemon = itemView.findViewById(R.id.item_pokemon__imageViewPokemon);
        }
    }
}
