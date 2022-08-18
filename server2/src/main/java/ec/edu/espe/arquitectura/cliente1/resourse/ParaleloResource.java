package ec.edu.espe.arquitectura.cliente1.resourse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.cliente1.dto.AsignarEstudianteDTO;
import ec.edu.espe.arquitectura.cliente1.model.Estudiante;
import ec.edu.espe.arquitectura.cliente1.model.Paralelo;
import ec.edu.espe.arquitectura.cliente1.service.ParaleloService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/Paralelo")
@RequiredArgsConstructor
public class ParaleloResource {
    
    private final ParaleloService service;

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorParaleloyNivel(@RequestAttribute Integer nivel, String paralelo) {
        return ResponseEntity.ok(this.service.obtenerEstudiantesPorParaleloNivel(paralelo, nivel));
    }

    @PutMapping
    public ResponseEntity<Paralelo> create(@RequestBody AsignarEstudianteDTO dto) {
      try {
        Paralelo paralelo = this.service.asignarEstudiante(dto);
        return ResponseEntity.ok(paralelo);
      } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().build();
      }
    }

    @GetMapping(path = "ParalelosNivel")
    public ResponseEntity<List<Paralelo>> obtenerParalelosPorNivel(@RequestAttribute Integer nivel) {
        return ResponseEntity.ok(this.service.obtenerParalelosPorNivel(nivel));
    }

}
