package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.Router;

public class Quit implements MyCommand {
    @Override
    public String excute(Console console, User user) {
        return "Quit";
    }

    @Override
    public String showOptionName() {
        return "Quit";
    }
}
