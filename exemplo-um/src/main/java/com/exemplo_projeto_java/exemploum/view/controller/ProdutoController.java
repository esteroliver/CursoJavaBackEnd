package com.exemplo_projeto_java.exemploum.view.controller;


import org.springframework.web.bind.annotation.RestController;

import com.exemplo_projeto_java.exemploum.services.ProdutoService;
import com.exemplo_projeto_java.exemploum.shared.ProdutoDTO;
import com.exemplo_projeto_java.exemploum.view.model.ProdutoRequest;
import com.exemplo_projeto_java.exemploum.view.model.ProdutoResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProdutoResponse>> ObterTodos(){
        List<ProdutoDTO> produtos = prodService.ObterTodos();
        List<ProdutoResponse> produtos_response = produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(produtos_response, HttpStatus.OK);
    }
    /**
     * Nessa seção, o método POST será reconhecido através do PostMapping
     * @param prod o parâmetro só será identificado pelo método através do RequestBody
     * @return
     */
    @PostMapping
    public ResponseEntity<ProdutoResponse> InserirProduto(@RequestBody ProdutoRequest prod){
        ProdutoDTO dto = new ModelMapper().map(prod, ProdutoDTO.class);
        dto = prodService.InserirProduto(dto);
        ProdutoResponse response = new ModelMapper().map(dto, ProdutoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
		//OS ID'S DOS PRODUTOS ALTERADOS/DELETADOS/OBTIDOS SÃO COLOCADOS NA URL
        //  localhost:8080/api/produtos/{id}
		/**
     * Esse método irá retornar um produto que for obtido por um ID. Esse ID será selecionado no GetMapping
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> ObterPorID(@PathVariable Integer id){
        ProdutoDTO dto = prodService.ObterPorID(id);
        ProdutoResponse produto_response = new ModelMapper().map(dto, ProdutoResponse.class);
        return new ResponseEntity<>(produto_response, HttpStatus.OK);

    }
    /**
     * O produto será deletado através do DeleteMapping
     * @param id do produto que será deletado. Convertido para PathVariable
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeletarProduto(@PathVariable Integer id){
        prodService.DeletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * Produto será atualizado através do PutMapping.
     * @param prod é o novo produto que será colocado no lugar do produto antigo
     * @param id id do produto antigo
     * @return retorna o novo produto
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> AtualizarProduto(@RequestBody ProdutoRequest prod, @PathVariable Integer id){
        ProdutoDTO dto = new ModelMapper().map(prod, ProdutoDTO.class);
        dto = prodService.AtualizarProduto(dto, id);
        ProdutoResponse response = new ModelMapper().map(dto, ProdutoResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
   
}