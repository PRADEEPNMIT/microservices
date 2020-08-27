package com.accenture.webservices.controller.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	//retrieve users'
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	
	//retrieve user(id)
	@GetMapping(path="/user/{id}")
	public User getOneUser(@PathVariable Integer id) {
		 User user = userDaoService.findOne(id);
		 if(user==null)
			 throw new UserNotFoundException("{/id}-"+id+ " not found");
		 return user;
	}
	
	//saveUser
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user) { 
		
		User savedUser = userDaoService.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
		.toUri();
		ResponseEntity<Object> build = ResponseEntity.created(uri).build();
		return build;
	}
	
	//delete user(id)
		@DeleteMapping(path="/user/{id}")
		public void deleteOneUser(@PathVariable Integer id) {
			 User user = userDaoService.DeleteOne(id);
			 if(user==null)
				 throw new UserNotFoundException("{/id}-"+id+ " not found");
		}
}
