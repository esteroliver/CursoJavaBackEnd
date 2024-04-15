package com.exemplo_projeto_java.exemploum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity //indica que vai ser uma entidade no banco de dados
public class Produto {
    @Id //transforma esse id em uma chave primária (PK)
    @GeneratedValue(strategy = GenerationType.AUTO) // estratégia de atualização que a tabela vai fazer (auto-incremental)
    private int id;

    private String nome;

    private int quant;

    private double valor;

    private String obs;

//MÉTODOS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObs() {
        return obs;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }
}