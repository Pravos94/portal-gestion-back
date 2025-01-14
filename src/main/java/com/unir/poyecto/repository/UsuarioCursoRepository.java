package com.unir.poyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.poyecto.model.UsuarioCurso;

@Repository
public interface UsuarioCursoRepository extends JpaRepository<UsuarioCurso, Long> {
	List<UsuarioCurso> findByUsuarioId(Long usuarioId);
}
