package com.exemplo_projeto_java.exemploum.repository;

import com.exemplo_projeto_java.exemploum.model.Produto;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
