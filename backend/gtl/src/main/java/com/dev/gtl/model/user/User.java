package com.dev.gtl.model.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private String nickname;
    private Account account;
    private List<Long> bookMarks;

    public User(String nickname, Account account) {
        this.nickname = nickname;
        this.account = account;
        this.bookMarks = new ArrayList<>();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Long> getBookMarks() {
        return this.bookMarks;
    }

    public void addBookMark(long articleId) {
        this.bookMarks.add(articleId);
    }


    @Override
    public String toString() {
        return "{" +
            " nickname='" + getNickname() + "'" +
            ", bookMarks='" + getBookMarks() + "'" +
            "}";
    }

}
