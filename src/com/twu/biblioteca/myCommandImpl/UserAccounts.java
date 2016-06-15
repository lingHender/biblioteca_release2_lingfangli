package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;

import java.util.Iterator;
import java.util.List;

public class UserAccounts implements MyCommand {
    public UserRepository userRepository;
    public MovieRepository movieRepository;
    public BookRepository bookRepository;

    public UserAccounts(UserRepository userRepository, BookRepository bookRepository,MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public String excute(Console console, User user) {
        if(user.getRole().equals("customer")){
            return  userRepository.accounts(user);
        } else {
           String str = showCheckedBook()+"\n"+ showCheckedMovie();
            return str;
        }
    }
    public String  showCheckedBook(){
        List<Book> checkedBooks = bookRepository.findAllCheckedBooks();
        if(checkedBooks.size()== 0) return "There is no books be checked!\n";

        String str = String.format("%-15s%-20s%-16s%-16s%-16s\n", "Book ISBN","BookName", "CheckedBy", "Email", "Phone Number")+
                "------------------------------------------------------------------------------------\n";
        Iterator<Book> it = checkedBooks.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            String librarianNumber = book.getCheckUser();
            User tmpUser = userRepository.getUserByLibraryNumber(librarianNumber);
            str += String.format("%-15s%-20s%-16s%-16s%-16s\n", book.getIsbn(),book.getName(), tmpUser.getName(), tmpUser.getEmail(), tmpUser.getPhoneNumber());
        }
        return str;
    }

    public String  showCheckedMovie(){
        List<Movie> checkedMovies = movieRepository.findAllCheckedMovies();
        if(checkedMovies.size()== 0) return "There is no movies be checked!\n";

        String str = String.format("%-15s%-20s%-16s%-16s%-16s\n", "MoiveId","MovieName", "CheckedBy", "Email", "Phone Number")+
                "------------------------------------------------------------------------------------\n";
        Iterator<Movie> it = checkedMovies.iterator();
        while (it.hasNext()) {
            Movie movie = it.next();
            String librarianNumber = movie.getCheckUser();
            User tmpUser = userRepository.getUserByLibraryNumber(librarianNumber);
            str += String.format("%-15s%-20s%-16s%-16s%-16s\n", movie.getMovieId(),movie.getName(), tmpUser.getName(), tmpUser.getEmail(), tmpUser.getPhoneNumber());
        }
        return str;
    }

    @Override
    public String showOptionName() {
        return "User Accounts";
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
