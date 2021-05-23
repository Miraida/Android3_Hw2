package com.geek.android3_hw2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geek.android3_hw2.R;
import com.geek.android3_hw2.data.model.Films;
import com.geek.android3_hw2.data.remote.RetrofitBuilder;
import com.geek.android3_hw2.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getFilms();
    }

    @EverythingIsNonNull
    private void getFilms() {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    initViews(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    private void initViews(List<Films> list) {
        binding.mainProgressbar.setVisibility(View.GONE);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        FilmsAdapter adapter = new FilmsAdapter(list, this::onItemClick);
        recyclerView.setAdapter(adapter);
    }

    private void onItemClick(String id) {
        Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}