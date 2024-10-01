package com.postgre.sql.repository.postgresql.rol;

import com.postgre.sql.model.sql.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositoryJpa extends JpaRepository<Rol, Long> {
}
