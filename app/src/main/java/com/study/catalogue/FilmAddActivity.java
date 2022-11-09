package com.study.catalogue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.study.catalogue.models.Film;

public class FilmAddActivity extends AppCompatActivity {

    EditText title, director, producer, music, runningTime, budget, boxOffice, releaseDate;
    Button addButt;
    ImageView imageView;
    Film film = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_add);

        title = findViewById(R.id.titleEditText);
        director = findViewById(R.id.directorEditText);
        producer = findViewById(R.id.producedByEditText);
        music = findViewById(R.id.musicByEditText);
        runningTime = findViewById(R.id.runningTimeEditText);
        budget = findViewById(R.id.budgetEditText);
        boxOffice = findViewById(R.id.boxOfficeEditText);
        releaseDate = findViewById(R.id.releaseDateEditText);
        imageView = findViewById(R.id.imageView);
        addButt = findViewById(R.id.addFilmButton);

        Intent intent = getIntent();
        Film film = (Film) intent.getSerializableExtra("film");

        if (film != null) {
            setAll(film);
        }
    }

    private void setAll(Film film) {
        title.setText(film.getTitle());
        director.setText(film.getDirectedBy());
        producer.setText(film.getProducedBy());
        music.setText(film.getMusicBy());
        runningTime.setText(film.getRunningTime());
        budget.setText(String.valueOf(film.getBudget()));
        boxOffice.setText(String.valueOf(film.getBoxOffice()));
        releaseDate.setText(film.getReleaseDate());
        imageView.setImageResource(R.mipmap.disney_logo_foreground);
    }
}