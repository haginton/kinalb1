package com.postgre.sql.model.sql;

import com.postgre.sql.dto.user.UserRegisterDto;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    private String username;
    private String password;
    private String email;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        System.out.println("Password user 1 "+ password);
        this.password = new BCryptPasswordEncoder().encode(password);
        System.out.println("Constructor user 1 "+ this.password);
        this.email = email;
        this.dateCreation = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
    }

    public User(UserRegisterDto userRegisterDto) {
        this.username = userRegisterDto.getUsername();
        System.out.println("Password user 2 "+ userRegisterDto.getPassword());
        this.password = new BCryptPasswordEncoder().encode(userRegisterDto.getPassword());
        System.out.println("Constructor user 2 "+ this.password);
        this.email = userRegisterDto.getEmail();
        this.dateCreation = LocalDateTime.now();
        this.dateUpdate = LocalDateTime.now();
    }

    public Long getIdUser() {
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

    public void updateUser(User user){
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        this.dateUpdate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(dateCreation, user.dateCreation) && Objects.equals(dateUpdate, user.dateUpdate);
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
