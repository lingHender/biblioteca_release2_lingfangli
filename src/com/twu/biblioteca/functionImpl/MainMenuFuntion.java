package com.twu.biblioteca.functionImpl;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.MenuRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainMenuFuntion {
    MenuRepository menuRepository;
    MovieRepository movieRepository;
    UserRepository userRepository;

    public MainMenuFuntion(MenuRepository menuRepository, MovieRepository movieRepository,UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public boolean validMenu(User user,String menu){
        if(menu.equals("Q")||menu.equals("L")||menu.equals("LM")){
            return true;
        }else if(menu.equals("UC")||menu.equals("CM")){
            if(!(user==null)&&user.isLogin())
                return true;
            else {
                System.out.println("please login first");
                return false;
            }
        }else {
            System.out.println("please input right menus");
            return false;
        }
    }
    public void showMenu() {
        System.out.println("********Main Menu********");
        Set<Map.Entry<String, String>> map = menuRepository.getEntry();
        for (Map.Entry<String, String> entry : map) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
        System.out.println();
    }

    public void listMovies() {
        Iterator<Movie> it = movieRepository.findAllMovies();
        System.out.println("--------------------------------------------------------");
        System.out.println(String.format("%-20s%-16s%-16s%-16s", "Name", "Year", "Director", "Movie Rating"));
        while (it.hasNext()) {
            Movie movie = it.next();
            if (!movie.isChecked()) {
                String str = String.format("%-20s%-16s%-16s%-16f", movie.getName(), movie.getYear(), movie.getDirector(), movie.getReting());
                System.out.println(str);
            }
        }
    }

    public void userAccounts(User user) {
        if(user.getRole().equals("customer")){
            System.out.println("--------------------------------------------------------");
            System.out.println(String.format("%-20s%-16s%-16s", "UserName", "Email", "Phone Number"));
            System.out.println(String.format("%-20s%-16s%-16s", user.getName(), user.getEmail(), user.getPhoneNumber()));

        } else {
            System.out.println("--------------------------------------------------------");
            System.out.println(String.format("%-20s%-16s%-16s%-16s", "MovieName", "CheckedBy", "Email", "Phone Number"));
            Iterator<Movie> it = movieRepository.findAllMovies();
            while (it.hasNext()) {
                Movie movie = it.next();
                if (movie.isChecked()) {
                    String librarianNumber = movie.getCheckUser();
                    User tmpUser = userRepository.getUserByLibraryNumber(librarianNumber);
                    System.out.println(String.format("%-20s%-16s%-16s%-16s", movie.getName(), tmpUser.getName(), tmpUser.getEmail(), tmpUser.getPhoneNumber()));
                }
            }
        }
    }

    public boolean checkoutMoive(User user){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the movie name you want to checkout:");
        String movieName = sc.nextLine();
        return movieRepository.movieChecked(movieName,user.getLibraryNumber());
    }

    public  User login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input your libraryNumber:");
        String libraryNumber = sc.nextLine();
        System.out.println("please input your password:");
        String password = sc.nextLine();
        return  userRepository.login(libraryNumber,password);
    }


}






















