package com.InfoTeck.UserUpdate.User;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "users")
public class User {

	@Id
	private String id = UUID.randomUUID().toString();
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Email(message = "Invalid email address")
    @NotBlank(message = "Email is mandatory")
	private String email;
	
	@Min(value = 0, message = "Age must be non-negative")
	private String age;
	
	public User()
	{
		
	}
	
	public User(String id, @NotBlank(message = "Name is mandatory") String name,
			@Email(message = "Invalid email address") @NotBlank(message = "Email is mandatory") String email,
			@Min(value = 0, message = "Age must be non-negative") String age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	// Getters & Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
