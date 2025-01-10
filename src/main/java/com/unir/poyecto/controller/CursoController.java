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

import com.unir.poyecto.dto.CursoDTO;
import com.unir.poyecto.mapper.CursoMapper;
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
	public ResponseEntity<List<Curso>> listarCursos() {

		List<Curso> cursos = cursoRepository.findAll();

		return cursos.isEmpty() ? new ResponseEntity<>(cursos, HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(cursos, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id) {

		Optional<Curso> proyecto = cursoRepository.findById(id);

		return proyecto.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/new")
	public ResponseEntity<Curso> crearCurso(@RequestBody CursoDTO cursoDTO) {

		Curso curso = CursoMapper.INSTANCE.toEntity(cursoDTO);

		Curso cursoGuardado = cursoRepository.save(curso);

		return ResponseEntity.ok(cursoGuardado);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Curso> editarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {

		cursoDTO.setId(id);
		Curso curso = CursoMapper.INSTANCE.toEntity(cursoDTO);

		Curso cursoActualizado = cursoRepository.save(curso);

		return ResponseEntity.ok(cursoActualizado);

	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
		if (cursoRepository.existsById(id)) {
			cursoRepository.deleteById(id);

			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
