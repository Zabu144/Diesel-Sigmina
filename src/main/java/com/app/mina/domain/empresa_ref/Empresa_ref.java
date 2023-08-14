package com.app.mina.domain.empresa_ref;

import jakarta.persistence.*;
@Entity
@Table(name = "empresa_ref")
public class Empresa_ref {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private Boolean habilitar;

    public Empresa_ref(DadosCadastroEmpresa_ref dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.habilitar = dados.habilitar();
    }

    public Empresa_ref() {}

    @Override
    public String toString() {
        return "Empresa_ref{" +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", habilitar=" + habilitar +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Boolean getHabilitar() {
        return habilitar;
    }

    public void atualizaDados(DadosAlteracaoEmpresa_ref dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.habilitar = dados.habilitar();
    }
}
