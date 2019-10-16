package com.biblioteca.ApiBiblioteca.DAO;

import java.util.List;

import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;


public interface AutorDAO {
	
	//CRUD: Create, Read, Update, Delete
	
	//CREATE
	//guardar en la base de datos
	public void Guardar(Autor autor);
	public void Guardar(Libro libro);
	//READ
	//Listo todos los autores
	public List<Autor> findAll();
	
	//Listo todos los libros
		public List<Libro> findAllBookUser(String autor);
	
	//buscar usuario por id
	public Autor findById(int id);
	
	//buscar usuario por nombre
		public Autor findByName(String name);
		
		public Libro findByNameLibro(String name);
	
	//UPDATE
	public void Actualizar(Autor autor);
	
	//DELETE
	//borrar usuario
	public void borrar(int id);
	
	public void borrarLibro(String titulo, int id);
}
