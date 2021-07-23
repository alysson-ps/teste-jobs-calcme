package com.jobs.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.jobs.api.document.User;

public interface UserRepository extends MongoRepository<User, String>{
    public User findByName(String name);
}