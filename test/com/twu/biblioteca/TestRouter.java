package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.myCommandImpl.CheckoutBook;
import com.twu.biblioteca.myCommandImpl.ListBooks;
import com.twu.biblioteca.myCommandImpl.Quit;
import com.twu.biblioteca.myCommandImpl.ReturnBook;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.Router;

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
    Map<String,MyCommand> COMMAND;
    BookRepository bookRepository;
    List<Book> BOOK_LIST ;
    @Before
    public void setup(){
        BOOK_LIST = new ArrayList<Book>();
        COMMAND = new HashMap<String, MyCommand>(){
            { put("1",new ListBooks(new BookRepository(BOOK_LIST))); }
            { put("2",new CheckoutBook(new BookRepository(BOOK_LIST))); }
            { put("3",new ReturnBook(new BookRepository(BOOK_LIST))); }
            { put("4",new Quit()); }
        };
       // router = new Router(COMMAND);
        bookRepository = new BookRepository(BOOK_LIST);
    }

    @Test
    public void should_return_ListBooks_class_when_command_string_equal_1(){
        MyCommand myCommand = router.getCommand("1");
        ListBooks listBooks = new ListBooks(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = listBooks.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_CkeckoutBook_class_when_command_string_equal_2(){
        MyCommand myCommand = router.getCommand("2");
        CheckoutBook checkoutBook = new CheckoutBook(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = checkoutBook.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_ReturnBook_class_when_command_string_equal_3(){
        MyCommand myCommand = router.getCommand("3");
        ReturnBook returnBook = new ReturnBook(bookRepository);
        String className = myCommand.getClass().getName();
        String assertClassName = returnBook.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_ReturnBook_class_when_command_string_equal_4(){
        MyCommand myCommand = router.getCommand("4");
        Quit quit = new Quit();
        String className = myCommand.getClass().getName();
        String assertClassName = quit.getClass().getName();

        assertEquals(assertClassName,className);
    }

    @Test
    public void should_return_null_when_command_string_not_exit(){
        MyCommand myCommand = router.getCommand("5");

        assertNull(myCommand);
    }
}
