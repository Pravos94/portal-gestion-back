package com.unir.poyecto.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3856883964075550894L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "empleado_id", nullable = false)
	private String empleadoId;

	@Column(name = "username", nullable = false)
	private String username;

//	@Column(name = "email", nullable = false)
//	private String email;

	@Column(name = "contrasena", nullable = false)
	private String contrasena;

//	private String telefono;
//	private String pais;
//	private String ciudad;
//	private String departamento;
//
//	@Column(name = "fecha_incorporacion")
//	private Date fechaIncorporacion;
//	
//	private byte[] foto;

//	@Column(name = "rol_id")
//	private Long rolId;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles", 
			joinColumns = @JoinColumn(name = "usuario_id"), 
			inverseJoinColumns = @JoinColumn(name = "rol_id"))
	
	private Set<Role> roles;

}
