package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.MovieRepository;

public class ReturnMovie implements MyCommand{
    public MovieRepository movieRepository;

    public ReturnMovie(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String excute(Console console, User user) {
        console.print("please input the movieId isbn you want to return:\n");
        String movieId = console.getInput();
        boolean result = movieRepository.returnMovie(movieId,user.getLibraryNumber());
        if(result){
            return "Thank you for returning the movie!\n";
        }
        else
            return "That is not a valid movie to return!\n";
    }

    @Override
    public String showOptionName() {
        return "Return Book";
    }
}
