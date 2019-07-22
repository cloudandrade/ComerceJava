package com.jancloud.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jancloud.cursomc.model.Cliente;
import com.jancloud.cursomc.repository.ClienteRepository;
import com.jancloud.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
			Cliente obj = repo.findOne(id);
			if(obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName());
			}
			
			
			return obj;

	}

}
