package com.app.mina.domain.custos;

import jakarta.persistence.*;
@Entity
@Table(name = "custos")
public class Custos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descricao;

    public Custos(DadosCadastroCustos dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }

    public Custos() {}

    @Override
    public String toString() {
        return "Custos{" +
                ", codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void atualizaDados(DadosAlteracaoCustos dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }
}
