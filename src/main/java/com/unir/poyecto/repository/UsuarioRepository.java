package com.unir.poyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.poyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
