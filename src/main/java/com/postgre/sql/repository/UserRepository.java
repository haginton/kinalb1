package com.postgre.sql.repository;

import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;

import java.util.List;

public interface UserRepository {

    List<UserRepositoryDto> getAllUsers();
    UserRepositoryDto findUserById(String idUser);
    UserRepositoryDto createUser(User user);
    Boolean updateUser(String idUser, User user);
    Boolean deleteUser(String idUser);
    UserRepositoryDto findByEmail(String email);
}
