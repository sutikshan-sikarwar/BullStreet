package com.sutikshan.bullstreet.repositories;

import com.sutikshan.bullstreet.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods can be added here if needed
    User findByEmail(String email);
}
