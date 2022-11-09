package com.study.catalogue.models;

import java.io.Serializable;
import java.util.Objects;

public class Film implements Serializable {

    private int id;
    private String title;
    private int runningTime;
    private float budget;
    private float boxOffice;
    private String releaseDate;
    private String directedBy;
    private String producedBy;
    private String musicBy;

    public Film(int id, String title, int runningTime, float budget, float boxOffice, String releaseDate2, String directedBy, String producedBy, String musicBy) {
        this.id = id;
        this.title = title;
        this.runningTime = runningTime;
        this.budget = budget;
        this.boxOffice = boxOffice;
        this.releaseDate = releaseDate2;
        this.directedBy = directedBy;
        this.producedBy = producedBy;
        this.musicBy = musicBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(float boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public String getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(String producedBy) {
        this.producedBy = producedBy;
    }

    public String getMusicBy() {
        return musicBy;
    }

    public void setMusicBy(String musicBy) {
        this.musicBy = musicBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
