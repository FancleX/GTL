package com.dev.gtl.model.user;

public class Account {
    
    private String email;
    private String passWord;


    public Account(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", passWord='" + getPassWord() + "'" +
            "}";
    }
}


