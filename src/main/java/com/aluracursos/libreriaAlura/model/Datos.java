package com.aluracursos.libreriaAlura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
    @JsonAlias("results") List<DatosLibros> resultados
    ) {
    
}
