package com.unir.poyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.poyecto.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
