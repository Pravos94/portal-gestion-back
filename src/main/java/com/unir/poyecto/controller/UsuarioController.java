package com.unir.poyecto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.model.Usuario;
import com.unir.poyecto.repository.UsuarioRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public ResponseEntity<List<Usuario>> listarUsuarios() {

		List<Usuario> usuarios = usuarioRepository.findAll().stream().peek(user -> user.setContrasena("*"))
				.collect(Collectors.toList());

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
}
