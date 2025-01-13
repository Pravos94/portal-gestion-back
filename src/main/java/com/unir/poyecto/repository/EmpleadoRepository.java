package com.unir.poyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.poyecto.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
