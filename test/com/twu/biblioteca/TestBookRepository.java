package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import static  org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;


public class TestBookRepository {
    BookRepository bookRepository ;
    List<Book> books;
    List<Book> noBook;

    @Before
    public void setUp() {
        books = new ArrayList<Book>() {
            {
                add(new Book("PC_0001","the first book", "xiaoming", "2016"));
                add(new Book("PC_0002","the second book", "xiaohua", "2015"));
                add(new Book("PC_0003","the third book", "xiaohua", "2014"));
            }
        };
        noBook = new ArrayList<Book>();
        bookRepository = new BookRepository(books);
    }

    @Test
    public void should_return_nothing_when_call_listBooks_with_no_any_book(){
         BookRepository bookRepository1 = new BookRepository(noBook);
         String result = bookRepository1.listBooks();

         assertEquals("",result);
    }

    @Test
    public void should_return_all_books_information_when_call_listBooks(){
        String result = bookRepository.listBooks();

        String assertResult = String.format("%-10s%-20s%-16s%-16s\n","PC_0001","the first book","xiaoming","2016")+
                              String.format("%-10s%-20s%-16s%-16s\n","PC_0002","the second book","xiaohua","2015")+
                              String.format("%-10s%-20s%-16s%-16s\n","PC_0003","the third book","xiaohua","2014");

        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_books_without_checkouted_book_when_call_listBooks(){
        bookRepository.BOOK_LIST.get(2).setChecked(true);
        String result = bookRepository.listBooks();

        String assertResult = String.format("%-10s%-20s%-16s%-16s\n","PC_0001","the first book","xiaoming","2016")+
                              String.format("%-10s%-20s%-16s%-16s\n","PC_0002","the second book","xiaohua","2015");

        assertEquals(assertResult,result);
    }

    @Test
    public void should_return_true_when_call_checkBook_with_checkout_book_successfully(){
        boolean result = bookRepository.checkBook(bookRepository.BOOK_LIST.get(0).getIsbn(),"123-4567");

        assertEquals(true,result);
        assertEquals(true,bookRepository.BOOK_LIST.get(0).isChecked());
        assertEquals("123-4567",bookRepository.BOOK_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_false_when_call_checkBook_without_the_book(){
          boolean result = bookRepository.checkBook("PC_0005","123-4567");

         assertEquals(false,result);
    }

    @Test
    public void should_return_false_when_call_checkBook_with_the_book_already_checked(){
        bookRepository.BOOK_LIST.get(0).setChecked(true);
        bookRepository.BOOK_LIST.get(0).setCheckUser("456-7890");

        boolean result = bookRepository.checkBook(bookRepository.BOOK_LIST.get(0).getIsbn(),"123-4567");

        assertEquals(false,result);
        assertNotEquals("123-4567",bookRepository.BOOK_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_true_when_call_returnBook_with_checked_book_successfully(){
        bookRepository.BOOK_LIST.get(0).setChecked(true);
        bookRepository.BOOK_LIST.get(0).setCheckUser("123-4567");
        boolean result = bookRepository.returnBook(bookRepository.BOOK_LIST.get(0).getIsbn(),"123-4567");

        assertEquals(true,result);
        assertEquals(false, bookRepository.BOOK_LIST.get(0).isChecked());
        assertNull( bookRepository.BOOK_LIST.get(0).getCheckUser());
    }

    @Test
    public void should_return_false_when_call_returnBook_with_wrong_librayNumber(){
        bookRepository.BOOK_LIST.get(0).setChecked(true);
        bookRepository.BOOK_LIST.get(0).setCheckUser("123-4567");
        boolean result = bookRepository.returnBook(bookRepository.BOOK_LIST.get(0).getIsbn(),"456-7890");

        assertEquals(false,result);
        assertEquals(true, bookRepository.BOOK_LIST.get(0).isChecked());
    }

    @Test
    public void should_return_false_when_call_returnBook_with_unchecked_book(){
        boolean result = bookRepository.returnBook(bookRepository.BOOK_LIST.get(0).getIsbn(),"123-4567");

        assertEquals(false,result);
        assertEquals(false, bookRepository.BOOK_LIST.get(0).isChecked());
    }

    @Test
    public void should_return_false_when_call_returnBook_without_the_book(){
        boolean result = bookRepository.returnBook("PC_00089","123-4567");

        assertEquals(false,result);
    }
}
