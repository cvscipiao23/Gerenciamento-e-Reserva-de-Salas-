package br.com.reservasalas;

public class Recurso {
    private String id;
    private String nome;
    private String descricao;
    private RecursoTipo tipo;

    public Recurso(String id, String nome, String descricao, RecursoTipo tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public RecursoTipo getTipo() {
        return tipo;
    }

    public void setTipo(RecursoTipo tipo) {
        this.tipo = tipo;
    }
}
