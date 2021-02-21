package com.example.sbs.myapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private int id;
    private String name;

    public String getImgUrl() {
        return "https://pokeres.bastionbot.org/images/pokemon/" + id + ".png";
    }
}
