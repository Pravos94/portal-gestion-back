package com.unir.poyecto.controller;

import java.util.List;

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

import com.unir.poyecto.dto.ProyectoDTO;
import com.unir.poyecto.mapper.ProyectoMapper;
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

	@PostMapping("/new")
	public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDTO proyectoDTO) {

		Proyecto proyecto = ProyectoMapper.INSTANCE.toEntity(proyectoDTO);

		Proyecto proyectoGuardado = proyectoRepository.save(proyecto);

		return ResponseEntity.ok(proyectoGuardado);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Proyecto> editarProyecto(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO) {

		proyectoDTO.setId(id);
		Proyecto proyecto = ProyectoMapper.INSTANCE.toEntity(proyectoDTO);

		Proyecto proyectoActualizado = proyectoRepository.save(proyecto);

		return ResponseEntity.ok(proyectoActualizado);

	}
}
