package com.example.sbs.myapplication.api;

import com.example.sbs.myapplication.dto.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApi__getPokemon__ResponseBody {
    public int id;
    @JsonProperty("base_experience")
    public int baseExperience;
    public int weight;
    public String name;

    public Pokemon getPokemon() {
        return new Pokemon(id, name);
    }
}
