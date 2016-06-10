package com.twu.biblioteca;

import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestMovieRepository {
    private MovieRepository movieRepository;

    @Before
    public void setUp(){
        movieRepository = new MovieRepository();
    }

    @Test
    public void should_return_true_with_checked_movies_successfully(){
        String movieName = "Zootopia";
        String libraryNumber = "123-4567";

        assertEquals(true,movieRepository.movieChecked(movieName,libraryNumber));
    }

    @Test
    public void should_return_false_with_checked_movies_unsuccessfully_wrong_librayNumber(){
        String movieName = "Zootopia";
        String libraryNumber = "123444";

        assertEquals(false,movieRepository.movieChecked(movieName,libraryNumber));
    }

    @Test
    public void should_return_false_with_checked_movies_unsuccessfully_wrong_movieName(){
        String movieName = "Zootopiass";
        String libraryNumber = "123-4567";

        assertEquals(false,movieRepository.movieChecked(movieName,libraryNumber));
    }


}
