package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;

public class Login implements MyCommand {
    public Login() {

    }

    @Override
    public String excute(Console console, User user) {
        return "Login";
    }


    @Override
    public String showOptionName() {
        return "Login";
    }
}
