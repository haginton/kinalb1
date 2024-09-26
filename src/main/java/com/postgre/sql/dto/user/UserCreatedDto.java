package com.postgre.sql.dto.user;

import com.postgre.sql.model.mongo.UserMongo;
import com.postgre.sql.model.sql.User;
import com.postgre.sql.repository.UserRepository;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserCreatedDto implements Serializable {

    private static final long serialVersionUID= 1L;

    private String idUser;
    private String username;
    private String email;
    private LocalDateTime dateCreation;

    public UserCreatedDto(User user){
        this.idUser = String.valueOf(user.getIdUser());
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.dateCreation = user.getDateCreation();
    }

    public UserCreatedDto(UserMongo user){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.dateCreation = user.getDateCreation();
    }

    public UserCreatedDto(UserRepositoryDto user){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.dateCreation = user.getDateCreation();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "UserCreatedDto{" +
                "idUser='" + idUser + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}
