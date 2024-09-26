package com.postgre.sql.model.mongo;

import com.postgre.sql.dto.user.UserRegisterDto;
import com.postgre.sql.dto.user.UserRepositoryDto;
import com.postgre.sql.model.RoleEnum;
import com.postgre.sql.model.sql.User;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Document(collection = "user_collection")
public class UserMongo {

    private static final long serialVersionUID = 1L;

    @Id
    private String idUser;
    private String username;
    private String password;
    private String email;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private List<RoleEnum> roles;

    public UserMongo() {
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
    }

    public UserMongo(String username, String password, String email) {
        this.username = username;
        System.out.println("Password userMongo 1 "+ password);
        this.password = new BCryptPasswordEncoder().encode(password);
        System.out.println("Constructor 1 " + this.password);
        this.email = email;
        this.dateCreation = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
    }

    public UserMongo(UserRepositoryDto userRepositoryDto) {
        this.username = userRepositoryDto.getUsername();
        System.out.println("Password userMongo 1 "+ userRepositoryDto.getPassword());
        this.password = new BCryptPasswordEncoder().encode(userRepositoryDto.getPassword());
        System.out.println("Constructor 2 " + this.password);
        this.email = userRepositoryDto.getEmail();
        this.dateCreation = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
        this.roles = new ArrayList<>(Collections.singleton(RoleEnum.USER));
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public String getIdUser() {
        return idUser;
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

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void updateUser(UserRepositoryDto user){
        setUsername(user.getUsername());
        setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        setEmail(user.getEmail());
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMongo userMongo = (UserMongo) o;
        return Objects.equals(idUser, userMongo.idUser) && Objects.equals(username, userMongo.username) && Objects.equals(password, userMongo.password) && Objects.equals(email, userMongo.email) && Objects.equals(dateCreation, userMongo.dateCreation) && Objects.equals(dateUpdate, userMongo.dateUpdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(idUser);
        result = 31 * result + Objects.hashCode(username);
        result = 31 * result + Objects.hashCode(password);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + Objects.hashCode(dateCreation);
        result = 31 * result + Objects.hashCode(dateUpdate);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
