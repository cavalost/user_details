package com.cavalos.springboot.controller;

import com.cavalos.springboot.exception.UserException;
import com.cavalos.springboot.model.User;
import com.cavalos.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cavalos.springboot.message.ResponseMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
                    Arrays.asList(user)), HttpStatus.OK);
        } catch(Exception e) {
            String message = "User has not been added";
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<ResponseMessage> getUserById(@PathVariable String id, HttpServletRequest request) {
        try {
            Optional<User> userOpt = userService.getUserById(id);

            if(userOpt.isPresent()) {
                String message = "User has been displayed successfully with id = " + id;
                return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                        Arrays.asList(userOpt.get())), HttpStatus.OK);
            } else {
                String message = "User not found with the id = " + id;
                return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                        "NOT FOUND"), HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            String message = "Cannot get the User from database with id = " + id;
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessage> updateUser(@PathVariable String id, @RequestBody User user, HttpServletRequest request) {
        try {
            User _user = userService.updateUser(id, user);
            String message = "User has been updated successfully with id = " + id;

            return new ResponseEntity<ResponseMessage> (new ResponseMessage(message, request.getRequestURI(),
                    Arrays.asList(_user)), HttpStatus.OK);
        } catch (UserException ue) {
            String message = "Cannot update, the User is not in the DB with id = " + id;
            return new ResponseEntity<ResponseMessage> (new ResponseMessage(message, request.getRequestURI(),
                    ue.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            String message = "Cannot update the User with id = " + id;
            return new ResponseEntity<ResponseMessage> (new ResponseMessage(message, request.getRequestURI(),
                    e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteUserById(@PathVariable String id, HttpServletRequest request) {
        try {
            userService.deleteUserById(id);

            String message = "User has been deleted successfully with id = " + id;
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI()), HttpStatus.OK);
        } catch(Exception e) {
            String message = "Cannot delete the User with id = " + id;
            return new ResponseEntity<ResponseMessage>(new ResponseMessage(message, request.getRequestURI(), e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
