package com.app.mina.domain.posto;

import jakarta.persistence.*;

@Entity
@Table(name = "posto")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;

    public Posto(DadosCadastroPosto dados) {
        this.nome = dados.nome();
        this.tipo = dados.tipo();
    }

    public Posto(){}

    @Override
    public String toString() {
        return "Posto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void atualizaDados(DadosAlteracaoPosto dados) {
        this.nome = dados.nome();
        this.tipo = dados.tipo();
    }
}
