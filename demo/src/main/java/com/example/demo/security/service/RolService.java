package com.example.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.domain.Rol;

@Service
@Transactional
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	
	public Rol getRolByNombre(String rolNombre) {
		return rolRepository.getRolByNombre(rolNombre);
	}
}
