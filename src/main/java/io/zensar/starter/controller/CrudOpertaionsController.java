package io.zensar.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.zensar.starter.model.User;
import io.zensar.starter.userservice.UserService;

@RestController
public class CrudOpertaionsController {

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "HI Jenkins! Webhook testing 3!";
	}

	@GetMapping("/listAllUsers")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> allUsers = this.userService.getAllUsers();
		if(allUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(allUsers, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		}
	}

	@PostMapping("/adduser")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			this.userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		
		try {
			this.userService.updateUser(user.getId(), user.getName(), user.getMobile(), user.getDescription());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

	}
	
	@GetMapping("/userdetails/{id}")
	public ResponseEntity<User> getUserDetails(@PathVariable Long id) {
		
		try {
			User user = this.userService.getUserById(id);
			if(user==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable Long id) {
		
		try {
			this.userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
