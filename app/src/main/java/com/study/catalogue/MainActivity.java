package com.study.catalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.study.catalogue.adapters.FilmAdapter;
import com.study.catalogue.models.Film;
import com.study.catalogue.service.FilmLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FilmLoader filmLoader = new FilmLoader(this);
        List<Film> filmList = new ArrayList<>(filmLoader.load());

        recyclerView = findViewById(R.id.recyclerview);

        if(recyclerView == null){
            System.out.println("recyclerView is null");
        }
        if(filmList.size() == 0){
            System.out.println("filmList is empty");
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new FilmAdapter(filmList));

    }
}