package com.aluracursos.libreriaAlura;

import com.aluracursos.libreriaAlura.principal.Principal;
import com.aluracursos.libreriaAlura.repository.AutorRepository;
import com.aluracursos.libreriaAlura.repository.LibroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class LibreriaAluraApplication implements CommandLineRunner{

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, autorRepository);
		principal.mostrarMenu();
	}

}
