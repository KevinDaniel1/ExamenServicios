package ec.edu.espe.arquitectura.cliente1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "estudiante")
@TypeAlias("estudiante")
public class Estudiante {

    @Id
    private String id;

    private String nombres;

    private String apellidos;

    @Indexed(name = "idxu_estudiante_cedula", unique = true)
    private String cedula;

    private Integer nivel;

}
