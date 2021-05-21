package com.geek.android3_hw2.data.model.filmsdomain;

import java.util.ArrayList;
import java.util.List;

public class DomainFilms {
    private final List<Films<String,String>> list = new ArrayList<>();

    public DomainFilms(List<String> filmsId,List<String> filmsTitle) {
        for (int i = 0; i <filmsId.size() ; i++) {
            list.add(new Films<String, String>(filmsId.get(i),filmsTitle.get(i)));
        }
    }

    public List<Films<String,String>> getFilmsList(){
        return list;
    }
}
