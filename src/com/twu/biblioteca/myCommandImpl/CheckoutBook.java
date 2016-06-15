package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;


public class CheckoutBook implements MyCommand {
    public  BookRepository bookRepository;
    public CheckoutBook(BookRepository bookRepository) {
        this.bookRepository = bookRepository ;
    }

    public String excute(Console console, User user){
        console.print("please input the book's isbn you want to check out:\n");
        String isbn = console.getInput();
        boolean result  = bookRepository.checkBook(isbn,user.getLibraryNumber());
        if(result){
             return "Thank you! Enjoy the book\n";
        }
        else
            return  "That book is not available\n";
    }

    public  String showOptionName(){
        return "Checkout Book";
    }

}
