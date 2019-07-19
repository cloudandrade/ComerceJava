package com.jancloud.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jancloud.cursomc.model.Categoria;
import com.jancloud.cursomc.repository.CategoriaRepository;
import com.jancloud.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
			Categoria obj = repo.findOne(id);
			if(obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Categoria.class.getName());
			}
			
			
			return obj;

	}

}
