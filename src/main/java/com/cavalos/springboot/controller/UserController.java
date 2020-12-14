package com.cavalos.springboot.controller;

import com.cavalos.springboot.model.User;
import com.cavalos.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavalos.springboot.message.ResponseMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> saveUser(@RequestBody User user, HttpServletRequest request) {
        try {
            User _user = userService.saveUser(user);
            String message = "User has been added successfully with id = " + _user.getId();

            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                    List.of(user)), HttpStatus.OK);
        } catch(Exception e) {
            String message = "User has not been added";
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
