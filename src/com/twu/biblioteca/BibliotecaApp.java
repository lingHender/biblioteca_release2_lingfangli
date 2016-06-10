package com.twu.biblioteca;

import com.twu.biblioteca.functionImpl.MainMenuFuntion;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.MenuRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MainMenuFuntion mainMenuFuntion = new MainMenuFuntion(new MenuRepository(),new MovieRepository(),new UserRepository());
        System.out.println("Welcome use Biblioteca systerm!");
        User user = null;
        while(true){
            mainMenuFuntion.showMenu();
            String line = sc.nextLine();
            if(!mainMenuFuntion.validMenu(user,line)){
                continue;
            }else{
                if(line.equals("Q")) break;
                if(line.equals("L")) {
                    user = mainMenuFuntion.login();
                    if(user!=null&&user.isLogin()){
                        System.out.println("login successfully");
                    }else {
                        System.out.println("login unsuccessfully");
                    }
                    continue;
                }
                if(line.equals("LM")){
                    mainMenuFuntion.listMovies();
                    continue;
                }
                if(line.equals("UC")){
                    mainMenuFuntion.userAccounts(user);
                    continue;
                }
                if(line.equals("CM")){
                    if(mainMenuFuntion.checkoutMoive(user)){
                        System.out.println("checkout Successfully");
                    }else {
                        System.out.println("checkout Unsuccessfully");
                    }
                    continue;
                }
            }
        }
    }
}
