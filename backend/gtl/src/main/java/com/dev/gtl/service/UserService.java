package com.dev.gtl.service;

import com.dev.gtl.model.user.User;
import com.dev.gtl.repository.UserRepository;
import com.dev.gtl.response.BaseResponse;
import com.dev.gtl.response.ResultStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public BaseResponse<User> getUserById(Long id) {
        // check if the user exists
        if (!userRepository.existsById(id)) {
            return ResultStatus.fail("the user doesn't exist");
        }
        User user = userRepository.getById(id);
        return ResultStatus.success(user);
    }

    // add a user
    public BaseResponse<String> addUser(User user) {
        // check if the user exists
        if (userRepository.existsById(user.getId())) {
            return ResultStatus.fail("the user existed");
        }
        userRepository.save(user);
        return ResultStatus.success(user.getAccount().getUserName());
    }
}
