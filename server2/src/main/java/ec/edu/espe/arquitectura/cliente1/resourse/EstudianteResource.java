package ec.edu.espe.arquitectura.cliente1.resourse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.espe.arquitectura.cliente1.model.Estudiante;
import ec.edu.espe.arquitectura.cliente1.service.EstudianteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/Estudiante")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorNivel(@RequestAttribute Integer nivel) {
        return ResponseEntity.ok(this.service.getEstudiantesPorNivel(nivel));
    }

    @PostMapping
    public ResponseEntity<Estudiante> create(@RequestBody Estudiante estudiante) {
      try {
        Estudiante estudianteC = this.service.crearEstudiante(estudiante);
        return ResponseEntity.ok(estudianteC);
      } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().build();
      }
    }
    
}
