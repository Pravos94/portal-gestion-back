package com.unir.poyecto.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "contrasena", nullable = false)
	private String contrasena;

	private String telefono;
	private String pais;
	private String ciudad;
	private String departamento;

	@Column(name = "fecha_incorporacion")
	private Date fechaIncorporacion;
	
	private byte[] foto;

	@Column(name = "rol_id")
	private Long rolId;

}
