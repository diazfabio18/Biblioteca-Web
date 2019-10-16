package com.biblioteca.ApiBiblioteca.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.ApiBiblioteca.DAO.AutorDAO;
import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorDAO userDAO;
	
	@Override
	public List<Autor> findAll() {
		List<Autor> listUsers= userDAO.findAll();
		return listUsers;
	}
	
	@Override
	public List<Libro> findAllBookUser(String autor) {
		List<Libro> listUsers= userDAO.findAllBookUser(autor);
		return listUsers;
	}

	@Override
	public Autor findById(int id) {
		Autor autor = userDAO.findById(id);
		return autor;
	}
	
	@Override
	public Autor findByName(String name) {
		Autor autor = userDAO.findByName(name);
		return autor;
	}
	
	@Override
	public Libro findByNameLibro(String name) {
		Libro libro = userDAO.findByNameLibro(name);
		return libro;
	}

	@Override
	public void save(Autor autor) {
		// TODO Auto-generated method stub
		userDAO.Guardar(autor);
	}
	
	public void save(Libro libro) {
		// TODO Auto-generated method stub
		userDAO.Guardar(libro); 
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userDAO.borrar(id);
	}
	
	@Override
	public void deleteLibroById(String titulo, int id) {
		// TODO Auto-generated method stub
		userDAO.borrarLibro(titulo,id);
	}

}
