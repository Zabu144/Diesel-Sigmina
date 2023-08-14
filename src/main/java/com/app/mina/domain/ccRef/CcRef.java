package com.app.mina.domain.ccRef;

import jakarta.persistence.*;
@Entity
@Table(name = "ccRef")
public class CcRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descricao;

    public CcRef(DadosCadastroCcRef dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }

    public CcRef() {}

    @Override
    public String toString() {
        return "CcRef{" +
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

    public void atualizaDados(DadosAlteracaoCcRef dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }
}
