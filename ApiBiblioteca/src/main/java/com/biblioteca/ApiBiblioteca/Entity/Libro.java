package com.biblioteca.ApiBiblioteca.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private int id_libro;
	
	@Column(name = "titulo")
	@JsonProperty("libroE")
	private String titulo;
	
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
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
