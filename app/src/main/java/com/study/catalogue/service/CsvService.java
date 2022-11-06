package com.study.catalogue.service;

import android.content.Context;

import com.study.catalogue.R;
import com.study.catalogue.models.Film;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import kotlin.text.Regex;

public class CsvService {

    Context context;

    public CsvService(Context context) {
        this.context = context;
    }

    public List<Film> load() {
        try {
            InputStream is = context.getAssets().open(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
        } catch (e: Exception) {
            println("Error reading the file")
        }
        return emptyList()
    }

    private List<Film> parse(String line) {
        String[] fields = line.split(",");
        int id = Integer.parseInt(fields[0]);
        val title = fields[1]
        val titleEnglish = fields[2]
        val types = fields[3]
        val episodes = fields[4].toDouble().toInt()
        val status = fields[5]
        val rating = fields[6]
        val genres = fields[8]
        val date = fields[9]
        return AnimeDTO(id, title, titleEnglish, types, episodes, status, date, rating, genres, "$id.jpg")
    }

    private fun toCSV(animeDTO: AnimeDTO): String {
        return """
            ${animeDTO.id}${Properties.CSV_SEPARATOR}${animeDTO.title}${Properties.CSV_SEPARATOR}${animeDTO.titleEnglish}${Properties.CSV_SEPARATOR}${animeDTO.types}${Properties.CSV_SEPARATOR}${animeDTO.episodes}${Properties.CSV_SEPARATOR}${animeDTO.status}${Properties.CSV_SEPARATOR}${animeDTO.date}${Properties.CSV_SEPARATOR}${animeDTO.rating}${Properties.CSV_SEPARATOR}${animeDTO.genres}${Properties.CSV_SEPARATOR}${animeDTO.img}
            """.trimIndent()
    }

}
