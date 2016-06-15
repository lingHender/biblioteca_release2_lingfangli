package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandImpl.*;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.Router;

import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import static  org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestRouter {
    Router  router;
    Map<String,MyCommand> FIRST_MENU;
    Map<String,MyCommand> SECOND_MENU;
    BookRepository bookRepository;
    MovieRepository movieRepository;
    UserRepository userRepository;

    @Before
    public void setup(){

        bookRepository = new BookRepository(new ArrayList<Book>());
        movieRepository = new MovieRepository(new ArrayList<Movie>());
        userRepository = new UserRepository(new ArrayList<User>());

        FIRST_MENU = new HashMap<String, MyCommand>(){
            { put("1",new Login()); }
            { put("2",new ListBooks(bookRepository)); }
            { put("3",new ListMoviess(movieRepository)); }
            { put("4",new MoreOption()); }
            { put("5",new ExitLogin());}
            { put("6",new Quit()); }
        };

        SECOND_MENU = new HashMap<String, MyCommand>(){
            { put("1",new CheckoutBook(bookRepository)); }
            { put("2",new ReturnBook(bookRepository)); }
            { put("3",new CheckoutMovie(movieRepository));}
            { put("4",new ReturnMovie(movieRepository)); }
            { put("5",new UserAccounts(userRepository,bookRepository,movieRepository)); }
            { put("6",new Return()); }
        };

        router = new Router(FIRST_MENU,SECOND_MENU);

    }
    @Test
    public void should_return_Login_class_when_command_string_equal_1_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("1");
        Login login = new Login();
        String className = myCommand.getClass().getName();
        String assertClassName = login.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_ListBooks_class_when_command_string_equal_2_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("2");
        ListBooks listBooks = new ListBooks(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = listBooks.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_ListMovies_class_when_command_string_equal_3_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("3");
        ListMoviess listMovies = new ListMoviess(movieRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = listMovies.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_MoreOption_class_when_command_string_equal_4_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("4");
        MoreOption moreOption = new MoreOption();
        String className = myCommand.getClass().getName();
        String assertClassName = moreOption.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return__ExitLogin_class_when_command_string_equal_5_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("5");
        ExitLogin exitLogin = new ExitLogin();
        String className = myCommand.getClass().getName();
        String assertClassName = exitLogin.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return__Quit_class_when_command_string_equal_6_and_current_command_is_FIRST_MENU(){
        MyCommand myCommand = router.getCommand("6");
        Quit quit = new Quit();
        String className = myCommand.getClass().getName();
        String assertClassName = quit.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_CheckBook_class_when_command_string_equal_1_and_current_command_is_SECOND_MENU(){
        router.currentComand = router.secondComand;
        MyCommand myCommand = router.getCommand("1");
        CheckoutBook checkoutBook = new CheckoutBook(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = checkoutBook.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_ReturnBook_class_when_command_string_equal_2_and_current_command_is_SECOND_MENU(){
        router.currentComand = router.secondComand;
        MyCommand myCommand = router.getCommand("2");
        ReturnBook returnBook = new ReturnBook(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = returnBook.getClass().getName();

        assertEquals(assertClassName,className);
    }



    @Test
    public void should_return_null_when_command_string_not_exit(){
        MyCommand myCommand = router.getCommand("9");

        assertNull(myCommand);
    }
}
