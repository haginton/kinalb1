package com.postgre.sql.model.sql;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;
    private String rol;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Rol() {
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", rol='" + rol + '\'' +
                '}';
    }
}
