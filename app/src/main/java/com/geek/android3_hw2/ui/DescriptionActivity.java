package com.geek.android3_hw2.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.geek.android3_hw2.data.FilmStorage;
import com.geek.android3_hw2.data.model.EachFilm;
import com.geek.android3_hw2.databinding.ActivityDescriptionBinding;

public class DescriptionActivity extends AppCompatActivity {
    private ActivityDescriptionBinding binding;
    private String id = "";
    private final FilmStorage filmStorage = new FilmStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkIntent();
        getFilmAndSet();
    }

    private void getFilmAndSet() {
        filmStorage.getFilm(id, this::setData);
    }

    private void setData(EachFilm film) {
        binding.progressbar.setVisibility(View.GONE);
        binding.title.setText(film.getTitle());
        binding.originalTitle.setText(film.getOriginalTitle());
        binding.producer.setText(film.getProducer());
        binding.releaseDate.setText(film.getReleaseDate());
        binding.description.setText(film.getDescription());
    }

    private void checkIntent() {
        if (getIntent() != null) {
            id = getIntent().getStringExtra("ID");
        }
    }
}