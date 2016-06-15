package com.twu.biblioteca.myCommandImpl;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;

public class MoreOption implements MyCommand {
    public MoreOption() {
    }

    @Override
    public String excute(Console console, User user) {
        if(user == null || !user.isLogin())   return "please login first!\n";
        return "More Option";
    }

    @Override
    public String showOptionName() {
        return "More Option";
    }
}
