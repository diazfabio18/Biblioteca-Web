package com.biblioteca.ApiBiblioteca.DAO;

import java.util.List;

import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;


public interface AutorDAO {
	
	//CRUD: Create, Read, Update, Delete
	
	//CREATE
	//guardar en la base de datos
	public void Guardar(Autor autor,Libro libro);
	
	//READ
	//Listo todos los usuarios
	public List<Autor> findAll();
	
	//buscar usuario por id
	public Autor findById(int id);
	
	//UPDATE
	public void Actualizar(Autor autor);
	
	//DELETE
	//borrar usuario
	public void borrar(int id);
}
