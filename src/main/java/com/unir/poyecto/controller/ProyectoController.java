package com.unir.poyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.unir.poyecto.model.Proyecto;
import com.unir.poyecto.repository.ProyectoRepository;
import com.unir.poyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@SuppressWarnings("unlikely-arg-type")
	@GetMapping("/all")
	public ResponseEntity<?> listarProyectos(HttpSession session) {
		List<Proyecto> proyectos = null;

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			proyectos = tienePermiso ? proyectoRepository.findAll() : null;

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}

		return (proyectos == null || proyectos.isEmpty()) ? ResponseEntity.noContent().build()
				: ResponseEntity.ok(proyectos);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerProyecto(@PathVariable Long id, HttpSession session) {

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Optional<Proyecto> proyecto = proyectoRepository.findById(id);
				return proyecto.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para obtener proyectos");

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearProyecto(@RequestBody Proyecto proyecto, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {

				Proyecto proyectoGuardado = proyectoRepository.save(proyecto);
				return ResponseEntity.ok(proyectoGuardado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para crear proyectos");
		} else

		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto,
			HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Proyecto proyectoActualizado = proyectoRepository.save(proyecto);
				return ResponseEntity.ok(proyectoActualizado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para editar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> eliminarProyecto(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				if (proyectoRepository.existsById(id)) {
					proyectoRepository.deleteById(id);
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para eliminar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@DeleteMapping("/del2/{id}")
	public ResponseEntity<?> eliminarProyecto2(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				if (proyectoRepository.existsById(id)) {
					proyectoRepository.deleteById(id);
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para eliminar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@DeleteMapping("/del4/{id}")
	public ResponseEntity<?> eliminarProyecto3(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				if (proyectoRepository.existsById(id)) {
					proyectoRepository.deleteById(id);
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para eliminar proyectos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}
}
