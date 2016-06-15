package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;

public class ReturnBook implements MyCommand{
    public BookRepository bookRepository;
    public ReturnBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String excute(Console console, User user) {
        console.print("please input the book's isbn you want to return:\n");
        String isbn = console.getInput();
        boolean result = bookRepository.returnBook(isbn,user.getLibraryNumber());
        if(result){
            return "Thank you for returning the book!\n";
        }
        else
            return "That is not a valid book to return!\n";
    }

    @Override
    public String showOptionName() {
        return "Return Book";
    }
}
