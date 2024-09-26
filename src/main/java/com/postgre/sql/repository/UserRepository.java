package com.postgre.sql.repository;

import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;

import java.util.List;

public interface UserRepository {

    List<UserRepositoryDto> getAllUsers();
    UserRepositoryDto findUserById(String idUser);
    UserRepositoryDto createUser(UserRepositoryDto user);
    Boolean updateUser(String idUser, UserRepositoryDto user);
    Boolean deleteUser(String idUser);
    UserRepositoryDto findByEmail(String email);
}
