package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Ingrediente;

@Mapper
public interface IngredientesRepository {
	
	public List<Ingrediente> getIngredientes();
	
}
