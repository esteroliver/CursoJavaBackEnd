package com.exemplo_projeto_java.exemploum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity //indica que vai ser uma entidade no banco de dados
public class Produto {
    @Id //transforma esse id em uma chave primária (PK)
    @GeneratedValue(strategy = GenerationType.AUTO) // estratégia de atualização que a tabela vai fazer (auto-incremental)
    private Integer id;

    private String nome;

    private Integer quant;

    private double valor;

    private String obs;

//MÉTODOS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuant() {
        return quant;
    }
    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }
}