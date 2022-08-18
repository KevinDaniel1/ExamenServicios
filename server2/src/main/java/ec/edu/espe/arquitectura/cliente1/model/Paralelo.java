package ec.edu.espe.arquitectura.cliente1.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "paralelo")
@TypeAlias("paralelo")
public class Paralelo {

    @Id
    private String id;

    @Indexed(name = "idxu_paralelo_codigo", unique = true)
    private String codigo;

    private String letra; 

    private String nombre;

    private Integer nivel;

    private List<Estudiante>  estudiantes;

}
