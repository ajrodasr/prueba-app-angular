package com.example.demo.emailpassword.dto;

public class EmailValuesDTO {
	
	private String mailFrom;
	private String mailTo;
	private String subject;
	private String idUsuario;
	private String tokenPassword;
	
	public EmailValuesDTO() {}
	
	public EmailValuesDTO(String mailForm, String mailTo, String subject, String idUsusario, String tokenPassword) {
		this.mailFrom = mailForm;
		this.mailTo = mailTo;
		this.subject = subject;
		this.idUsuario = idUsusario;
		this.tokenPassword = tokenPassword;
	}
	
	
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTokenPassword() {
		return tokenPassword;
	}
	public void setTokenPassword(String tokenPassword) {
		this.tokenPassword = tokenPassword;
	}
	
	
	
}
