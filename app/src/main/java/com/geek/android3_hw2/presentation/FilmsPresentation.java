package com.geek.android3_hw2.presentation;

import com.geek.android3_hw2.data.model.filmsdomain.DomainFilms;
import com.geek.android3_hw2.data.model.filmsdomain.Films;

import java.util.ArrayList;
import java.util.List;

public class FilmsPresentation {
    private final DomainFilms domainFilms;

    public FilmsPresentation(){
        List<String> listId = new ArrayList<>();
        listId.add("2baf70d1-42bb-4437-b551-e5fed5a87abe");
        listId.add("12cfb892-aac0-4c5b-94af-521852e46d6a");
        listId.add("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        listId.add("ea660b10-85c4-4ae3-8a5f-41cea3648e3e");
        listId.add("4e236f34-b981-41c3-8c65-f8c9000b94e7");
        List<String>listTitle = new ArrayList<>();
        listTitle.add("Castle in the Sky");
        listTitle.add("Grave of the Fireflies");
        listTitle.add("My Neighbor Totoro");
        listTitle.add("Kiki's Delivery Service");
        listTitle.add("Only Yesterday");
        domainFilms = new DomainFilms(listId,listTitle);
    }
    public List<Films<String,String>> getFilmsList(){
        return domainFilms.getFilmsList();
    }

}
