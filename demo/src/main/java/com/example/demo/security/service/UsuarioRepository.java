package com.example.demo.security.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.security.domain.Rol;
import com.example.demo.security.domain.Usuario;

@Mapper
public interface UsuarioRepository {
	
	Usuario getUsuarioById(String idUsuario);
	Usuario getUsuarioByEmail(String email);
	void saveUsuario(Usuario usuario);
	void saveRolUsuario(String idUsuario, List<Rol> roles);
}
