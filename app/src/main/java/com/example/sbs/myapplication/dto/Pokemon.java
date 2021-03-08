package com.example.sbs.myapplication.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
    public int id;
    public String name;

    public String getImgUrl() {
        return "https://pokeres.bastionbot.org/images/pokemon/" + id + ".png";
    }

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public Pokemon(@JsonProperty("name") String name, @JsonProperty("url") String url) {
        this.name = name;
        String[] urlBits = url.split("/");
        this.id = Integer.parseInt(urlBits[urlBits.length - 1]);
    }
}
