package com.unir.poyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.poyecto.model.Asignacion;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {
}
