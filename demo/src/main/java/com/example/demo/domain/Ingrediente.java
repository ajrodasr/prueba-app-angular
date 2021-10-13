package com.example.demo.domain;

public class Ingrediente {
	
	public enum Tipo {
		PESCADO,
		CARNE,
		PASTA,
		LEGUMBRE
	}
	
	private int id;
	private String nombre;
	private Tipo tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}