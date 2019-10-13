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

		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
		http://127.0.0.1:8080/api/users*/
		
		/* ************ LISTA DE USUARIOS ***************** */
		@GetMapping("/users")
		public List<Autor> findAll(){
			//retornará todos los usuarios
			return userService.findAll();
		}
		
		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
		http://127.0.0.1:8080/api/users/1*/
		
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
		
		/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/users/  */
		//@PostMapping("/users")
		//public Autor addUser(@RequestBody Autor user) {
		//public Autor addUser(@Valid @RequestBody Autor user, @Valid @RequestBody Libro libro)
		
		//@PostMapping("/users")
		
		//public Autor addUser(@PathParam("autorE") String name,@PathParam("nacionE") String nacion,@PathParam("libroE") String lib)
		//public Autor addUser(@Valid @RequestBody Libro libro)
		
		/* ********************* Insercion nuevo Autor*********************** */
		@GetMapping("/users/{name}/{nac}")
		public Autor update(@PathVariable("name") final String name, @PathVariable("nac") final String nacion)
		{
			
			Autor user = new Autor(); //Creo un nuevo Autor
			user.setNombre(name); //Seteo su nombre con el argumento extraido de GetMapping
			user.setNacionalidad(nacion); //Seteo su nacionalidad con el argumento extraido de GetMapping
			
			userService.save(user); //Guardo el autor llamando a un servicio del objeto userService
			return user;
			
		}
		
		/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/users/  */
		/*@PutMapping("/users")
		public User updateUser(@RequestBody User user) {
			
			userService.save(user);
			
			//este metodo actualizará al usuario enviado
			
			return user;
		}*/
		
		/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
		http://127.0.0.1:8080/api/users/1  */
		
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
}
