package com.exemplo_projeto_java.exemploum.controller;


import org.springframework.web.bind.annotation.RestController;

import com.exemplo_projeto_java.exemploum.services.ProdutoService;
import com.exemplo_projeto_java.exemploum.model.Produto;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService prodService; 
    
    /**
     * Nessa seção, o método GET será reconhecido através do GetMapping
     */
    @GetMapping
    public List<Produto> ObterTodos(){
        return prodService.ObterTodos();
    }
    /**
     * Nessa seção, o método POST será reconhecido através do PostMapping
     * @param prod o parâmetro só será identificado pelo método através do RequestBody
     * @return
     */
    @PostMapping
    public Produto InserirProduto(@RequestBody Produto prod){
        return prodService.InserirProduto(prod);
    }
		//OS ID'S DOS PRODUTOS ALTERADOS/DELETADOS/OBTIDOS SÃO COLOCADOS NA URL
        //  localhost:8080/api/produtos/{id}
		/**
     * Esse método irá retornar um produto que for obtido por um ID. Esse ID será selecionado no GetMapping
     */
    @GetMapping("/{id}")
    public Optional<Produto> ObterPorID(@PathVariable int id){
        return prodService.ObterPorID(id);
    }
    /**
     * O produto será deletado através do DeleteMapping
     * @param id do produto que será deletado. Convertido para PathVariable
     */
    @DeleteMapping("/{id}")
    public void DeletarProduto(@PathVariable int id){
        prodService.DeletarProduto(id);
    }
    /**
     * Produto será atualizado através do PutMapping.
     * @param prod é o novo produto que será colocado no lugar do produto antigo
     * @param id id do produto antigo
     * @return retorna o novo produto
     */
    @PutMapping("/{id}")
    public Produto AtualizarProduto(@RequestBody Produto prod, @PathVariable int id){
        return prodService.AtualizarProduto(prod,id);
    }
   
}