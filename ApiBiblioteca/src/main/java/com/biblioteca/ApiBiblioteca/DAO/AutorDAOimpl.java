package com.biblioteca.ApiBiblioteca.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;

@Repository
public class AutorDAOimpl implements AutorDAO {

	@Autowired
	private EntityManager manager;
	
	@Override
	public void Guardar(Autor autor) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);
		
		actual.saveOrUpdate(autor);
	}
	@Override
	public void Guardar(Libro libro) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);
		
		actual.save(libro);
	}

	@Override
	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);

		Query<Autor> consulta = actual.createQuery("from Autor", Autor.class);
		
		List<Autor> autores = consulta.getResultList();
		
		return autores;

	}
	
	@Override
	public List<Libro> findAllBookUser(String nombre) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);

		Query<Libro> consulta = actual.createQuery("from Libro where id_autor = :name");
		
		Autor autor = (Autor) findByName(nombre);
		
		consulta.setParameter("name", autor.getId_autor());
		
		
		List<Libro> libros = consulta.getResultList();
		
		return libros;

	}

	@Override
	public Autor findById(int id) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);

		Autor autor = actual.get(Autor.class, id);
		
		return autor;
	}
	
	@Override
	public Autor findByName(String name) 
	{	
		Session actual = manager.unwrap(Session.class);
		
		Query query= actual.createQuery("from Autor where nombre= :name");
		query.setParameter("name", name);
		Autor autor = (Autor) query.uniqueResult();
		
		return autor;
	}
	
	@Override
	public Libro findByNameLibro(String name) 
	{	
		Session actual = manager.unwrap(Session.class);
		
		Query query= actual.createQuery("from Libro where titulo= :name");
		query.setParameter("name", name);
		Libro lib = (Libro) query.uniqueResult();
		
		return lib;
	}

	@Override
	public void Actualizar(Autor autor) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);
		
		actual.update(autor);
	}
	
	public void Actualizar(Libro libro) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class);
		
		actual.update(libro);
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class); //bien
		
		/*@SuppressWarnings("unchecked")
		Query<Autor> consulta = actual.createQuery("delete Autor where id_autor = :id");*/
		
		//consulta.setParameter("id", id);
		//consulta.executeUpdate();
		actual.beginTransaction();
		Autor autor = (Autor) actual.get(Autor.class, id);
		actual.delete(autor); 
		actual.getTransaction().commit();
	}
	
	@Override
	public void borrarLibro(String titulo, int id) {
		// TODO Auto-generated method stub
		Session actual = manager.unwrap(Session.class); //bien
		
		actual.beginTransaction();
		
		String comando = "delete from Libro where id_autor = :name AND titulo = :titulo";
		Query query= actual.createQuery(comando);
		
		//System.out.println("titulo :" + titulo + " y id: " + id);
		
		query.setParameter("name", id);
		query.setParameter("titulo", titulo);
		
		query.executeUpdate();
		
		actual.getTransaction().commit();
	}
	
	public AutorDAOimpl()
	{
		
	}

}
