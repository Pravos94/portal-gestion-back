package com.unir.poyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.poyecto.model.UsuarioProyecto;

@Repository
public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyecto, Long> {
	List<UsuarioProyecto> findByUsuarioId(Long usuarioId);
}
