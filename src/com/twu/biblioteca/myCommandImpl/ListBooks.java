package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.BookRepository;

public class ListBooks implements MyCommand{
    public BookRepository bookRepository;

    public ListBooks(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String excute(Console console, User user) {
        String bookInformation = bookRepository.listBooks();
        if(bookInformation.equals("")) return "There is no books to list!\n";

        String str = "                 List books\n" +
                     String.format("%-10s%-20s%-16s%-16s\n","Isbn","Name","Author","Year")+
                     "--------------------------------------------------------\n";

        str += bookInformation;
        str += "--------------------------------------------------------\n";

        return str;
    }

    @Override
    public String showOptionName() {
        return "List Books";
    }
}
