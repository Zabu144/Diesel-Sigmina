package com.app.mina.domain.cc_ref;

import jakarta.persistence.*;
@Entity
@Table(name = "cc_ref")
public class Cc_ref {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descricao;

    public Cc_ref(DadosCadastroCc_ref dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }

    public Cc_ref() {}

    @Override
    public String toString() {
        return "Cc_ref{" +
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

    public void atualizaDados(DadosAlteracaoCc_ref dados) {
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
    }
}
