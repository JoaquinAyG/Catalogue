package com.study.catalogue.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.study.catalogue.R;
import com.study.catalogue.models.Film;

import java.util.List;
import java.util.Locale;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private List<Film> filmList;

    public FilmAdapter(List<Film> filmList) {
        this.filmList = filmList;
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView title;
        private TextView director;
        private TextView producer;
        private TextView music;
        private TextView runningTime;
        private TextView budget;


        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            director = itemView.findViewById(R.id.director);
            producer = itemView.findViewById(R.id.producer);
            music = itemView.findViewById(R.id.music);
            runningTime = itemView.findViewById(R.id.runningTime);
            budget = itemView.findViewById(R.id.budget);
        }

        public void bindFilm(Film film) {
            imageView.setImageResource(R.mipmap.disney_logo_foreground);
            String a = film.getTitle();
            title.setText(a.toUpperCase(Locale.ROOT));
            director.setText("Directed by: " + film.getDirectedBy());
            producer.setText("Produced by: " + film.getProducedBy());
            music.setText("Music by: " + film.getMusicBy());
            runningTime.setText("Running Time: " + film.getRunningTime());
            budget.setText("Budget: " + film.getBudget());
        }
    }


    @NonNull
    @Override
    public FilmAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.FilmViewHolder holder, int position) {
        holder.bindFilm(filmList.get(position));
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
