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
	
	public AutorDAOimpl()
	{
		
	}

}
