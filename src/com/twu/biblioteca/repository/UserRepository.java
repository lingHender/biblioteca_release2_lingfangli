package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
    public static final List<User> USER__LIST =
            new ArrayList<User>() {
                {
                    add(new User("Lucy","customer", "123-4567", "123@qq.com","15100002222","abc"));
                    add(new User("Jim","customer", "456-7890", "456@qq.com","18900001111","def"));
                    add(new User("Mary","librarian", "789-1234", "xyz"));
                }
            };

    public User login(String libraryNumber,String password){
        Iterator<User> it = USER__LIST.iterator();
        while(it.hasNext()){
            User tmp = it.next();
            if(tmp.getLibraryNumber().equals(libraryNumber)&&tmp.getPassword().equals(password)){
                tmp.setLogin(true);
                return tmp;
            }
        }
        return null;
    }

    public User getUserByLibraryNumber(String libraryNUmber){
        Iterator<User> it = USER__LIST.iterator();
        while(it.hasNext()){
            User tmp = it.next();
            if(tmp.getLibraryNumber().equals(libraryNUmber))
                return tmp;
        }
        return null;
    }
}
