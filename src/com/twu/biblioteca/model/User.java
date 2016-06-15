package com.twu.biblioteca.model;

public class User {
    String role;
    String name;
    String libraryNumber;
    String email;
    String phoneNumber;
    String password;
    boolean login;

    public User(String name,String role, String libraryNumber, String email, String phoneNumber, String password) {
        this.name = name;
        this.role = role;
        this.libraryNumber = libraryNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.login = false;
    }

    public User(String name,String role, String libraryNumber, String password) {
        this.name = name;
        this.role = role;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.login = false;
    }

    public String print(){
        return String.format("%-20s%-16s%-16s\n", this.getName(), this.getEmail(), this.getPhoneNumber());

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
