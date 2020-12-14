package com.cavalos.springboot.service;

import com.cavalos.springboot.exception.UserException;
import com.cavalos.springboot.model.User;
import com.cavalos.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public Optional<User> getUserById(String id) {
        return repo.findById(id);
    }

    public User updateUser(String id, User user) throws UserException {

        Optional<User> userOpt = repo.findById(id);

        if(!userOpt.isPresent()) {
            throw new UserException("404", "Cannot find a user with id = " + id);
        }

        User _user = userOpt.get();

        _user.setFullName(user.getFullName());
        _user.setEmail(user.getEmail());
        _user.setPassword(user.getPassword());
        _user.setPhoneNumber(user.getPhoneNumber());
        _user.setDepartment(user.getDepartment());
        _user.setJobTitle(user.getJobTitle());

        repo.save(user);

        return user;
    }

    public void deleteUserById(String id) {
        repo.deleteById(id);
    }

}
