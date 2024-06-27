package com.aluracursos.libreriaAlura.model;

import java.util.List;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<DatosAutor> autor,
    @JsonAlias("languages") List<String> idiomas,
    @JsonAlias("downLoad_count") Double numeroDeDescargas
) {
    
}
