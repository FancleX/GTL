package com.dev.gtl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Comment;
import com.dev.gtl.model.user.Account;
import com.dev.gtl.model.user.User;
import com.dev.gtl.repository.AccountRepository;
import com.dev.gtl.repository.UserRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public BaseResponse<User> getUserById(Long id) {
        // check if the user exists
        if (!userRepository.existsById(id)) {
            return ResultStatus.fail("the user doesn't exist");
        }
        Optional<User> user = userRepository.findById(id);
        return ResultStatus.success(user.get());
    }

    // add a user
    @Transactional
    public BaseResponse<String> addUser(User user) {
        // check if the user exists
        List<User> userList = userRepository.findAll();
        for (User u : userList) {
            if (user.getAccount().getEmail().equals(u.getAccount().getEmail())) {
                return ResultStatus.fail("the user existed");
            }
        }
        // a user at lease should have a valid email address and password
        if ((user.getAccount().getEmail() == null) || (user.getAccount().getEmail() == "")) {
            return ResultStatus.fail("invalid email address");
        }
        if ((user.getAccount().getPassWord() == null) || (user.getAccount().getPassWord() == "")) {
            return ResultStatus.fail("invalid password");
        }
        userRepository.save(user);
        return ResultStatus.success(user.getAccount().getUserName());
    }

    @Transactional
    // format "email=xxxx&password=xxxxxxxx"
    public BaseResponse<Boolean> isSignIn(String data) {
        String email;
        String password;
        String[] ls = data.split("&");
        email = ls[0].split("=")[1];
        password = ls[1].split("=")[1];
        password = password.substring(0, password.length() - 4);
        Optional<Account> account = accountRepository.findByEmail(email);
        if (!account.isPresent()) {
            return ResultStatus.fail("the user is not in the database");
        }
        if (account.get().getPassWord().equals(password)) {
            return ResultStatus.success(true);
        }
        return ResultStatus.fail("incorrect password");
    }

    public BaseResponse<List<Article>> getBookMarks(Long id) {
        if (!userRepository.existsById(id)) {
            return ResultStatus.fail("the user doesn't exist");
        }
        User user = userRepository.findById(id).get();
        return ResultStatus.success(user.getBookMarks());
    }

    @Transactional
    public BaseResponse<String> addBookMarks(String data) {
        try {
            Object obj = new JSONParser().parse(data);
            JSONObject jo = (JSONObject) obj;
            Long userId = (Long) jo.get("userId");
            Long articleId = (Long) jo.get("articleId");
            userRepository.addBookMark(userId, articleId);
            return ResultStatus.success("bookmark done");
        } catch (ParseException e) {
            return ResultStatus.fail("input format is wrong");
        }
    }

    public BaseResponse<List<Comment>> getComments(Long userId) {
        try {
            User user = userRepository.findById(userId).get();
            return ResultStatus.success(user.getComments());
        } catch (NoSuchElementException e) {
            return ResultStatus.fail("the user doesn't exist");
        }
    }

    public BaseResponse<List<String>> getNames(String ids){
        try {
            Object obj = new JSONParser().parse(ids);
            System.out.println("failed");
            JSONObject jo = (JSONObject) obj;
            JSONArray arr = new JSONArray();
            arr = (JSONArray) jo.get("userIds");
            // cover json array to list<Long>
            List<Long> userIds = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                userIds.add(Long.parseLong(arr.get(i).toString()));
            }
            // fetch user name from ids
            List<String> data = new ArrayList<>();
            for (int i = 0; i < userIds.size(); i++) {
                data.add(userRepository.getUserName(userIds.get(i)));
            }
            return ResultStatus.success(data);
        } catch (ParseException e) {
            return null;
        }
    }
}
