package com.unir.poyecto.controller;

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

import com.unir.poyecto.model.Curso;
import com.unir.poyecto.repository.CursoRepository;
import com.unir.poyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<?> listarCursos(HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				List<Curso> cursos = cursoRepository.findAll();
				return cursos.isEmpty() ? new ResponseEntity<>(cursos, HttpStatus.NOT_FOUND)
						: new ResponseEntity<>(cursos, HttpStatus.OK);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para listar cursos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerCurso(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Optional<Curso> curso = cursoRepository.findById(id);
				return curso.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para obtener cursos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PostMapping("/new")
	public ResponseEntity<?> crearCurso(@RequestBody Curso curso, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Curso cursoGuardado = cursoRepository.save(curso);
				return ResponseEntity.ok(cursoGuardado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para crear cursos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editarCurso(@PathVariable Long id, @RequestBody Curso curso, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				Curso cursoActualizado = cursoRepository.save(curso);
				return ResponseEntity.ok(cursoActualizado);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para editar cursos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<?> eliminarCurso(@PathVariable Long id, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {
				if (cursoRepository.existsById(id)) {
					cursoRepository.deleteById(id);
					return ResponseEntity.noContent().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para eliminar cursos");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}
}
