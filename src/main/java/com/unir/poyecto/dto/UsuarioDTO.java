package com.unir.poyecto.dto;

import java.util.Set;

import com.unir.poyecto.model.Role;

public class UsuarioDTO {
	private Long id;
	private String empleadoId;
	private String username;
	private String contrasena;
	private Long rolId;
	private Set<Role> roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpleadoId() {
		return empleadoId;
	}
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Long getRolId() {
		return rolId;
	}
	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
