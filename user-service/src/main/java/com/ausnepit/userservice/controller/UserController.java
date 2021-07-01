package com.ausnepit.userservice.controller;

import com.ausnepit.userservice.dto.ResponseTemplate;
import com.ausnepit.userservice.entity.User;
import com.ausnepit.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author slap4msth
 * created-date: 2021-03-15
 * package-name: com.ausnepit.userservice.controller
 * project-name: user-service
 */
@RestController
@Slf4j
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/save")
    public User saveUser(@RequestBody User user){
        log.info("Inside save user of User controller::{}",user);
        return userService.saveUser(user);
    }
    @GetMapping(value = "/get-by-id/{id}")
    public ResponseTemplate getUserByIdWithDepartment   (@PathVariable("id")Long userId){
        log.info("Inside getUserById of User controller::{}",userId);
        return userService.getUserByIdWithDepartment(userId);
    }
}
