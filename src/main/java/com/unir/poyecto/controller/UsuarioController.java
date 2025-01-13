package com.unir.poyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.dto.UsuarioDTO;
import com.unir.poyecto.model.Role;
import com.unir.poyecto.model.Usuario;
import com.unir.poyecto.repository.UsuarioRepository;
import com.unir.poyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UsuarioDTO userCredentials, HttpServletRequest request) {

		Usuario user = usuarioService.consultarUsuarioBD(userCredentials.getUsername());

		if (user != null && user.getUsername().equals(userCredentials.getUsername())
				&& user.getContrasena().equals(userCredentials.getContrasena())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userCredentials.getUsername());
			session.setAttribute("role", user.getRoles());
			return ResponseEntity.ok("Login exitoso");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
		}
	}

//	@GetMapping("/api/protected")
//	public String protectedEndpoint(HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			return "Datos protegidos";
//		} else {
//			return "No autorizado";
//		}
//	}

	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return ResponseEntity.ok("Logout exitoso");
	}

//	@GetMapping()
//	public ResponseEntity<List<Usuario>> listarUsuarios() {
//
//		List<Usuario> usuarios = usuarioRepository.findAll().stream().peek(user -> user.setContrasena("*"))
//				.collect(Collectors.toList());
//
//		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
//	}

//	@GetMapping()
//	public ResponseEntity<List<Usuario>> listarUsuarios() {
//
//		List<Usuario> usuarios = usuarioRepository.findAll().stream().peek(user -> user.setContrasena("*"))
//				.collect(Collectors.toList());
//
//		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable Long id, HttpSession session) {

		if (session != null && session.getAttribute("user") != null) {
			Role role = (Role) session.getAttribute("role");

			switch (role.getId().intValue()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				Optional<Usuario> usuario = usuarioRepository.findById(id);
				return usuario.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

			default:
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para obtener usuario");
			}

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario, HttpSession session) {
		if (session != null && session.getAttribute("user") != null) {
			Role role = (Role) session.getAttribute("role");

			switch (role.getId().intValue()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				Usuario usuarioActualizado = usuarioRepository.save(usuario);
				return ResponseEntity.ok(usuarioActualizado);
			default:
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para editar usuarios");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
		}
	}
}
