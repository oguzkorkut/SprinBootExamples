package com.okorkut.rest.webservices.user;

/**
 * ControllerLinkBuilder.linkTo(methodOn(this.getClass())); -> linkTo(methodOn(this.getClass())); 
 *
 */
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {

		return userDaoService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Integer id)  {

		User user = userDaoService.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("Id-" + id);
		}
		
		return user;
	}
	
//	HATEOAS
	@GetMapping(path = "/hateoas/users/{id}")
	public Resource<User> getUserById(@PathVariable Integer id)  {

		User user = userDaoService.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("Id-" + id);
		}
		
//		HATEOAS
		Resource<User> resource =  new Resource<User>(user);
		
//		ControllerLinkBuilder.linkTo(methodOn(this.getClass()));
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); 
		
		resource.add(linkTo.withRel("all-users"));
		
		/*
		 {
		    "id": 1,
		    "name": "Oğuz",
		    "birthDate": "2019-02-20T21:41:39.140+0000",
		    "_links": {
		        "all-users": {
		            "href": "http://localhost:8080/users"
		        }
		    }
		}
		 */
		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		System.out.println("Saved User Id:" + savedUser.getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		User deletedUser = userDaoService.deleteUserById(id);
		
		if(deletedUser==null) {
			throw new UserNotFoundException("Id-" + id);
		}
	}

}
