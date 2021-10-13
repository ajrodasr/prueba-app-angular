package com.example.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.domain.Usuario;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario getUsuarioById (String idUsuario) {
		return usuarioRepository.getUsuarioById(idUsuario);
	}
	
	public boolean existsUsuarioById(String idUsuario) {
		return usuarioRepository.getUsuarioById(idUsuario) != null;
	}
	
	public Usuario getUsuarioByEmail (String email) {
		return usuarioRepository.getUsuarioByEmail(email);
	}
	
	public boolean existsUsuarioByEmail(String email) {
		return usuarioRepository.getUsuarioByEmail(email) != null;
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.saveUsuario(usuario);
		usuarioRepository.saveRolUsuario(usuario.getId(), usuario.getRoles());
	}
	
}
