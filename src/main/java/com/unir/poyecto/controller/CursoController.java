package com.unir.poyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.model.Curso;
import com.unir.poyecto.repository.CursoRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Curso>> listarEmpleados() {

		List<Curso> cursos = cursoRepository.findAll();

		return cursos.isEmpty() ? new ResponseEntity<>(cursos, HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(cursos, HttpStatus.OK);

	}
}
