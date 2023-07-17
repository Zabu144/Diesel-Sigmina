package com.app.mina.domain.cc;

import jakarta.persistence.*;

@Entity
@Table(name = "centro_de_custo")
public class Cc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo_cc;
    private String descricao_cc;

    public Cc(DadosCadastroCc dados) {
        this.codigo_cc = dados.codigo_cc();
        this.descricao_cc = dados.descricao_cc();
    }

    public Cc() {}

    @Override
    public String toString() {
        return "Cc{" +
                "id=" + id +
                ", codigo_cc='" + codigo_cc + '\'' +
                ", descricao_cc='" + descricao_cc + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCodigo_cc() {
        return codigo_cc;
    }

    public String getDescricao_cc() {
        return descricao_cc;
    }

    public void atualizaDados(DadosAlteracaoCc dados) {
        this.codigo_cc = dados.codigo_cc();
        this.descricao_cc = dados.descricao_cc();
    }
}
