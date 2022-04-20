package com.dev.gtl.service;

import java.util.List;
import java.util.Optional;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.user.Account;
import com.dev.gtl.model.user.User;
import com.dev.gtl.repository.AccountRepository;
import com.dev.gtl.repository.UserRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

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
        password = password.substring(0, password.length()-4);
        Optional<Account> account = accountRepository.findByEmail(email);
        if (!account.isPresent()) {
            return ResultStatus.fail("the user is not in the database");
        }
        if (account.get().getPassWord().equals(password)) {
            return ResultStatus.success(true);
        }
        return ResultStatus.fail("incorrect password");
    }

}
