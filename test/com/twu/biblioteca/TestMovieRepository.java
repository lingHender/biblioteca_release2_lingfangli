package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class TestMovieRepository {
    MovieRepository movieRepository;
    List<Movie> MOVIE_LIST;
    List<Movie> noMovie;

    @Before
    public void setUp() {
        MOVIE_LIST = new ArrayList<Movie>() {
            {
                add(new Movie("Movie_0001","Zootopia", "2016", "Byron Howard",9.2f));
                add(new Movie("Movie_0002","Titanic", "1997", "James Cameron",9.1f));
                add(new Movie("Movie_0003","Warcraft", "2016", "Duncan Jones"));
            }
        };
        noMovie = new ArrayList<Movie>();
        movieRepository = new MovieRepository(MOVIE_LIST);
    }

    @Test
    public void should_return_nothing_when_call_listMovies_with_no_any_movie(){
        MovieRepository movieRepository1 = new MovieRepository(noMovie);
        String result = movieRepository1.listMovies();

        assertEquals("",result);
    }

    @Test
    public void should_return_all_movies_information_when_call_listMovies(){
        String result = movieRepository.listMovies();

        String assertResult = String.format("%-15s%-15s%-18s%-13s%-15s\n","Movie_0001","Zootopia", "Byron Howard","2016",9.2f)+
                String.format("%-15s%-15s%-18s%-13s%-15s\n","Movie_0002","Titanic", "James Cameron","1997",9.1f)+
                String.format("%-15s%-15s%-18s%-13s\n","Movie_0003","Warcraft", "Duncan Jones","2016");

        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_movies_without_checkouted_movie_when_call_listMovies(){
        movieRepository.MOVIE_LIST.get(0).setChecked(true);
        String result = movieRepository.listMovies();

        String assertResult =  String.format("%-15s%-15s%-18s%-13s%-15s\n","Movie_0002","Titanic", "James Cameron","1997",9.1f)+
                               String.format("%-15s%-15s%-18s%-13s\n","Movie_0003","Warcraft", "Duncan Jones","2016");
        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_true_when_call_checkMovie_with_checkout_movie_successfully(){
        boolean result = movieRepository.checkMoive(movieRepository.MOVIE_LIST.get(0).getMovieId(),"123-4567");

        assertEquals(true,result);
        assertEquals(true, movieRepository.MOVIE_LIST.get(0).isChecked());
        assertEquals("123-4567", movieRepository.MOVIE_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_false_when_call_checkMovie_without_the_movie(){
        boolean result = movieRepository.checkMoive("PC_0005","123-4567");

        assertEquals(false,result);
    }

    @Test
    public void should_return_false_when_call_checkMovie_with_the_movie_already_checked(){
        movieRepository.MOVIE_LIST.get(0).setChecked(true);
        movieRepository.MOVIE_LIST.get(0).setCheckUser("456-7890");

        boolean result = movieRepository.checkMoive(movieRepository.MOVIE_LIST.get(0).getMovieId(),"123-4567");

        assertEquals(false,result);
        assertNotEquals("123-4567", movieRepository.MOVIE_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_true_when_call_returnMovie_with_checked_movie_successfully(){
        movieRepository.MOVIE_LIST.get(0).setChecked(true);
        movieRepository.MOVIE_LIST.get(0).setCheckUser("123-4567");
        boolean result = movieRepository.returnMovie(movieRepository.MOVIE_LIST.get(0).getMovieId(),"123-4567");

        assertEquals(true,result);
        assertEquals(false, movieRepository.MOVIE_LIST.get(0).isChecked());
        assertNull( movieRepository.MOVIE_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_false_when_call_returnMovie_with_wrong_librayNumber(){
        movieRepository.MOVIE_LIST.get(0).setChecked(true);
        movieRepository.MOVIE_LIST.get(0).setCheckUser("123-4567");
        boolean result = movieRepository.returnMovie(movieRepository.MOVIE_LIST.get(0).getMovieId(),"456-7890");

        assertEquals(false,result);
        assertEquals(true, movieRepository.MOVIE_LIST.get(0).isChecked());
    }

    @Test
    public void should_return_false_when_call_returnMovie_with_unchecked_Movie(){
        boolean result = movieRepository.returnMovie(movieRepository.MOVIE_LIST.get(0).getMovieId(),"123-4567");

        assertEquals(false,result);
        assertEquals(false, movieRepository.MOVIE_LIST.get(0).isChecked());
    }

    @Test
    public void should_return_false_when_call_returnBook_without_the_movie(){
        boolean result = movieRepository.returnMovie("Movie_00089","123-4567");

        assertEquals(false,result);
    }

}
