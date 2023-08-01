package com.app.mina.domain.categoria;

import jakarta.persistence.*;

@Entity
@Table(name= "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sigla;
    private String nome;


    public Categoria(DadosCadastroCategoria dados) {
        this.sigla = dados.sigla();
        this.nome = dados.nome();
    }

    public Categoria() {}

    @Override
    public String toString() {
        return "Categoria{" +
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

    public void atualizaDados(DadosAlteracaoCategoria dados) {
        this.sigla = dados.sigla();
        this.nome = dados.nome();
    }
}
