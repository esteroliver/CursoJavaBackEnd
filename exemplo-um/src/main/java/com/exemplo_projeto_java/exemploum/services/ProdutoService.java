package com.exemplo_projeto_java.exemploum.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo_projeto_java.exemploum.model.Produto;
import com.exemplo_projeto_java.exemploum.model.exception.ResourceNotFoundException;
import com.exemplo_projeto_java.exemploum.repository.ProdutoRepository;
import com.exemplo_projeto_java.exemploum.shared.ProdutoDTO;

@Service
public class ProdutoService {
//No service é que haverá as regras para pôr o produto e as exceções (regras de negócio)
    @Autowired
    private ProdutoRepository prodRepositorio;

    public List<ProdutoDTO> ObterTodos(){
        List<Produto> produtos = prodRepositorio.findAll();

        List<ProdutoDTO> produtos_dto = produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class)).collect(Collectors.toList());

        //stream - percorre todos os elementos
        //map - gera mudanças em cada elemento percorrido
            //para cada produto em produtos, transforme-o na classe ProdutoDTO
        //para a conversão, as classes Produto e ProdutoDTO precisam ter os mesmos nomes nos atributos

        return produtos_dto;
    }

    public Optional<ProdutoDTO> ObterPorID(Integer id){
        Optional<Produto> produto = prodRepositorio.findById(id);
        if(produto.isEmpty()) throw new ResourceNotFoundException("Produto não encontrado.");
        ProdutoDTO produto_dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        //para transformar um optional<produto> em produto, é necessário utilizar o método get()
        return Optional.of(produto_dto); //transformando o produto_dto em optional para o retorno
    }

    public ProdutoDTO InserirProduto(ProdutoDTO prod){
        prod.setId(null); //colocamos o id como 0 para garantir que haja uma inserção, e não uma atualização
        Produto produto = new ModelMapper().map(prod, Produto.class); //convertemos o produtoDTO em produto
        produto = prodRepositorio.save(produto); //ao salvar o produto, um novo id vai ser atribuído a ele. fazemos com que o produto aponte para esse objeto, para que seu id seja salvo nessa variável temporária
        prod.setId(produto.getId()); //para retorna, precisamos setar o novo id, já que setamos anteriormente como sendo 0
        return prod;
    }

    public void DeletarProduto(Integer id){
        Optional<Produto> prod = prodRepositorio.findById(id);
        if(prod.isEmpty()) throw new ResourceNotFoundException("Produto não existe");
        prodRepositorio.deleteById(id); //deletando o produto pelo id
    }

    public ProdutoDTO AtualizarProduto(ProdutoDTO prod, Integer id){
        prod.setId(id);
        Produto produto = new ModelMapper().map(prod, Produto.class);
        prodRepositorio.save(produto);
        return prod;
    }
}
