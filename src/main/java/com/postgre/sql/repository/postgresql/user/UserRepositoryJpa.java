package com.postgre.sql.repository.postgresql.user;

import com.postgre.sql.model.sql.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
