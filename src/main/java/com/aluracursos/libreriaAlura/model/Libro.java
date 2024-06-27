package com.aluracursos.libreriaAlura.model;

import jakarta.persistence.*;
import com.aluracursos.libreriaAlura.model.Autor;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @jakarta.persistence.Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne()
    private Autor autor;

    private String nombreAutor;
    private String idiomas;
    private Double numeroDeDescargas;

    //CONSTUCTOR VACIO/
    public Libro(){

    }
    
    //CONSTRUCTOR CON DATOS//
    public Libro(DatosLibros datosLibros){
        this.titulo=datosLibros.titulo();
        this.nombreAutor=obtenerPrimerAutor(datosLibros).getNombre();
        this.idiomas=obtenerPrimerIdioma(datosLibros);
        this.numeroDeDescargas=datosLibros.numeroDeDescargas();
    }

    //metodos get y set
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    //metodos de consulta
    //
    public Autor obtenerPrimerAutor(DatosLibros datosLibro){
        DatosAutor datosAutor = datosLibro.autor().get(0);
        return new Autor(datosAutor);
    }

    public String obtenerPrimerIdioma(DatosLibros datosLibros){
        // Suponiendo que datosLibros.idiomas() devuelve una lista
        List<String> idiomasList = datosLibros.idiomas();
        // Convertir la lista a una cadena separada por comas
        return String.join(", ", idiomasList);
    }

    @Override
    public String toString(){
        return
                "Titulo = " + titulo + "\'" +
                        ", Autor =" + nombreAutor +
                        ", Idiomas =" + idiomas +
                        " , Numero de descargas= " + numeroDeDescargas
                ;
    }
    
}
