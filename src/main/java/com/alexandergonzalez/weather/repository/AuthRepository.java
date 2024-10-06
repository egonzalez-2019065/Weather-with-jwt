package com.alexandergonzalez.weather.repository;

import com.alexandergonzalez.weather.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}
