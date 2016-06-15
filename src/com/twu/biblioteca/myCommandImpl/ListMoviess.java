package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;


public class ListMoviess implements MyCommand {
    public MovieRepository movieRepository;

    public ListMoviess(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String excute(Console console, User user) {
        String movieInformation = movieRepository.listMovies();
        if(movieInformation.equals("")) return "There is no movies to list!\n";

        String str = "                              List Movies\n" +
                     String.format("%-15s%-15s%-18s%-10s%-15s\n", "Movie_id","Name", "Director", "Year","Movie Rating")+
                     "-----------------------------------------------------------------------\n";
        str += movieInformation;
             str += "-----------------------------------------------------------------------\n";
        return str;
    }

    @Override
    public String showOptionName() {
        return "List Movies";
    }
}
