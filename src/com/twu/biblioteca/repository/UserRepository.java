package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.myCommandImpl.ListBooks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
    public List<User> USER_LIST;

    public UserRepository(List<User> USER_LIST) {
        this.USER_LIST = USER_LIST;
    }

    public User login(String libraryNumber,String password){
        Iterator<User> it = USER_LIST.iterator();
        while(it.hasNext()){
            User tmp = it.next();
            if(tmp.getLibraryNumber().equals(libraryNumber)&&tmp.getPassword().equals(password)){
                tmp.setLogin(true);
                return tmp;
            }
        }
        return null;
    }

    public String accounts(User user){
        String str = String.format("%-20s%-16s%-16s\n", "UserName", "Email", "Phone Number")+
                     "--------------------------------------------------------\n";
        str += user.print();
        return str;

    }

    public User getUserByLibraryNumber(String libraryNUmber){
        Iterator<User> it = USER_LIST.iterator();
        while(it.hasNext()){
            User tmp = it.next();
            if(tmp.getLibraryNumber().equals(libraryNUmber))
                return tmp;
        }
        return null;
    }
}
