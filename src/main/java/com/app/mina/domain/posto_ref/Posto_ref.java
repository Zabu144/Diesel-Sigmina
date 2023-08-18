package com.app.mina.domain.posto_ref;

import jakarta.persistence.*;

@Entity
@Table(name = "posto_ref")
public class Posto_ref {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descricao;
    private String sigla;
    private String equipamento;

    public Posto_ref(DadosCadastroPosto_ref dados) {
        this.tipo = dados.tipo();
        this.descricao = dados.descricao();
        this.sigla = dados.sigla();
        this.equipamento = dados.equipamento();
    }

    public Posto_ref(){}

    @Override
    public String toString() {
        return "Posto_ref{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sigla='" + sigla + '\'' +
                ", equipamento='" + equipamento + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getTag_eqp_fk() {
        return equipamento;
    }

    public void atualizaDados(DadosAlteracaoPosto_ref dados) {
        this.tipo = dados.tipo();
        this.descricao = dados.descricao();
        this.sigla = dados.sigla();
        this.equipamento = dados.equipamento();
    }
}
