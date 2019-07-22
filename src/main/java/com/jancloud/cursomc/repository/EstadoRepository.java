package com.jancloud.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jancloud.cursomc.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	public Estado findById(Integer id);

}
