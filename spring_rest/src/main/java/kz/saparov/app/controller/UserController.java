package kz.saparov.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.app.entity.UserEntity;
import kz.saparov.app.model.User;
import kz.saparov.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// get all users
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	// create user rest api
	@PostMapping("/")
	public User saveUser(@RequestBody UserEntity user) {
		return userService.saveUser(user);
	}
	
	// update user rest api
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		User updatedUser = userService.updateUser(id, user);
		return ResponseEntity.ok(updatedUser);
	}
	
	// delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
		Map<String, Boolean> response = userService.deleteUser(id);
		return ResponseEntity.ok(response);
	}
}




