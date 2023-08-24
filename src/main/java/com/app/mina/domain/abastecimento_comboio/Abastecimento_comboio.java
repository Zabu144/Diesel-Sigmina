package com.app.mina.domain.abastecimento_comboio;

import com.app.mina.domain.abastecimento_posto.Abastecimento_posto;
import jakarta.persistence.*;

@Entity
@Table(name = "abastecimento_comboio")
public class Abastecimento_comboio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_abastecimento;
    private Double litros;
    private String operador_comboio;
    private String posto_ref;
    private String trabalhador;
    private String categoria_ref;
    private String sigla_cat_fk;
    private String equipamento;


    public Abastecimento_comboio(DadosCadastroAbastecimento_comboio dados) {
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.operador_comboio = dados.operador_comboio();
        this.posto_ref = dados.posto_ref();
        this.trabalhador = dados.trabalhador();
        this.categoria_ref = dados.categoria_ref();
        this.sigla_cat_fk = dados.sigla_cat_fk();
    }

    public Abastecimento_comboio() {

    }

    @Override
    public String toString() {
        return "Abastecimento_comboio{" +
                "id=" + id +
                ", data_abastecimento='" + data_abastecimento + '\'' +
                ", litros=" + litros +
                ", operador_comboio='" + operador_comboio + '\'' +
                ", posto_ref='" + posto_ref + '\'' +
                ", trabalhador='" + trabalhador + '\'' +
                ", categoria_ref='" + categoria_ref + '\'' +
                ", sigla_cat_fk='" + sigla_cat_fk + '\'' +
                ", equipamento='" + equipamento + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getData_abastecimento() {
        return data_abastecimento;
    }

    public Double getLitros() {
        return litros;
    }

    public String getOperador_comboio() {
        return operador_comboio;
    }

    public String getPosto_ref() {
        return posto_ref;
    }

    public String getTrabalhador() {
        return trabalhador;
    }

    public String getCategoria_ref() {
        return categoria_ref;
    }

    public String getSigla_cat_fk() {
        return sigla_cat_fk;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void atualizaDados(DadosAlteracaoAbastecimento_comboio dados) {
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.operador_comboio = dados.operador_comboio();
        this.posto_ref = dados.posto_ref();
        this.trabalhador = dados.trabalhador();
        this.categoria_ref = dados.categoria_ref();
        this.sigla_cat_fk = dados.sigla_cat_fk();
    }
}
