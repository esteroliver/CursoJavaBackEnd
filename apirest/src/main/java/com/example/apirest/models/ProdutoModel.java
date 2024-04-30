package com.example.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUTOS") //Irá criar uma tabela com esse nome.
public class ProdutoModel implements Serializable{
    //Número para controle de versão.
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto; //UUID é um identificador distribuído. É um identificador universal.
    private String nome;
    private BigDecimal valor;

    public UUID getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
