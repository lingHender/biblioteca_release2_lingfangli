package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;

public class ExitLogin implements MyCommand {
    @Override
    public String excute(Console console, User user) {
        return "Exit Login";
    }

    @Override
    public String showOptionName() {
        return "Exit Login";
    }
}
