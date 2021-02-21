package com.example.sbs.myapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.util.Util;

import java.util.List;

public class RecyclerViewPokemonAdapter extends RecyclerView.Adapter<RecyclerViewPokemonAdapter.ViewHolder> {
    private List<Integer> data;

    public RecyclerViewPokemonAdapter(List<Integer> data) {
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
        int id = data.get(position);
        holder.textViewId.setText(id + "번");
        holder.textViewId.setTag(position);
        
        Util.loadImageOn("https://pokeres.bastionbot.org/images/pokemon/" + id + ".png", holder.imageViewPokemon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewId;
        public ImageView imageViewPokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.item_pokemon__textViewId);
            imageViewPokemon = itemView.findViewById(R.id.item_pokemon__imageViewPokemon);
        }
    }
}
