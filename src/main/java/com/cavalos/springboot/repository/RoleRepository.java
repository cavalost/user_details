package com.cavalos.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.cavalos.springboot.model.Role;
import com.cavalos.springboot.model.ERole;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);

}
