package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;

public class CheckoutMovie implements MyCommand {
    public MovieRepository movieRepository;

    public CheckoutMovie(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public String excute(Console console, User user) {
        console.print("please input the movieId you want to check out:\n");
        String movieId = console.getInput();
        boolean result = movieRepository.checkMoive(movieId,user.getLibraryNumber());
        if(result){
            return "Thank you! Enjoy the Movie\n";
        }
        else
            return  "That Movie is not available\n";
    }

    @Override
    public String showOptionName() {
        return "Checkout Movies";
    }
}
