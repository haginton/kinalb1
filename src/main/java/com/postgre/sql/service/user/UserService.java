package com.postgre.sql.service.user;

import com.postgre.sql.dto.user.UserCreatedDto;
import com.postgre.sql.dto.user.UserRegisterDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;

import java.util.List;

public interface UserService {

    List<UserCreatedDto> getAllUsers();
    UserCreatedDto findUserById(String idUser);
    UserCreatedDto createUser(UserRegisterDto user);
    Boolean updateUser(String idUser, UserRegisterDto user);
    Boolean deleteUser(String idUser);
    UserRepositoryDto findByEmail(String email);
}
