package com.study.catalogue;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.catalogue.adapters.FilmAdapter;
import com.study.catalogue.models.Film;
import com.study.catalogue.service.FilmLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Film selectedFilm = null;
    List<Film> filmList = new ArrayList<>();
    FilmAdapter adapter;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FilmLoader filmLoader = new FilmLoader(this);
        filmList = new ArrayList<>(filmLoader.load());

        recyclerView = findViewById(R.id.recyclerview);

        Button butAdd = findViewById(R.id.buttonAdd);
        Button butInspect = findViewById(R.id.buttonInspect);
        Button butDel = findViewById(R.id.buttonDelete);
        Button butUpdate = findViewById(R.id.buttonUpdate);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new FilmAdapter(filmList);

        adapter.setOnClickListener(view -> selectedFilm = filmList.get(recyclerView.getChildAdapterPosition(view)));

        butInspect.setOnClickListener(view -> openFilmViewActivity());

        butAdd.setOnClickListener(view -> openFilmAddActivity());

        butDel.setOnClickListener(view -> {
            filmList.remove(selectedFilm);
            adapter.notifyDataSetChanged();
        });

        butUpdate.setOnClickListener(view -> openFilmUpdateActivity());

        recyclerView.setAdapter(adapter);

    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        Film film = (Film) data.getSerializableExtra("film");
                        addFilm(film);
                    }
                }
            });

    private void openFilmUpdateActivity() {
        Intent intent = new Intent(this, FilmAddActivity.class);
        intent.putExtra("film", selectedFilm);
        intent.putExtra(Constants.EDITABLE, true);
        activityResultLauncher.launch(intent);
    }

    private void openFilmAddActivity() {
        Intent intent = new Intent(this, FilmAddActivity.class);
        intent.putExtra(Constants.EDITABLE, true);
        activityResultLauncher.launch(intent);
    }

    private void openFilmViewActivity(){
        Intent intent = new Intent(this, FilmAddActivity.class);
        intent.putExtra("film", selectedFilm);
        intent.putExtra(Constants.EDITABLE, false);
        activityResultLauncher.launch(intent);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addFilm(Film film) {
        if(film.getId() == -1){
            film.setId(getNextId());
        } else {
            filmList.stream().filter(film1 -> film.getId() == film1.getId()).findAny().ifPresent(onSearch -> filmList.remove(onSearch));
        }

        filmList.add(film);
        adapter.notifyDataSetChanged();
    }

    public int getNextId() {
        return Collections.max(filmList, Comparator.comparingInt(Film::getId)).getId() + 1;
    }
}