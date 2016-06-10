package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieRepository {
    public static final List<Movie> MOVIES_LIST =
            new ArrayList<Movie>() {
                {
                    add(new Movie("Zootopia", "2016", "Byron Howard",9.2f));
                    add(new Movie("Titanic", "1997", "James Cameron",9.1f));
                    add(new Movie("Warcraft", "2016", "Duncan Jones"));
                }
            };

    public Iterator<Movie> findAllMovies() {
        return MOVIES_LIST.iterator();
    }

    public boolean  movieChecked(String movieName,String libraryNumber){
        boolean result = false;
        Iterator<Movie>  it = MOVIES_LIST.iterator();
        while(it.hasNext()){
            Movie movie = it.next();
            if(movie.getName().equals(movieName)&&!movie.isChecked()){
                movie.setChecked(true);
                movie.setCheckUser(libraryNumber);
                result = true;
                break;
            }
        }
        return result;
    }

}
