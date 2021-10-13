package com.example.demo.security.service;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.security.domain.Rol;

@Mapper
public interface RolRepository {
	Rol getRolByNombre(String rolNombre);
}
