package com.unir.poyecto.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.model.Empleado;
import com.unir.poyecto.repository.EmpleadoRepository;
import com.unir.poyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<?> listarEmpleados(HttpSession session) {

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				List<Empleado> empleados = empleadoRepository.findAll();
				return new ResponseEntity<>(empleados, HttpStatus.OK);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para obtener empleados");

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerEmpleado(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Optional<Empleado> empleado = empleadoRepository.findById(id);
				return empleado.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para obtener empleados");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crearEmpleado(@RequestBody Empleado empleado, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Empleado empleadoGuardado = empleadoRepository.save(empleado);
				return ResponseEntity.ok(empleadoGuardado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para crear empleados");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado,
			HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Empleado empleadoActualizado = empleadoRepository.save(empleado);
				return ResponseEntity.ok(empleadoActualizado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para editar empleados");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				if (empleadoRepository.existsById(id)) {
					empleadoRepository.deleteById(id);
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para eliminar empleados");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PostMapping("/asignar-a-proyecto/{idProyecto}")
	public ResponseEntity<?> asignarEmpleadoToProyecto(@PathVariable Long idProyecto, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				usuarioService.asignarEmpleadoToProyecto(userId, idProyecto);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para asignar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PostMapping("/solicitar-proyecto/{idProyecto}")
	public ResponseEntity<?> solicitarProyecto(@PathVariable Long idProyecto, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				usuarioService.solicitarProyecto(userId, idProyecto);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para asignar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@GetMapping("/proyecto-asignado/{idProyecto}")
	public ResponseEntity<?> isSolicitadoProyecto(@PathVariable Long idProyecto, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Date fecha = usuarioService.isSolicitadoProyecto(userId, idProyecto);
				return ResponseEntity.ok(fecha);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para asignar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

}
