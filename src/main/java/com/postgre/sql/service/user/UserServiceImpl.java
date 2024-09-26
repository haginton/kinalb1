package com.postgre.sql.service.user;

import com.postgre.sql.dto.user.UserCreatedDto;
import com.postgre.sql.dto.user.UserRegisterDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;
import com.postgre.sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    //userRepositoryImpl
    //userMongoRepositoryImpl
    public UserServiceImpl(@Qualifier("userMongoRepositoryImpl") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserCreatedDto> getAllUsers() {
        List<UserCreatedDto> userCreatedDtos = new ArrayList<>();
        for (UserRepositoryDto user : userRepository.getAllUsers()){
            userCreatedDtos.add(new UserCreatedDto(user));
        }
        return userCreatedDtos;
    }

    @Override
    public UserCreatedDto findUserById(String idUser) {
        return new UserCreatedDto(userRepository.findUserById(idUser));
    }

    @Override
    public UserCreatedDto createUser(UserRegisterDto user) {
        return new UserCreatedDto(userRepository.createUser(new UserRepositoryDto(user)));
    }

    @Override
    public Boolean updateUser(String idUser, UserRegisterDto user) {
        return userRepository.updateUser(idUser, new UserRepositoryDto(user));
    }

    @Override
    public Boolean deleteUser(String idUser) {
        return userRepository.deleteUser(idUser);
    }

    @Override
    public UserRepositoryDto findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
