package com.exemplo_projeto_java.exemploum.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo_projeto_java.exemploum.model.Produto;
import com.exemplo_projeto_java.exemploum.repository.ProdutoRepository;

@Service
public class ProdutoService {
//No service é que haverá as regras para pôr o produto e as exceções
    @Autowired
    private ProdutoRepository prodRepositorio;

    public List<Produto> ObterTodos(){
        return prodRepositorio.ObterTodos();
    }

    public Optional<Produto> ObterPorID(int id){
        return prodRepositorio.ObterPorID(id);
    }

    public Produto InserirProduto(Produto prod){
        return prodRepositorio.InserirProduto(prod);
    }

    public void DeletarProduto(int id){
        prodRepositorio.DeletarProduto(id);
    }

    public Produto AtualizarProduto(Produto prod, int id){
        prod.setId(id);
        return prodRepositorio.AtualizarProduto(prod);
    }
}
