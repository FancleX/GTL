package com.dev.gtl.controller;

import java.util.Map;

import javax.annotation.Resource;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.user.Account;
import com.dev.gtl.model.user.User;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
// @CrossOrigin(origins = "http://127.0.0.1:8080")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // get a sepcific user
    @GetMapping("/{userid}")
    public BaseResponse<User> getUserById(@PathVariable(value = "userid") Long id) {
        return userService.getUserById(id);
    }

    // create a new user
    @PostMapping("/sign_up")
    public BaseResponse<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // user signin
    // format "email=xxxx&password=xxxxxxxx"
    @PostMapping("/sign_in")
    public BaseResponse<Boolean> isSignIn(@RequestBody String data) {
        return userService.isSignIn(data);
    }

    // user create an article
    @PostMapping("/contribute/{userid}/{articleId}")
    public BaseResponse<Long> contribute(@PathVariable(value = "userId") Long id, @PathVariable(value = "article") Article article) {
        return userService.contribute(id, article);
    }

}
