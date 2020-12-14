package com.cavalos.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cavalos.springboot.model.User;

public interface UserRepository extends MongoRepository<User, String>{
}
