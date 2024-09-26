package com.postgre.sql.repository.postgresql.user;

import com.postgre.sql.dto.mapper.DataMapper;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;

import com.postgre.sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Override
    public List<UserRepositoryDto> getAllUsers() {
        return userRepositoryJpa.findAll().stream()
                .map(user -> DataMapper.convertUserToUserRepositoryDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserRepositoryDto findUserById(String idUser) {
        return DataMapper.convertUserToUserRepositoryDto(userRepositoryJpa.findById(Long.parseLong(idUser)).get());
    }

    @Override
    public UserRepositoryDto createUser(User user) {
        return DataMapper.convertUserToUserRepositoryDto(userRepositoryJpa.save(user));
    }

    @Override
    public Boolean updateUser(String idUser, User user) {
        User userFound = userRepositoryJpa.findById(Long.parseLong(idUser)).get();
        if (userFound != null){
            userFound.updateUser(user);
            userRepositoryJpa.save(userFound);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(String idUser) {
        User userFound = userRepositoryJpa.findById(Long.parseLong(idUser)).get();
        if (userFound != null){
            userRepositoryJpa.delete(userFound);
            return true;
        }
        return false;
    }

    @Override
    public UserRepositoryDto findByEmail(String email) {
        Optional<User> userFound = userRepositoryJpa.findByEmail(email);
        if (userFound.isPresent()){
            return DataMapper.convertUserToUserRepositoryDto(userFound.get());
        }else{
            return null;
        }
    }
}