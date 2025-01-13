package com.unir.poyecto.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.poyecto.model.Usuario;
import com.unir.poyecto.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// '6', 'administracion' '5', 'asignacion' '2', 'creacion' '3', 'edicion' '4',
	// 'eliminacion' '1', 'visualizacion'
	final Set<Integer> ADMINISTRACION_ROLES = Set.of(6);
	final Set<Integer> ASIGNACION_ROLES = Set.of(5);
	final Set<Integer> OTROS_ROLES = Set.of(2, 3, 4, 1);
	final Set<Integer> READ_ONLY = Set.of(1);

	@Override
	public Usuario consultarUsuarioBD(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public boolean comprobarPermisos(Object roles, String permisoRequerido) {
//		boolean tienePermiso = false;
//
//		if (roles instanceof PersistentSet<?>) {
//			final Set<Integer> auxPermisos;
//
//			switch (permisoRequerido) {
//			case "OTROS_ROLES":
//				auxPermisos = OTROS_ROLES;
//				break;
//			case "ASIGNACION_ROLES":
//				auxPermisos = ASIGNACION_ROLES;
//				break;
//			case "ADMINISTRACION_ROLES":
//				auxPermisos = ADMINISTRACION_ROLES;
//				break;
//			default:
//				auxPermisos = READ_ONLY;
//				break;
//			}
//
//			@SuppressWarnings("unchecked")
//			PersistentSet<Role> roleSet = (PersistentSet<Role>) roles;
//
//			tienePermiso = roleSet.stream().filter(role -> role instanceof Role).map(role -> (Role) role)
//					.anyMatch(role -> auxPermisos.contains(role.getId()));
//		}
//		return tienePermiso;

		return true; // HASTA SOLUCIONARLO
	}
}
