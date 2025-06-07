package com.InfoTeck.UserUpdate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.InfoTeck.UserUpdate.User.User;

public interface UserRepository extends MongoRepository<User, String>{

}
