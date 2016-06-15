package com.twu.biblioteca.myCommandInterface;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;

public interface MyCommand {
    String excute(Console console, User user);
    String showOptionName();
}
