package com.twu.biblioteca.model;

public class Book {
    String isbn;
    String name;
    String author;
    String year;
    boolean checked;
    String checkUser;


    public Book(String isbn,String name,String author,String year){
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.checked = false;
    }

    public String print(){
        String str = String.format("%-10s%-20s%-16s%-16s\n", this.getIsbn(),this.getName(), this.getAuthor(), this.getYear());
        return str;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }
}
