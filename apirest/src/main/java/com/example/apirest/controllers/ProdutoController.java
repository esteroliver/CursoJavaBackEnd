package com.example.apirest.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.dtos.ProdutoRecordDTO;
import com.example.apirest.models.ProdutoModel;
import com.example.apirest.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    /*
     * MÉTODOS
     * - Salvar produto
     * - Obter produto por ID
     * - Obter todos
     * - Atualizar produto
     * - Deletar produto
     */
    @PostMapping("/produtos")
    //O retorno será um ResponseEntity do tipo ProdutoModel.
    //O ResponseEntity representa um response HTTP, com status HTTP e corpo. Dessa forma, podemos visualizar o HTTP response em totalidade.
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoRecordDTO produtoDTO) {
        //O ProdutoModel serve para salvar na base de dados, e o ProdutoRecordDTO serve para ser o request do cliente. Recebemos o produtoDTO, armazenamos o produtoModel.
        ProdutoModel produtoModel = new ProdutoModel();
        //Convertendo um ProdutoRecordDTO em ProdutoModel
        BeanUtils.copyProperties(produtoDTO, produtoModel);
        //Salvando o ProdutoModel e enviando o status HTTP
        produtoRepository.save(produtoModel)
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModel);
    }
    
    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> obterTodosProdutos() {
        List<ProdutoModel> produtos;
        produtos = produtoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Object> obterProduto(@PathVariable UUID id) {
        Optional<ProdutoModel> prod = produtoRepository.findById(id);
        if(prod.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse produto não foi encontrado.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(prod.get());
    }
    
    @PutMapping("/produtos/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable UUID id, @RequestBody ProdutoRecordDTO produtoDTO) {
        Optional<ProdutoModel> prod = produtoRepository.findById(id);
        if(prod.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse produto não foi encontrado.");
        }
        ProdutoModel prodnovo = prod.get();
        BeanUtils.copyProperties(produtoDTO, prodnovo);
        produtoRepository.save(prodnovo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(prodnovo);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable UUID id){
        Optional<ProdutoModel> prod = produtoRepository.findById(id);
        if(prod.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse produto não foi encontrado.");
        }
        produtoRepository.delete(prod.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
}
