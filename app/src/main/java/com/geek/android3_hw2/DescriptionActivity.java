package com.geek.android3_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geek.android3_hw2.data.FilmStorage;
import com.geek.android3_hw2.data.model.EachFilm;

public class DescriptionActivity extends AppCompatActivity {
 private String id = "";
 private TextView title,orgTitle,desc;
 private final FilmStorage filmStorage = new FilmStorage();
 private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        initViews();
        checkIntent();
        getFilmAndSet();
    }
    private void getFilmAndSet() {
       filmStorage.getFilm(id, this::setData);
    }

    private void setData(EachFilm film) {
        progressBar.setVisibility(View.GONE);
        title.setText(film.getTitle());
        orgTitle.setText(film.getOriginalTitle());
        desc.setText(film.getDescription());
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressbar);
      title = findViewById(R.id.title);
      orgTitle = findViewById(R.id.original_title);
      desc = findViewById(R.id.description);
    }

    private void checkIntent() {
        if (getIntent()!=null){
            id = getIntent().getStringExtra("ID");
        }
    }
}