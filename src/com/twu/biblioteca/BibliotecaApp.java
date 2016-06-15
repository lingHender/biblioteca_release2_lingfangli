package com.twu.biblioteca;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandImpl.*;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.Router;
import com.twu.biblioteca.repository.UserRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {
        final List<Book> BOOK_LIST = new ArrayList<Book>() {
                    {
                        add(new Book("PC_0001","the first book", "xiaoming", "2016"));
                        add(new Book("PC_0002","the second book", "xiaohua", "2015"));
                        add(new Book("PC_0003","the third book", "xiaohua", "2014"));
                    }
                };

        final List<Movie> MOVIE_LIST = new ArrayList<Movie>() {
                    {
                        add(new Movie("Movie_0001","Zootopia", "2016", "Byron Howard",9.2f));
                        add(new Movie("Movie_0002","Titanic", "1997", "James Cameron",9.1f));
                        add(new Movie("Movie_0003","Warcraft", "2016", "Duncan Jones"));
                    }
                };

        final List<User> USER_LIST = new ArrayList<User>() {
                    {
                        add(new User("Lucy","customer", "123-4567", "123@qq.com","15100002222","abc"));
                        add(new User("Jim","customer", "456-7890", "456@qq.com","18900001111","def"));
                        add(new User("Mary","librarian", "789-1234", "xyz"));
                    }
                };

        final BookRepository bookRepository = new BookRepository(BOOK_LIST);
        final MovieRepository movieRepository = new MovieRepository(MOVIE_LIST);
        final UserRepository userRepository = new UserRepository(USER_LIST);


        final Map<String,MyCommand> FIRST_MENU = new HashMap<String, MyCommand>(){
            { put("1",new Login()); }
            { put("2",new ListBooks(bookRepository)); }
            { put("3",new ListMoviess(movieRepository)); }
            { put("4",new MoreOption()); }
            { put("5",new ExitLogin());}
            { put("6",new Quit()); }
        };

        final Map<String,MyCommand> SECOND_MENU = new HashMap<String, MyCommand>(){
            { put("1",new CheckoutBook(bookRepository)); }
            { put("2",new ReturnBook(bookRepository)); }
            { put("3",new CheckoutMovie(movieRepository));}
            { put("4",new ReturnMovie(movieRepository)); }
            { put("5",new UserAccounts(userRepository,bookRepository,movieRepository)); }
            { put("6",new Return()); }
        };

        Router router = new Router(FIRST_MENU,SECOND_MENU);
        Console console = new Console(new BufferedReader(new InputStreamReader(System.in)),new PrintStream(System.out));
        Controller controller = new Controller(router,console,userRepository);
        controller.start();
    }
}
