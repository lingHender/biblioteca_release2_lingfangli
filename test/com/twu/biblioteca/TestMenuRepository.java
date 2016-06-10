package com.twu.biblioteca;

import com.twu.biblioteca.functionImpl.MainMenuFuntion;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.MenuRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;


import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestMenuRepository {
    MainMenuFuntion mainMenuFuntion;

    @Before
    public void setUp(){
        mainMenuFuntion = new MainMenuFuntion(new MenuRepository() , new MovieRepository() , new UserRepository());
    }

    @Test
    public void should_return_false_with_input_incorrect_menu_A(){
        User user = null;
        boolean result = mainMenuFuntion.validMenu(user,"A");

        assertEquals("not return the right result(false)",false,result);
    }

    @Test
    public void should_return_true_with_input_nullUser_and_L(){
        User user = null;
        boolean result = mainMenuFuntion.validMenu(user,"L");

        assertEquals("not return the right result(true)",true,result);
    }

    @Test
    public void should_return_true_with_input_user_and_LM(){
        User user = new User("Lucy","customer", "123-4567", "123@qq.com","15100002222","abc");
        user.setLogin(true);

        boolean result = mainMenuFuntion.validMenu(user,"LM");

        assertEquals("not return the right result(true)",true,result);
    }

    @Test
    public void should_return_false_with_input_nullUser_and_UC(){
        User user = null;
        boolean result = mainMenuFuntion.validMenu(user,"UC");

        assertEquals("not return the right result(false)",false,result);
    }

    @Test
    public void should_return_true_with_input_login_User_and_UC(){
        User user = new User("Lucy","customer", "123-4567", "123@qq.com","15100002222","abc");
        user.setLogin(true);
        boolean result = mainMenuFuntion.validMenu(user,"UC");

        assertEquals("not return the right result(true)",true,result);
    }


}
