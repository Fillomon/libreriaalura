package com.aluracursos.libreriaAlura.repository;
import com.aluracursos.libreriaAlura.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdiomasContains(String idiomas);

    List<Libro> findTop10ByOrderByNumeroDeDescargasDesc();

    List<Libro> findByAutorNombreContainingIgnoreCase(String nombreAutor);

    @Query("SELECT l.numeroDeDescargas FROM Libro l")
    List<Double> findAllDescargas();
}