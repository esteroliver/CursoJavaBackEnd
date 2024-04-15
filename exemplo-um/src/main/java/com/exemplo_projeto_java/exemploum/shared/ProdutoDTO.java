package com.exemplo_projeto_java.exemploum.shared;

public class ProdutoDTO {
    private int id;

    private String nome;

    private int quant;

    private double valor;

    private String obs;

//MÉTODOS
    public int getId() {
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

    public int getQuant() {
        return quant;
    }
    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public double getValor() {
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