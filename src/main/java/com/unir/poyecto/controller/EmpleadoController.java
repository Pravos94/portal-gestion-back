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

	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id) {

		Optional<Empleado> empleado = empleadoRepository.findById(id);

		return empleado.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/new")
	public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
//		public ResponseEntity<Empleado> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {

//		Empleado empleado = EmpleadoMapper.INSTANCE.toEntity(empleadoDTO);

		Empleado empleadoGuardado = empleadoRepository.save(empleado);

		return ResponseEntity.ok(empleadoGuardado);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Empleado> editarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {

		//empleadoDTO.setId(id);
		//Empleado empleado = EmpleadoMapper.INSTANCE.toEntity(empleadoDTO);

		Empleado empleadoActualizado = empleadoRepository.save(empleado);

		return ResponseEntity.ok(empleadoActualizado);

	}

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
		if (empleadoRepository.existsById(id)) {
			empleadoRepository.deleteById(id);

			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
