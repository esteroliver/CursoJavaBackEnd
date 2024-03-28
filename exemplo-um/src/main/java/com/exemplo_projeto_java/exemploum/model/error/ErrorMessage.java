package com.exemplo_projeto_java.exemploum.model.error;

public class ErrorMessage {
    private String titulo;
    private String descricao;
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ErrorMessage(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }
}
