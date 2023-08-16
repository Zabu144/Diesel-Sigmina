package com.app.mina.domain.categoria_ref;

import jakarta.persistence.*;

@Entity
@Table(name= "categoria_ref")
public class Categoria_ref {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigla;
    private String nome;


    public Categoria_ref(DadosCadastroCategoria_ref dados) {
        this.sigla = dados.sigla();
        this.nome = dados.nome();
    }

    public Categoria_ref() {}

    @Override
    public String toString() {
        return "Categoria_ref{" +
                "tag='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public void atualizaDados(DadosAlteracaoCategoria_ref dados) {
        this.sigla = dados.sigla();
        this.nome = dados.nome();
    }
}
