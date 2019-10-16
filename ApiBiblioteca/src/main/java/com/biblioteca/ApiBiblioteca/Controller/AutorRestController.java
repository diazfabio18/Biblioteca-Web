package com.biblioteca.ApiBiblioteca.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.ApiBiblioteca.Entity.Autor;
import com.biblioteca.ApiBiblioteca.Entity.Libro;
import com.biblioteca.ApiBiblioteca.Service.AutorService;




//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class AutorRestController {

		//Inyectamos el servicio para poder hacer uso de el
		@Autowired
		private AutorService userService;
		
		/* ************ LISTA DE USUARIOS ***************** */
		@GetMapping("/users")
		public List<Autor> findAll(){
			//retornará todos los usuarios
			return userService.findAll();
		}
		
		/* ************ LISTA DE LIBROS DE UN AUTOR ***************** */
		@GetMapping("/libro/{userName}")
		public List<Libro> findAllBookUser(@PathVariable("userName") final String autor){
			//retornará todos los usuarios
			return userService.findAllBookUser(autor);
		}
		
		/* ********** BUSCADOR DE AUTOR POR ID**************** */
		@GetMapping("/users/{userId}")
		public Autor getUser(@PathVariable("userId") final int autorId)
		{
			Autor autor = userService.findById(autorId);
			
			if(autor == null) {
				throw new RuntimeException("User id not found -"+ autorId);
			}
			
			//retornará al usuario con id pasado en la url
			return autor;
		}
		
		/* ******* BUSCADOR DE AUTOR POR NOMBRE ************** */
		@GetMapping("/users/search/{userName}")
		public Autor getUser(@PathVariable("userName") final String autor_name)
		{
			Autor autor = userService.findByName(autor_name);
			
			if(autor == null) {
				throw new RuntimeException("User id not found -"+ autor_name);
			}
			
			//retornará al usuario con id pasado en la url
			return autor;
		}
		
		/* ******* BUSCADOR DE LIBRO POR NOMBRE ************** */
		@GetMapping("/libro/search/{LibroName}")
		public Libro getUserLibro(@PathVariable("LibroName") final String libro_name)
		{
			Libro libro = userService.findByNameLibro(libro_name);
			
			if(libro == null) {
				throw new RuntimeException("Libro no encontrado: "+ libro_name);
			}
			
			//retornará al usuario con id pasado en la url
			return libro;
		}
		
		/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/users/  */
		//@PostMapping("/users")
		//public Autor addUser(@RequestBody Autor user) {
		//public Autor addUser(@Valid @RequestBody Autor user, @Valid @RequestBody Libro libro)
		
		//@PostMapping("/users")
		
		//public Autor addUser(@PathParam("autorE") String name,@PathParam("nacionE") String nacion,@PathParam("libroE") String lib)
		//public Autor addUser(@Valid @RequestBody Libro libro)
		
		/* ********************* INSERCIÓN NUEVO AUTOR*********************** */
		@GetMapping("/users/{name}/{nac}")
		public Autor update(@PathVariable("name") final String name, @PathVariable("nac") final String nacion)
		{
			
			Autor user = new Autor(); //Creo un nuevo Autor
			user.setNombre(name); //Seteo su nombre con el argumento extraido de GetMapping
			user.setNacionalidad(nacion); //Seteo su nacionalidad con el argumento extraido de GetMapping
			
			userService.save(user); //Guardo el autor llamando a un servicio del objeto userService
			return user;
			
		}
		
		/* ********************* INSERCIÓN NUEVO LIBRO*********************** */
		@GetMapping("/libro/{titulo}/{id_autor}")
		public Autor updateLibro(@PathVariable("titulo") final String tit, @PathVariable("id_autor") final int id)
		{
			
			Libro lib = new Libro(); //Creo un nuevo Libro
			lib.setTitulo(tit); //Seteo su nombre con el argumento extraido de GetMapping
			Autor autor = getUser(id);
			lib.setAutor(autor); //Seteo su nacionalidad con el argumento extraido de GetMapping
			
			userService.save(lib); //Guardo el autor llamando a un servicio del objeto userService
			return autor;
			
		}
		
		/* *************** ELIMINAR AUTOR*************** */ 
		@GetMapping("users/delete/{userId}")
		public List<Autor> deteteUser(@PathVariable("userId") int autorId) 
		{
			Autor autor = userService.findById(autorId);
			
			if(autor == null) {
				throw new RuntimeException("User id not found -"+autorId);
			}
			
			//problemas
			userService.deleteById(autorId);
			
			//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
			//return "Deleted user id - "+autorId;
			
			return userService.findAll();
		}
		
		/* *************** ELIMINAR LIBRO *************** */ 
		@GetMapping("libro/delete/{autor}/{titulo_libro}")
		public List<Autor> deteteLibro(@PathVariable("autor")String nombre, @PathVariable("titulo_libro") String titulo) 
		{
			Autor autor = userService.findByName(nombre);
			
			if(autor == null) {
				throw new RuntimeException("Autor no encontrado: "+ nombre);
			}
			
			//problemas
			userService.deleteLibroById(titulo, autor.getId_autor());
			
			return userService.findAll();
		}
}
