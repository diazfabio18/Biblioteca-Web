package com.biblioteca.ApiBiblioteca.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id_autor")
	private int id_autor;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Nacionalidad")
	private String nacionalidad;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Id_libro", referencedColumnName = "Id_autor")
	private List<Libro> libros = new ArrayList<>();

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Autor(int id_autor, String nombre, String nacionalidad) {
		this.id_autor = id_autor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	public Autor(){
		
	}
}
