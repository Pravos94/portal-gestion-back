package com.unir.poyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.poyecto.model.Empleado;
import com.unir.poyecto.repository.EmpleadoRepository;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin()
@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Empleado>> listarEmpleados() {

		List<Empleado> empleados = empleadoRepository.findAll();

		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
}
