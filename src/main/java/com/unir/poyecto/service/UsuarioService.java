package com.unir.poyecto.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.poyecto.model.Asignacion;
import com.unir.poyecto.model.Curso;
import com.unir.poyecto.model.Empleado;
import com.unir.poyecto.model.Proyecto;
import com.unir.poyecto.model.Solicitud;
import com.unir.poyecto.model.Usuario;
import com.unir.poyecto.model.UsuarioCurso;
import com.unir.poyecto.model.UsuarioProyecto;
import com.unir.poyecto.repository.AsignacionRepository;
import com.unir.poyecto.repository.EmpleadoRepository;
import com.unir.poyecto.repository.ProyectoRepository;
import com.unir.poyecto.repository.SolicitudRepository;
import com.unir.poyecto.repository.UsuarioCursoRepository;
import com.unir.poyecto.repository.UsuarioProyectoRepository;
import com.unir.poyecto.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioCursoRepository usuarioCursoRepository;

	@Autowired
	private UsuarioProyectoRepository usuarioProyectoRepository;

	@Autowired
	private AsignacionRepository asignacionRepository;

	@Autowired
	private SolicitudRepository solicitudRepository;

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private ProyectoRepository proyectoRepository;

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

	@Override
	public List<Curso> obtenerCursosByUser(Long userId) {
		List<UsuarioCurso> actividades = usuarioCursoRepository.findByUsuarioId(userId);
		return actividades.stream().map(UsuarioCurso::getCurso).collect(Collectors.toList());
	}

	@Override
	public List<Proyecto> obtenerProyectosByUser(Long userId) {
		List<UsuarioProyecto> actividades = usuarioProyectoRepository.findByUsuarioId(userId);
		return actividades.stream().map(UsuarioProyecto::getProyecto).collect(Collectors.toList());
	}

	@Override
	public void asignarEmpleadoToProyecto(Long idEmpleado, Long idProyecto) {
		Optional<Empleado> empleado = empleadoRepository.findById(idEmpleado);
		Empleado emp = empleado.get();
		Optional<Proyecto> proyecto = proyectoRepository.findById(idProyecto);
		Proyecto proy = proyecto.get();

		Asignacion asignacion = new Asignacion(null, emp, proy);
		asignacionRepository.save(asignacion);

	}

	@Override
	public void solicitarProyecto(Long idUsuario, Long idProyecto) {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		Usuario user = usuario.get();
		Optional<Proyecto> proyecto = proyectoRepository.findById(idProyecto);
		Proyecto proy = proyecto.get();

		Solicitud solicitud = new Solicitud(null, user, proy, null);
		solicitudRepository.save(solicitud);

	}

	@Override
	public Date isSolicitadoProyecto(Long idUsuario, Long idProyecto) {
//		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
//		Usuario user = usuario.get();
//		Optional<Proyecto> proyecto = proyectoRepository.findById(idProyecto);
//		Proyecto proy = proyecto.get();

		return solicitudRepository.findByUsuarioIdAndProyectoId(idUsuario, idProyecto).map(Solicitud::getFechaSolicitud)
				.orElse(null);
	}

}
