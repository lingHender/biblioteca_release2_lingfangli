package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static  org.junit.Assert.assertEquals;

public class TestUserRepository {
    private UserRepository userRepository;


    @Before
    public  void setUp(){
        userRepository = new UserRepository();
    }

    @Test
    public void should_return_user_islogin_true_with_login_successfully(){
        String libraryNumber = "123-4567";
        String password = "abc";
        User user = userRepository.login(libraryNumber,password);

        assertEquals(true,user.isLogin());
    }

    @Test
    public void should_return_user_islogin_false_with_login_successfully(){
        String libraryNumber = "1234567";
        String password = "abc";
        User user = userRepository.login(libraryNumber,password);

        assertEquals(null,user);
    }

    @Test
    public void should_return_null_with_wrong_libraryNumber(){
        String libraryNumber = "1234567";

        assertEquals(null,userRepository.getUserByLibraryNumber(libraryNumber));
    }

    @Test
    public void should_return_user_with_right_libraryNumber(){
        String libraryNumber = "123-4567";
        User user = userRepository.getUserByLibraryNumber(libraryNumber);
        assertEquals(true,user!=null);
    }
}
