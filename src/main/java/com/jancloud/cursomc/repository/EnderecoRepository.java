package com.jancloud.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jancloud.cursomc.model.Cliente;
import com.jancloud.cursomc.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	public Endereco findById(Integer id);

}
