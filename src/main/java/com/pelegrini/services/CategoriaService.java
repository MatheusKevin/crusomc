package com.pelegrini.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelegrini.domain.Categoria;
import com.pelegrini.repositories.CategoriaRepository;
import com.pelegrini.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);//Optiminal nova funcionalidade do Java 8 para envitar null pointer 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);//se o id não for nulo o método save irá considerar como atualização
		return repo.save(obj);
	}
}
