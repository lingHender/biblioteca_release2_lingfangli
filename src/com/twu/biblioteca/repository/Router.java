package com.twu.biblioteca.repository;

import com.twu.biblioteca.myCommandInterface.MyCommand;

import java.util.Arrays;
import java.util.Map;

public class Router {
    public Map<String,MyCommand> firstCommand;
    public Map<String,MyCommand> secondComand;
    public Map<String,MyCommand> currentComand;

    public Router(Map<String, MyCommand> firstCommand,Map<String,MyCommand> secondComand){
        this.firstCommand = firstCommand;
        this.secondComand = secondComand;
        this.currentComand = firstCommand;
    }


    public MyCommand getCommand(String command){
        MyCommand myCommand = currentComand.get(command);
        return myCommand;
    }

    public String showCurrentMenu(){
        String str = "";
        Object[] keys = currentComand.keySet().toArray();
        Arrays.sort(keys);
        for(int i = 0; i<keys.length; i++){
            str += keys[i]+":"+ currentComand.get(keys[i]).showOptionName() +"  ";

        }
        return str+"\n";
    }

    public void changeCurrentMenu(String command){
        if(command.equals("More Option")) {
            currentComand = secondComand;
        }
        else if(command.equals("Return")){
            currentComand = firstCommand;
        }

    }

    public Map<String, MyCommand> getSecondComand() {
        return secondComand;
    }

    public void setSecondComand(Map<String, MyCommand> secondComand) {
        this.secondComand = secondComand;
    }

    public Map<String, MyCommand> getCurrentComand() {
        return currentComand;
    }

    public void setCurrentComand(Map<String, MyCommand> currentComand) {
        this.currentComand = currentComand;
    }

    public Map<String, MyCommand> getFirstCommand() {
        return firstCommand;
    }

    public void setFirstCommand(Map<String, MyCommand> firstCommand) {
        this.firstCommand = firstCommand;
    }
}
