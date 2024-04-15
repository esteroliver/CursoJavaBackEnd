package com.exemplo_projeto_java.exemploum.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.exemplo_projeto_java.exemploum.model.Produto;
import com.exemplo_projeto_java.exemploum.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository_old {
    private List<Produto> prods = new ArrayList<Produto>();
    private int counter = 0;

    /**
     * Método que retorna todos os produtos.
     * @return Lista de Produto.
     */
    public List<Produto> ObterTodos(){
        return prods;
    }

    /**
     * Método que retorna o produto encontrado pelo seu ID.
     * @param id do produto a ser encontrado.
     * @return Retorna um produto caso seja encontrado.
     * stream() - método para percorrer listas
     * filter() - filtra todos os objetos que correspondem ao parâmetro, retornando uma lista
     * findFirst() - retorna apenas o primeiro elemento que obedeceu ao filter
     */
    public Optional<Produto> ObterPorID(int id){
        return prods.stream().filter(Produto -> Produto.getId() == id).findFirst();
    }
    /**
     * Método para adicionar produto à lista.
     * @param prod produto a ser inserido.
     */
    public Produto InserirProduto(Produto prod){
        counter++;
        prod.setId(counter);
        prods.add(prod);
        return prod;
    }
    
    /**
     * Método para deletar um produto a partir do seu ID.
     * @param id ID do produto a ser deletado.
     */
    public void DeletarProduto(int id){
        prods.removeIf(Produto -> Produto.getId() == id);
    }

    /**
     * Método para atualizar um produto em uma lista. Primeiro irá encontrar o produto, depois deletá-lo e depois inserí-lo com as atualizações na lista.
     * @param prod produto com as devidas atualizações.
     * @return Retorna o produto atualizado.
     */
    public Produto AtualizarProduto(Produto prod){
        //É necessário remover o produto antigo da lista e depois adicionar o novo produto
    
        //ENCONTRAR
        Optional<Produto> produtoEncontrado = ObterPorID(prod.getId());
        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        //DELETAR
        DeletarProduto(prod.getId());

        //INSERIR
        prods.add(prod);

        return prod;
    }
}
