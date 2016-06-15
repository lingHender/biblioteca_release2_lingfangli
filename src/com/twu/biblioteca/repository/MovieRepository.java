package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieRepository {
    public List<Movie> MOVIE_LIST ;
    public MovieRepository(List<Movie> movies) {
        this.MOVIE_LIST  = movies;
    }


    public List<Movie> findAllCheckedMovies() {
        List<Movie> checkedMoives = new ArrayList<Movie>();
        Iterator<Movie> it = MOVIE_LIST.iterator();
        while(it.hasNext()){
            Movie movie = it.next();
            if(movie.isChecked()){
                checkedMoives.add(movie);
            }
        }
        return checkedMoives;
    }

    public boolean  checkMoive(String movieId,String libraryNumber){
        Iterator<Movie>  it = MOVIE_LIST.iterator();
        while(it.hasNext()){
            Movie movie = it.next();
            if(movie.getMovieId().equals(movieId)&&!movie.isChecked()){
                movie.setChecked(true);
                movie.setCheckUser(libraryNumber);
                return true;
            }
        }
        return false;
    }

    public boolean returnMovie(String movieId,String libraryNumber){
        Iterator<Movie> it = MOVIE_LIST.iterator();
        while(it.hasNext()){
            Movie movie = it.next();
            if(movie.getMovieId().equals(movieId)&&movie.isChecked()&&movie.getCheckUser().equals(libraryNumber)){
                movie.setChecked(false);
                movie.setCheckUser(null);
                return true;
            }
        }
        return false;
    }

    public String listMovies(){
        String str = "";
        Iterator<Movie> it = MOVIE_LIST.iterator();
        while(it.hasNext()){
            Movie movie = it.next();
            if(!movie.isChecked()) {
                str += movie.print();
            }
        }
        return str;
    }
}
