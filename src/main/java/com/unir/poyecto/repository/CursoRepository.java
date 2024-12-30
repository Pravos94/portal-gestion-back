package com.unir.poyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.poyecto.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
