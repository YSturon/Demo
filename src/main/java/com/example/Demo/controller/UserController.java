package com.example.Demo.controller;

import com.example.Demo.repository.User;
import com.example.Demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@GetMapping
	public List<User> findAll(){
		return userService.helloWorld();
	}

	@PostMapping
	public User create(@RequestBody User user){
		return userService.create(user);
	}
}
