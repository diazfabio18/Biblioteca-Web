package com.biblioteca.ApiBiblioteca.Service;

import java.util.List;

import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;

public interface AutorService {

	public List<Autor> findAll();
	
	public Autor findById(int id);
	public Autor findByName(String name);
	
	public void save(Autor autor);
	public void save(Libro libro);
	public void deleteById(int id);
}
