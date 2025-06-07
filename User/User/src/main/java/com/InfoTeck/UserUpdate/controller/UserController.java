package com.InfoTeck.UserUpdate.controller;

import java.util.List;
import java.util.Optional;

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

import com.InfoTeck.UserUpdate.User.User;
import com.InfoTeck.UserUpdate.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> user = userService.getAllUsers();
		if(user != null && !user.isEmpty())
		{
			return new ResponseEntity<>(user ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable String id)
	{
		Optional<User> user = userService.getUserById(id);
		if(user != null && !user.isEmpty())
		{
			return new ResponseEntity<>(user.get() ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	@PostMapping
	public ResponseEntity<User> createById(@RequestBody User user)
	{
		User created = userService.createUserById(user);
		if(created != null)
		{
			return new ResponseEntity<>(created ,HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateById(@PathVariable String id, @RequestBody User user)
	{
		Optional<User> newUser = userService.updateUserById(id, user);
		if(newUser != null)
		{
			return new ResponseEntity<>(user ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id)
	{
		boolean deleted = userService.deleteUser(id);
		if(deleted)
		{
			return new ResponseEntity<>(id ,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

