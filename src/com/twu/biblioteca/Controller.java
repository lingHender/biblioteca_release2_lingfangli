package com.twu.biblioteca;

import com.twu.biblioteca.console.Console;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandInterface.MyCommand;
import com.twu.biblioteca.repository.Router;
import com.twu.biblioteca.repository.UserRepository;


public class Controller {
    public Router router;
    public Console console;
    public boolean isContinue;
    public  UserRepository userRepository;
    public User user;

    public Controller(Router router, Console console, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.router = router;
        this.console = console;
        isContinue  = true;
    }

    public void start(){
        showWelcome();
        while(isContinue){
            showMenu();
            String option = console.getInput();
            String excuteResult = excuteOption(option);
            if(excuteResult.equals("Quit")) {
                console.print("Thank you for using Bangalore Public Library!");
                isContinue = false;
                continue;
            }
            if(excuteResult.equals("Login")){
                console.print(login());
                continue;
            }
            if(excuteResult.equals("Exit Login")){
                user = null;
                continue;
            }
            if(excuteResult.equals("More Option")||excuteResult.equals("Return")){
                router.changeCurrentMenu(excuteResult);
                continue;
            }

            console.print(excuteResult);
        }

    }

    public void showWelcome(){
        console.print("Welcome!\n");
    }

    public void showMenu(){
        String str = "********Main Menu********\n";
        str += router.showCurrentMenu();
        console.print(str);

    }

    public String login(){
        if(user != null && user.isLogin()){
            return "you have login";
        }
        console.print("please input your libraryNumber:\n");
        String libraryNumber = console.getInput();
        console.print("please input your password:\n");
        String password = console.getInput();
        User user = userRepository.login(libraryNumber,password);
        if(user != null ){
            this.user = user;
            return "Login successfully\n";
        }
        else
            return "LibraryNumber or password is wrong!\n";
    }

    public String exitLogin(){
        if(user == null) return "you haven't login!\n";
        user = null;
        return "Exit Login successfully!\n";
    }

    public String excuteOption(String option){
        MyCommand myCommand = router.getCommand(option);
        if(myCommand == null){
            return "Select a valid option!\n";
        } else {
            return myCommand.excute(console,user);
        }
    }

}
