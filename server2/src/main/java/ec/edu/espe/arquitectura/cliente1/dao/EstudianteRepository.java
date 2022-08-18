package ec.edu.espe.arquitectura.cliente1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.cliente1.model.Estudiante;

public interface EstudianteRepository extends MongoRepository<Estudiante,String>{
    
    List<Estudiante> findByNivel(Integer nivel);
    Optional<Estudiante> findByCedula(String cedula);
}
