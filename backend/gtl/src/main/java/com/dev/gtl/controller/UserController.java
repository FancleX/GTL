package com.dev.gtl.controller;

import java.util.List;

import com.dev.gtl.model.article.Article;
import com.dev.gtl.model.article.Comment;
import com.dev.gtl.model.user.User;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
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
    // JSON format {"email": "xxxx", "password": "xxxx"}
    @PostMapping("/sign_in")
    public BaseResponse<Long> isSignIn(@RequestBody String data) {
        return userService.isSignIn(data);
    }

    // get bookmarks
    @GetMapping("/bookmark/{userId}")
    public BaseResponse<List<Article>> getBookMarks(@PathVariable(value = "userId") Long id) {
        return userService.getBookMarks(id);
    }

    // add bookmarks
    // JSON format {"articleId": xxxxx, "userId": xxxx}
    @PostMapping("/bookmark/add")
    public BaseResponse<String> addBookMarks(@RequestBody String data) {
        return userService.addBookMarks(data);
    }

    // get all comments of the user
    @GetMapping("/comments/{userId}")
    public BaseResponse<List<Comment>> getComments(@PathVariable(value = "userId") Long userId) {
        return userService.getComments(userId);
    }

    // JSON format {"userIds": []}
    @PostMapping("/getNames")
    public BaseResponse<List<String>> getNames(@RequestBody String ids){
        return userService.getNames(ids);
    }
}
