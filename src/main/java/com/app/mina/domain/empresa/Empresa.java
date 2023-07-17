package com.app.mina.domain.empresa;

import jakarta.persistence.*;
@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private Boolean habilitar;

    public Empresa(DadosCadastroEmpresa dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.habilitar = dados.habilitar();
    }

    public Empresa() {}

    @Override
    public String toString() {
        return "Empresa{" +
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

    public void atualizaDados(DadosAlteracaoEmpresa dados) {
        this.nome = dados.nome();
        this.cnpj = dados.cnpj();
        this.habilitar = dados.habilitar();
    }
}
