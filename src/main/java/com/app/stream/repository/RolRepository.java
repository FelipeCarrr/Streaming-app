package com.app.stream.repository;

import com.app.stream.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByRolName(String user);
}
