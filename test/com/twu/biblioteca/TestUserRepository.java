package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static  org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class TestUserRepository {
    private UserRepository userRepository;
    private List<User> USER_LIST;

    @Before
    public  void setUp(){
        USER_LIST = new ArrayList<User>() {
            {
                add(new User("Lucy", "customer", "123-4567", "123@qq.com", "15100002222", "abc"));
                add(new User("Jim", "customer", "456-7890", "456@qq.com", "18900001111", "def"));
            }
        };
        userRepository = new UserRepository(USER_LIST);
    }

    @Test
    public void should_return_user_when_call_login_with_login_successfully(){
        String libraryNumber = "123-4567";
        String password = "abc";
        User user = userRepository.login(libraryNumber,password);

        assertEquals("123-4567",user.getLibraryNumber());
        assertEquals(true,user.isLogin());
    }

    @Test
    public void should_return_null_when_call_login_with_wrong_library(){
        String libraryNumber = "1234567";
        String password = "abc";
        User user = userRepository.login(libraryNumber,password);

        assertNull(user);
    }

    @Test
    public void should_return_null_when_call_login_with_wrong_password(){
        String libraryNumber = "123-4567";
        String password = "asd";

        assertEquals(null,userRepository.login(libraryNumber,password));
    }

    @Test
    public void should_return_user_when_call_getUserByLibraryNumber_with_right_libraryNumber(){
        String libraryNumber = "123-4567";
        User user = userRepository.getUserByLibraryNumber(libraryNumber);

        assertEquals("123-4567",user.getLibraryNumber());
        assertEquals("customer",user.getRole());
        assertEquals("Lucy",user.getName());
        assertEquals("123@qq.com",user.getEmail());
        assertEquals("15100002222",user.getPhoneNumber());
        assertEquals("abc",user.getPassword());
    }

    @Test
    public void should_return_null_when_call_getUserByLibraryNumber_with_wrong_libraryNumber(){
        User user = userRepository.getUserByLibraryNumber("1234567");

        assertNull(user);
    }


}
