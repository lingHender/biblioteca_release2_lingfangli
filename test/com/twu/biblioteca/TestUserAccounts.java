package com.twu.biblioteca;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandImpl.UserAccounts;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import  static  org.junit.Assert.assertEquals;

public class TestUserAccounts {

    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    private UserAccounts userAccounts;
    List<Book> BOOK_LIST;
    List<User> USER_LIST;
    List<Movie> MOVIE_LIST;

    @Before
    public void setUp(){
        BOOK_LIST = new ArrayList<Book>() {
            {
                add(new Book("PC_0001","the first book", "xiaoming", "2016"));
                add(new Book("PC_0002","the second book", "xiaohua", "2015"));
            }
        };
        USER_LIST = new ArrayList<User>() {
            {
                add(new User("Lucy","customer", "123-4567", "123@qq.com","15100002222","abc"));
                add(new User("Jim","customer", "456-7890", "456@qq.com","18900001111","def"));
                add(new User("Mary","librarian", "789-1234", "xyz"));
            }
        };
        MOVIE_LIST = new ArrayList<Movie>() {
            {
                add(new Movie("Movie_0001","Zootopia", "2016", "Byron Howard",9.2f));
                add(new Movie("Movie_0002","Titanic", "1997", "James Cameron",9.1f));
            }
        };
        bookRepository = new BookRepository(BOOK_LIST);
        movieRepository = new MovieRepository(MOVIE_LIST);
        userRepository = new UserRepository(USER_LIST);

        userAccounts = new UserAccounts(userRepository,bookRepository,movieRepository);
    }

    @Test
    public  void should_return_checked_books_information_when_call_showCheckedBook_with_checked_book_exit(){
        userAccounts.bookRepository.BOOK_LIST.get(0).setChecked(true);
        userAccounts.bookRepository.BOOK_LIST.get(0).setCheckUser("123-4567");
        String result = userAccounts.showCheckedBook();
        String assertResult = String.format("%-15s%-20s%-16s%-16s%-16s\n", "Book ISBN","BookName", "CheckedBy", "Email", "Phone Number")+
                "------------------------------------------------------------------------------------\n";
        assertResult += String.format("%-15s%-20s%-16s%-16s%-16s\n",
                "PC_0001","the first book","Lucy","123@qq.com","15100002222");

        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_no_books_checked_information_when_call_showCheckedBook_without_checked_book(){
        String result = userAccounts.showCheckedBook();
        String assertResult = "There is no books be checked!\n";

        assertEquals(assertResult,result);

    }

    @Test
    public  void should_return_checked_movies_information_when_call_showCheckedMovie_with_checked_movies_exit(){
        userAccounts.movieRepository.MOVIE_LIST.get(0).setChecked(true);
        userAccounts.movieRepository.MOVIE_LIST.get(0).setCheckUser("123-4567");
        String result = userAccounts.showCheckedMovie();
        String assertResult = String.format("%-15s%-20s%-16s%-16s%-16s\n", "MoiveId","MovieName", "CheckedBy", "Email", "Phone Number")+
                "------------------------------------------------------------------------------------\n";
        assertResult += String.format("%-15s%-20s%-16s%-16s%-16s\n",
                "Movie_0001","Zootopia","Lucy","123@qq.com","15100002222");

        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_no_movies_checked_information_when_call_showCheckedMovie_without_checked_movie(){
        String result = userAccounts.showCheckedMovie();
        String assertResult = "There is no movies be checked!\n";

        assertEquals(assertResult,result);

    }
}

















