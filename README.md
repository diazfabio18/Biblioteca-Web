# Web Library
 Storage system for books, with querys to database through api REST

 ![Library](https://media.wsimag.com/attachments/f80c8122cb20fb640a9fff2294d29e00bafb83d1/store/fill/1090/613/8d2cb3dbc6d2de994509159ac6979c02a7972dda326bbf5e88ab801a553c/Biblioteca.jpg)

### Software and Tools📋

Minimal requeriments

- Java 1.8
- Spring Tools Suite 4
- MySQL Workbench 8.0

## Implement technologies 🛠️

- [Spring Boot 4](https://spring.io/projects/spring-boot) - The framework for auto-configuration to Server and dependencies
- [Maven](https://maven.apache.org/) - Handler of dependencies
- [Hibernate](https://hibernate.org/) - Framework for map ORM
- [REST](https://spring.io/guides/gs/rest-service/) - Services to be consumed by Front-End
- [SQL](https://www.w3schools.com/sql/) for database

## About autor ✒️

- **Fabio Díaz** [Perfil](https://github.com/diazfabio18)

## Current State 🛠️

- Get methods working for entity Autor
- Aggregate of funcionalities for entity Libro
- Correction on method borrar of cap Model

### Example of Entity libro

```
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
```

## Soon 📌

- Putting in working data JSON (by method POST)
- Implement with Front-End Boostratp 4 and Angular 6
- Expansion to more a tipe of DBMS
- Start up production
