package com.app.mina.domain.categoria;

import jakarta.persistence.*;

@Entity
@Table(name= "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String nome;


    public Categoria(DadosCadastroCategoria dados) {
        this.tag = dados.tag();
        this.nome = dados.nome();
    }

    public Categoria() {}

    @Override
    public String toString() {
        return "Categoria{" +
                "tag='" + tag + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getNome() {
        return nome;
    }

    public void atualizaDados(DadosAlteracaoCategoria dados) {
        this.tag = dados.tag();
        this.nome = dados.nome();
    }
}
