package com.unir.poyecto.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
@Table(name = "proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "tipo_foto")
	private String tipoFoto;

	@Lob
	@Column(name = "foto")
	private byte[] foto;

	private String descripcion;

	@Column(name = "nivel_experiencia")
	private String nivelExperiencia;

	@Lob
	@Column(name = "requisitos_tecnicos")
	private String requisitosTecnicos;

	private String dificultad;

	@Column(name = "ultima_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;

	private boolean destacado;

	@PrePersist
	@PreUpdate
	public void prePersistOrUpdate() {
		this.ultimaActualizacion = new Date();
	}

}
