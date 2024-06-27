package com.aluracursos.libreriaAlura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ing. Arnulfo Aranda
 */
@Entity
@Table(name="autores")
public class Autor {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(unique = true)
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeMuerte;

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    //constructor vacio
    public Autor(){

    }

    //constructor con parametros
    public Autor(DatosAutor datosAutor){
        this.nombre=datosAutor.nombre();
        this.fechaDeNacimiento=Integer.valueOf(datosAutor.fechaDeNacimiento());
        this.fechaDeMuerte=Integer.valueOf(datosAutor.fechaDeMuerte());
    }

    //GENERACION GET Y SET

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

   /* */
   public Autor obtenerPrimerAutor(DatosLibros datosLibro){
        DatosAutor datosAutor = datosLibro.autor().get(0);
        return new Autor(datosAutor);
   }


    @Override
    public String toString() {
        String librosStr = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
        return
                "\nAutor: " + nombre + "\n"  +
                "Fecha de naciemiento: " + fechaDeNacimiento + "\n"  +
                "Fecha de Fallecimiento: " + fechaDeMuerte + "\n"  +
                "Libros: [" + librosStr + "]";
    }
   
    
}
