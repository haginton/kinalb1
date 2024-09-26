package com.postgre.sql.repository.mongo.user;

import com.postgre.sql.model.mongo.UserMongo;
import com.postgre.sql.model.sql.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositoryMongo extends MongoRepository<UserMongo, String> {

    Optional<UserMongo> findByEmail(String email);
}
