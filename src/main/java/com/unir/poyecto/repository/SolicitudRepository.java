package com.unir.poyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.poyecto.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

	Optional<Solicitud> findByUsuarioIdAndProyectoId(Long usuarioId, Long proyectoId);
}
