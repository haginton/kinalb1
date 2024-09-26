package com.postgre.sql.dto.user;

import com.postgre.sql.model.RoleEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class UserRepositoryDto implements Serializable {

    private final static long serialVersionUID = 1L;

    private String idUser;
    private String username;
    private String password;
    private String email;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;

    private List<RoleEnum> roles;

    public UserRepositoryDto(String idUser, String username, String password, String email, LocalDateTime dateCreation, LocalDateTime dateUpdate, List<RoleEnum> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
        this.roles = roles;
    }

    public UserRepositoryDto(String idUser, String username, String password, String email, LocalDateTime dateCreation, LocalDateTime dateUpdate) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }

    public UserRepositoryDto(UserRegisterDto userRegisterDto) {
        this.username = userRegisterDto.getUsername();
        this.password = userRegisterDto.getPassword();
        this.email = userRegisterDto.getEmail();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRepositoryDto{" +
                "idUser='" + idUser + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                ", roles=" + roles +
                '}';
    }
}
