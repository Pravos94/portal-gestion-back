package com.unir.poyecto.service;

import com.unir.poyecto.model.Usuario;

public interface IUsuarioService {

	public Usuario consultarUsuarioBD(String username);
	
	public boolean comprobarPermisos(Object roles, String permisoRequerido);
	
}
