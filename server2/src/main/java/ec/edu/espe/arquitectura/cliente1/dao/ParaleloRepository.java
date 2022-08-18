package ec.edu.espe.arquitectura.cliente1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.cliente1.model.Paralelo;

public interface ParaleloRepository extends MongoRepository<Paralelo,String>{
    
    Optional<Paralelo> findByLetraAndNivel(String letra, Integer nivel);
    List<Paralelo> findByNivel(Integer nivel);
}
