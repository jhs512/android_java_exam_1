package com.example.sbs.myapplication.api;

import com.example.sbs.myapplication.dto.Pokemon;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeApi__getPokemon__ResponseBody {
    int id;
    @JsonProperty("base_experience")
    int baseExperience;
    int weight;
    String name;

    public Pokemon getPokemon() {

        return new Pokemon(id, name);
    }
}
