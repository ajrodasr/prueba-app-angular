package com.example.demo.emailpassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.emailpassword.dto.ChangePasswordDTO;
import com.example.demo.emailpassword.dto.EmailValuesDTO;
import com.example.demo.emailpassword.service.EmailService;
import com.example.demo.security.domain.Usuario;
import com.example.demo.security.service.UsuarioService;

@RequestMapping("email-password")
@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Value("${spring.mail.username}")
	private String mailFrom;
	
	@Value("${mail.subject}")
	private String mailSubject;
	
	@PostMapping("/send-email")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
		Usuario usuario = usuarioService.getUsuarioByIdOrEmail(dto.getMailTo());
		if(usuario == null) {
			return new ResponseEntity("No existe un usuario con esas credenciales", HttpStatus.NOT_FOUND);
		}
		
		String tokenPassword = "jhgsjdf.lkhsdlf.lkjhsdfk";
		usuario.setTokenPassword(tokenPassword);
		
		dto.setMailFrom(mailFrom);
		dto.setSubject(mailSubject);
		dto.setIdUsuario(usuario.getId());
		dto.setMailTo(usuario.getEmail());
		dto.setTokenPassword(tokenPassword);
		usuarioService.update(usuario);
		emailService.sendEmailTemplate(dto);
		return new ResponseEntity("Correo con plantilla enviado correctamente", HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/change-password")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO dto){
		
		if(!dto.getPassword().equals(dto.getConfirmPassword())) {
			return new ResponseEntity("Las contraseñas no coinciden", HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = usuarioService.getUsuarioByTokenPassword(dto.getTokenPassword());
		if(usuario == null) {
			return new ResponseEntity("No existe un usuario con esas credenciales", HttpStatus.NOT_FOUND);
		}
		
		String newPassword = passwordEncoder.encode(dto.getPassword());
		usuario.setPassword(newPassword);
		usuario.setTokenPassword(null);
		usuarioService.update(usuario);
		return new ResponseEntity("Contraseña actualizada", HttpStatus.OK);
	}
}
