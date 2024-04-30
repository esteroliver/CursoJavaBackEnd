package com.example.apirest.repositories;

import com.example.apirest.models.ProdutoModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID>{
       
}
