package com.cavalos.springboot.service;

import com.cavalos.springboot.model.User;
import com.cavalos.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }
}
