package com.unir.poyecto.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Lob
	@Column(name = "foto")
	private byte[] foto;

	private String descripcion;

	@Column(name = "nivel_experiencia")
	private String nivelExperiencia;

	@Lob
	@Column(name = "temario")
	private String temario;

	private String profesor;

	@Lob
	@Column(name = "metodologia")
	private String metodologia;

	private String dificultad;

	@Column(name = "ultima_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;

	private boolean destacado;

}
