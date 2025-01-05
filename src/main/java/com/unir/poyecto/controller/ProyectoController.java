package com.unir.poyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.model.Proyecto;
import com.unir.poyecto.repository.ProyectoRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Proyecto>> listarProyectos() {

		List<Proyecto> proyectos = proyectoRepository.findAll();

		return proyectos.isEmpty() ? new ResponseEntity<>(proyectos, HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(proyectos, HttpStatus.OK);

	}
}
