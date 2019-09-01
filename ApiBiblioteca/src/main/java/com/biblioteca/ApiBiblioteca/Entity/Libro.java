package com.biblioteca.ApiBiblioteca.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class Libro {

	@Id
	@GeneratedValue
	@Column(name = "Id_libro")
	private int id_libro;
	
	@Column(name = "Titulo")
	private String titulo;
	
	@ManyToOne
	@JoinColumn(name = "Id_autor")
	private Autor autor;

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
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

	public Libro(int id_libro, String titulo, Autor autor) {
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.autor = autor;
	}
	
	public Libro() {
		
	}

}
