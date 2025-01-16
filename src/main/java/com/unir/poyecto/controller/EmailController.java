package com.unir.poyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.service.IEmailService;
import com.unir.poyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin()
@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IEmailService emailService;

	@PostMapping(value = "/enviar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> enviarEmail(@RequestBody Map<String, String> formValues, HttpSession session) {

		if (session != null && session.getAttribute("user") != null) {
			Object roles = session.getAttribute("role");

			boolean tienePermiso = false;
			tienePermiso = usuarioService.comprobarPermisos(roles, "OTROS_ROLES");

			if (tienePermiso) {

				emailService.enviarEmail(formValues.get("para"), formValues.get("asunto"), formValues.get("text"));
				return (ResponseEntity<?>) ResponseEntity.ok();
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No tiene permisos para enviar correo");
			}
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
	}
}