package com.postgre.sql.security.jwt;

import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.sql.User;

import java.util.Calendar;

public interface OperationJwt {

    String generateToken(UserRepositoryDto user, Calendar calendar);
}
