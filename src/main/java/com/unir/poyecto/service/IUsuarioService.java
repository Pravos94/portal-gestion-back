package com.unir.poyecto.service;

import java.util.List;

import com.unir.poyecto.model.Curso;
import com.unir.poyecto.model.Proyecto;
import com.unir.poyecto.model.Usuario;

public interface IUsuarioService {

	public Usuario consultarUsuarioBD(String username);

	public boolean comprobarPermisos(Object roles, String permisoRequerido);

	List<Curso> obtenerCursosByUser(Long userId);

	List<Proyecto> obtenerProyectosByUser(Long userId);

}
