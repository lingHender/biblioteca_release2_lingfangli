package com.twu.biblioteca.repository;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MenuRepository {
    public static final Map<String,String> MENU = new HashMap<String, String>(){
        {put("LM","List Movies");}
        {put("CM","Checkout Movie");}
        {put("L","Login");}
        {put("Q","Quit");}
        {put("UC","User Accounts");}
    };

    public Set<Map.Entry<String,String>> getEntry(){
        return MENU.entrySet();
    }

    public boolean containKey(String key){
        return MENU.containsKey(key);
    }
}
