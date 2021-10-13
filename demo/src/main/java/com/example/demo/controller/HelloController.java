package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Ingrediente;
import com.example.demo.domain.User;
import com.example.demo.service.IngredientesRepository;
import com.example.demo.service.UserRepository;

@RestController
public class HelloController {
	
	final UserRepository userRepository;
	final IngredientesRepository ingredientesRepository;
	
	public HelloController (UserRepository userRepository, IngredientesRepository ingredientesRepository) {
		this.userRepository = userRepository;
		this.ingredientesRepository = ingredientesRepository;
	}
	
	
	@GetMapping("/hello")
	public List<User> hello() {
		return userRepository.getUsuarios();
	}
	
	@GetMapping("/api/getIngredientes")
	public List<Ingrediente> getIngredientes() {
		return ingredientesRepository.getIngredientes();
	}
}
