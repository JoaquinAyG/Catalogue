package com.study.catalogue;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.catalogue.adapters.FilmAdapter;
import com.study.catalogue.models.Film;
import com.study.catalogue.service.FilmLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Film selectedFilm = null;
    private Button butAdd, butDel, butUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FilmLoader filmLoader = new FilmLoader(this);
        List<Film> filmList = new ArrayList<>(filmLoader.load());

        recyclerView = findViewById(R.id.recyclerview);

        butAdd = findViewById(R.id.buttonAdd);
        butDel = findViewById(R.id.buttonDelete);
        butUpdate = findViewById(R.id.buttonUpdate);

        if (recyclerView == null) {
            System.out.println("recyclerView is null");
        }
        if (filmList.size() == 0) {
            System.out.println("filmList is empty");
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        FilmAdapter adapter = new FilmAdapter(filmList);

        adapter.setOnClickListener(view -> selectedFilm = filmList.get(recyclerView.getChildAdapterPosition(view)));


        recyclerView.setAdapter(adapter);

    }
}