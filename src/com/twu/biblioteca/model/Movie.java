package com.twu.biblioteca.model;

public class Movie {
    String movieId;
    String name;
    String year;
    String director;
    float reting;
    boolean checked;
    String checkUser;

    public Movie(String movieId,String name, String year, String director, float reting) {
        this.movieId = movieId;
        this.name = name;
        this.year = year;
        this.director = director;
        this.reting = reting;
    }

    public Movie(String movieId,String name, String year, String director) {
        this.movieId = movieId;
        this.name = name;
        this.year = year;
        this.director = director;
        this.reting = -100f;
    }

    public String print(){
        if(reting < 0) {
            return String.format("%-15s%-15s%-18s%-13s\n", this.getMovieId(), this.getName(), this.getDirector(), this.getYear());
        } else {
            return String.format("%-15s%-15s%-18s%-13s%-15s\n", this.getMovieId(), this.getName(), this.getDirector(), this.getYear(), this.getReting());
        }
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getReting() {
        return reting;
    }

    public void setReting(float reting) {
        this.reting = reting;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }
}
