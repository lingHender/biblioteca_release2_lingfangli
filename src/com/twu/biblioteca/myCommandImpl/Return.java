package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;

public class Return implements MyCommand{
    public Return() {
    }

    @Override
    public String excute(Console console, User user) {
        return "Return";
    }

    @Override
    public String showOptionName() {
        return "Return";
    }
}
