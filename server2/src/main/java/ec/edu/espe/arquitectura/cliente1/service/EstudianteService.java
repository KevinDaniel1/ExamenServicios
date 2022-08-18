package ec.edu.espe.arquitectura.cliente1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.cliente1.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.cliente1.exceptions.EntityNotFoundException;
import ec.edu.espe.arquitectura.cliente1.model.Paralelo;
import ec.edu.espe.arquitectura.cliente1.model.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantesPorNivel(Integer nivel) {
        return this.estudianteRepository.findByNivel(nivel);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCedula(estudiante.getCedula());
        if (estudianteOpt.isPresent()) {
            throw new EntityNotFoundException("El estudiante ya se encuetra registrado.");
            //log.error("El estudiate con cédula {} ya se encuetra registrado", estudiante.getCedula());
        }

        this.estudianteRepository.save(estudiante);
        return estudiante;
    }
}
