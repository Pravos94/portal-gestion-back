package com.unir.poyecto.model;

import java.io.Serializable;
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
@Table(name = "empleados")
public class Empleado  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1090670111992923494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	private String telefono;
	private String pais;
	private String ciudad;
	private String departamento;

	@Column(name = "fecha_incorporacion")
	@Temporal(TemporalType.DATE)
	private Date fechaIncorporacion;

//	@Column(name = "tipo_foto")
//	private String tipoFoto;

	@Lob
	@Column(name = "foto")
	private byte[] foto;

}
