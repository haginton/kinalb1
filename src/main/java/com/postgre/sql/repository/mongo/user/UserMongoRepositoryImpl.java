package com.postgre.sql.repository.mongo.user;

import com.postgre.sql.dto.mapper.DataMapper;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.mongo.UserMongo;
import com.postgre.sql.model.sql.User;
import com.postgre.sql.repository.UserRepository;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserMongoRepositoryImpl implements UserRepository {

    private final UserRepositoryMongo userRepositoryMongo;

    public UserMongoRepositoryImpl(UserRepositoryMongo userRepositoryMongo) {
        this.userRepositoryMongo = userRepositoryMongo;
    }


    @Override
    public List<UserRepositoryDto> getAllUsers() {
        return userRepositoryMongo.findAll().stream()
                .map(userMongo -> DataMapper.convertUserMongoToUserRepositoryDto(userMongo))
                .collect(Collectors.toList());
    }

    @Override
    public UserRepositoryDto findUserById(String idUser) {
        return DataMapper.convertUserMongoToUserRepositoryDto(userRepositoryMongo.findById(String.valueOf(idUser)).get());
    }

    @Override
    public UserRepositoryDto createUser(UserRepositoryDto user) {
        return DataMapper.convertUserMongoToUserRepositoryDto(userRepositoryMongo.save(
                new UserMongo(user)
        ));
    }

    @Override
    public Boolean updateUser(String idUser, UserRepositoryDto user) {
        Optional<UserMongo> userMongoOptional = userRepositoryMongo.findById(String.valueOf(idUser));

        if (userMongoOptional.isPresent()){
            UserMongo userMongoFound = userMongoOptional.get();

            userMongoFound.updateUser(user);

            userRepositoryMongo.save(userMongoFound);

            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(String idUser) {
        Optional<UserMongo> userMongoOptional = userRepositoryMongo.findById(idUser);

        if (userMongoOptional.isPresent()){
            UserMongo userMongoFound = userMongoOptional.get();

            userRepositoryMongo.delete(userMongoFound);

            return true;
        }
        return false;
    }

    @Override
    public UserRepositoryDto findByEmail(String email) {
        Optional<UserMongo> userFound = userRepositoryMongo.findByEmail(email);
        if (userFound.isPresent()){
            System.out.println("userMongoFound: " + userFound.get());
            return DataMapper.convertUserMongoToUserRepositoryDto(userFound.get());
        }else{
            return null;
        }
    }
}
