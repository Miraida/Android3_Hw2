package com.geek.android3_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.geek.android3_hw2.presentation.FilmsAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        FilmsAdapter adapter = new FilmsAdapter(this::onItemClick);
        recyclerView.setAdapter(adapter);
    }

    private void onItemClick(String id) {
        Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}