package ec.edu.espe.arquitectura.cliente1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.cliente1.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.cliente1.dao.ParaleloRepository;
import ec.edu.espe.arquitectura.cliente1.dto.AsignarEstudianteDTO;
import ec.edu.espe.arquitectura.cliente1.exceptions.EntityNotFoundException;
import ec.edu.espe.arquitectura.cliente1.model.Estudiante;
import ec.edu.espe.arquitectura.cliente1.model.Paralelo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParaleloService {
    
    private final ParaleloRepository paraleloRepository;
    private final EstudianteRepository estudianteRepository;

    public Paralelo asignarEstudiante(AsignarEstudianteDTO dto) {
        Optional<Estudiante> estudianteOpt = this.estudianteRepository.findByCedula(dto.getCedula());
        if (!estudianteOpt.isPresent()) {
            throw new EntityNotFoundException("El estudiante no se encuetra registrado.");
            //log.error("El estudiate con cédula {} ya se encuetra registrado", estudiante.getCedula());
        }
        Estudiante estudiante = estudianteOpt.get();
        List<Paralelo> listaParalelos = this.paraleloRepository.findByNivel(estudiante.getNivel());
        Paralelo paralelo = listaParalelos.get(0);


        paralelo.getEstudiantes().add(estudiante);

        return this.paraleloRepository.save(paralelo);
    }

    public List<Estudiante> obtenerEstudiantesPorParaleloNivel(String letra, Integer nivel) {
        List<Estudiante> estudiantes = new ArrayList<>();
        
        Optional<Paralelo> paraleloOtp = this.paraleloRepository.findByLetraAndNivel(letra, nivel);
        if (!paraleloOtp.isPresent()) {
            throw new EntityNotFoundException("No se encontraron registros.");
            //log.error("El estudiate con cédula {} ya se encuetra registrado", estudiante.getCedula());
        }
        Paralelo paralelo = paraleloOtp.get();
        estudiantes = paralelo.getEstudiantes();
        return estudiantes;
    }

    public List<Paralelo> obtenerParalelosPorNivel(Integer nivel) {
        List<Paralelo> paralelos = this.paraleloRepository.findByNivel(nivel);
        return paralelos;
    }

}
