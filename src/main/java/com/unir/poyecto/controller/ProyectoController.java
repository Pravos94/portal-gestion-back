package com.unir.poyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
		return proyectos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(proyectos);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable Long id) {

		Optional<Proyecto> proyecto = proyectoRepository.findById(id);

		return proyecto.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
//		public ResponseEntity<Proyecto> crearProyecto(@RequestBody ProyectoDTO proyectoDTO) {

//		Proyecto proyecto = ProyectoMapper.INSTANCE.toEntity(proyectoDTO);
		
//	    if (proyecto.getFoto() != null) {
//            byte[] fotoBytes = Base64.getDecoder().decode(proyecto.getFoto());
//            proyecto.setFoto(fotoBytes);
//        }

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

	@DeleteMapping("/del/{id}")
	public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
		if (proyectoRepository.existsById(id)) {
			proyectoRepository.deleteById(id);

			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
