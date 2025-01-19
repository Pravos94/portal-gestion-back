package com.unir.poyecto.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api/busqueda")
public class BusquedaController {
//
//	// SearchResult.java
//	@Data
//	@AllArgsConstructor
//	public class SearchResult {
//	    private Long id;
//	    private String nombre;
//	    private String tipo;
//	    private String descripcion;
//	}
//
//	// SearchService.java
//	@Service
//	public class SearchService {
//	    
//	    @Autowired
//	    private CursoRepository cursoRepository;
//	    @Autowired
//	    private ProyectoRepository proyectoRepository;
//	    @Autowired
//	    private EmpleadoRepository empleadoRepository;
//
//	    public List<SearchResult> searchAll(String term) {
//	        List<SearchResult> results = new ArrayList<>();
//	        
//	        // Búsqueda en cursos
//	        cursoRepository.findByNombreContainingIgnoreCase(term)
//	            .forEach(curso -> results.add(new SearchResult(
//	                curso.getId(),
//	                curso.getNombre(),
//	                "curso",
//	                curso.getDescripcion()
//	            )));
//	        
//	        // Búsqueda en proyectos
//	        proyectoRepository.findByNombreContainingIgnoreCase(term)
//	            .forEach(proyecto -> results.add(new SearchResult(
//	                proyecto.getId(),
//	                proyecto.getNombre(),
//	                "proyecto",
//	                proyecto.getDescripcion()
//	            )));
//	        
//	        // Búsqueda en empleados
//	        empleadoRepository.findByNombreContainingOrApellidosContainingIgnoreCase(term, term)
//	            .forEach(empleado -> results.add(new SearchResult(
//	                empleado.getId(),
//	                empleado.getNombre() + " " + empleado.getApellidos(),
//	                "empleado",
//	                empleado.getDepartamento()
//	            )));
//	            
//	        return results;
//	    }
//	}
//
//	// Repository interfaces
//	@Repository
//	public interface CursoRepository extends JpaRepository<Curso, Long> {
//	    List<Curso> findByNombreContainingIgnoreCase(String term);
//	}
//
//	@Repository
//	public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
//	    List<Proyecto> findByNombreContainingIgnoreCase(String term);
//	}
//
//	@Repository
//	public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
//	    List<Empleado> findByNombreContainingOrApellidosContainingIgnoreCase(String nombre, String apellidos);
//	}
//
//	// SearchController.java
//	@RestController
//	@RequestMapping("/api")
//	@CrossOrigin(origins = "http://localhost:5173")
//	public class SearchController {
//	    
//	    @Autowired
//	    private SearchService searchService;
//
//	    @GetMapping("/search")
//	    public ResponseEntity<List<SearchResult>> search(@RequestParam String term) {
//	        if (term == null || term.trim().length() < 2) {
//	            return ResponseEntity.badRequest().build();
//	        }
//	        
//	        List<SearchResult> results = searchService.searchAll(term.trim());
//	        return ResponseEntity.ok(results);
//	    }
//	}

}
