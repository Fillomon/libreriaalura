package com.aluracursos.libreriaAlura.repository;
import com.aluracursos.libreriaAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreContains(String nombreAutor);

    List<Autor> findByFechaDeNacimientoLessThanEqualAndFechaDeMuerteGreaterThanEqual(Integer fechaDeNacimiento, Integer fechaDeMuerte);
}
