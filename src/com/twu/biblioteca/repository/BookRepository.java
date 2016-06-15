package com.twu.biblioteca.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.twu.biblioteca.model.Book;

public class BookRepository {
    public List<Book> BOOK_LIST ;
    public BookRepository(List<Book> books) {
        this.BOOK_LIST  = books;
    }

    public List<Book> findAllCheckedBooks() {
        List<Book> checkedBooks = new ArrayList<Book>();
        Iterator<Book> it = BOOK_LIST.iterator();
        while(it.hasNext()){
             Book book = it.next();
            if(book.isChecked()){
                checkedBooks.add(book);
            }
        }
        return checkedBooks;
    }

    public boolean checkBook(String isbn,String libraryNumber) {
        Iterator<Book> it = BOOK_LIST.iterator();
        boolean result = false ;
        while (it.hasNext()) {
            Book book = it.next();
            if (isbn.equals(book.getIsbn())&&!book.isChecked()) {
                book.setChecked(true);
                book.setCheckUser(libraryNumber);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean returnBook(String isbn,String libraryNumber){
        Iterator<Book> it = BOOK_LIST.iterator();
        boolean result = false;
        while(it.hasNext()){
            Book book = it.next();
            if(isbn.equals(book.getIsbn())&&book.isChecked()&&libraryNumber.equals(book.getCheckUser())){
                book.setChecked(false);
                book.setCheckUser(null);
                result = true;
            }
        }
        return result;
    }

    public String listBooks(){
        String str = "";
        Iterator<Book> it = BOOK_LIST.iterator();
        while(it.hasNext()){
            Book book = it.next();
            if(!book.isChecked()) {
                str += book.print();
            }
        }
        return str;
    }

}