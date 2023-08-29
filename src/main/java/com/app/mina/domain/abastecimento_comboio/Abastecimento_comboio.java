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
    private String tag_comboio;
    private String frentista;
    private String descricao;
    private String sigla_cat_fk;
    private String tag_eqp_fk;


    public Abastecimento_comboio(DadosCadastroAbastecimento_comboio dados) {
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.operador_comboio = dados.operador_comboio();
        this.tag_comboio = dados.tag_comboio();
        this.frentista = dados.frentista();
        this.descricao = dados.descricao();
        this.sigla_cat_fk = dados.sigla_cat_fk();
        this.tag_eqp_fk = dados.tag_eqp_fk();
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
                ", tag_comboio='" + tag_comboio + '\'' +
                ", frentista='" + frentista + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sigla_cat_fk='" + sigla_cat_fk + '\'' +
                ", tag_eqp_fk='" + tag_eqp_fk + '\'' +
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

    public String getTag_comboio() {
        return tag_comboio;
    }

    public String getFrentista() {
        return frentista;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla_cat_fk() {
        return sigla_cat_fk;
    }

    public String getTag_eqp_fk() {
        return tag_eqp_fk;
    }

    public void atualizaDados(DadosAlteracaoAbastecimento_comboio dados) {
        this.data_abastecimento = dados.data_abastecimento();
        this.litros = dados.litros();
        this.operador_comboio = dados.operador_comboio();
        this.tag_comboio = dados.tag_comboio();
        this.frentista = dados.frentista();
        this.descricao = dados.descricao();
        this.sigla_cat_fk = dados.sigla_cat_fk();
        this.tag_eqp_fk = dados.tag_eqp_fk();
    }
}
