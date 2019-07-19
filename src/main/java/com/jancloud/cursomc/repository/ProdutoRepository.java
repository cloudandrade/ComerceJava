package com.jancloud.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jancloud.cursomc.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	public Produto findById(Integer id);

}
