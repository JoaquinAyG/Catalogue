package com.study.catalogue.service;

import android.content.Context;

import com.study.catalogue.models.Film;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilmLoader {

    Context context;

    public FilmLoader(Context context) {
        this.context = context;
    }

    public List<Film> load() {
        List<Film> filmList = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("DisneyMoviesDataset.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                filmList.add(parseFilm(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }

    private Film parseFilm(String line) {
        String[] fields = line.split(";");
        int id = (int) Float.parseFloat(fields[0]);
        String title = fields[1];
        int runningTime = (int) Float.parseFloat(fields[2]);
        float budget = Float.parseFloat(fields[3]);
        float boxOffice = Float.parseFloat(fields[4]);
        String releaseDate2 = fields[5];
        String directedBy = fields[6];
        String producedBy = fields[7];
        String musicBy = fields[8];
        return new Film(id, title, runningTime, budget, boxOffice, releaseDate2, directedBy, producedBy, musicBy);
    }

}
